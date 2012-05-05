package ar.edu.tadp.frba.tadp.prestadores

import ar.edu.tadp.frba.tadp.clase2.NoSePuedeNotificarException
import ar.edu.tadp.frba.tadp.clase2.Pagers;

class Medico extends Prestador {
  final especialidad
  def pedidoAsignado 
  def pager

  Medico(especialidad, pager) {
    this.especialidad = especialidad
    this.pager = pager
  }

  @Override
  protected def sosAptoParaAtender(pedido) {
    pedido.especialidad == especialidad
  }

  @Override
  def tenesDisponibilidadPara(pedido) {
    pedidoAsignado == null
  }

  @Override
  def asignarPedido(pedido) {
    pedidoAsignado = pedido
    try {
      pager.notificar(pedido)
    } catch (NoSePuedeNotificarException e) {
      pedidoAsignado = null
      throw e
    }
  }

  @Override
  def finalizarPedido(pedido) {
    pedidoAsignado = null
  }
}
