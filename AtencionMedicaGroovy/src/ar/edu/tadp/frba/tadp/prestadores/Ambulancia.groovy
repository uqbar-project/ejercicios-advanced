package ar.edu.tadp.frba.tadp.prestadores

import java.util.ArrayList
import java.util.Arrays
import java.util.Collection
import java.util.List

import ar.edu.tadp.frba.tadp.clase2.Pedido

/**
 * Ambulancia que posee un equipo medico
 */
class Ambulancia extends Prestador {
  final medicos

  /**
   * El hecho de que sea una lista garantiza que se atiendan por orden de
   * llegada.
   */
  final pedidosAsignados = []


  Ambulancia(medicos) {
    this.medicos = medicos
  }

  // ********************************************************
  // ** Verificar si puede atender
  // ********************************************************

  @Override
  protected def sosAptoParaAtender(pedido) {
    medicos.any { it.podesAtender(pedido) }
  }

  def tenesDisponibilidadPara(pedido) {
    pedidosAsignados.empty || mismaZona(pedido)
  }

  // ********************************************************
  // ** Asignación de pedidos
  // ********************************************************

  @Override
  def asignarPedido(pedido) {
    pedidosAsignados.add(pedido)
  }

  @Override
  def finalizarPedido(pedido) {
    pedidosAsignados.remove(pedido)

  }

  // ********************************************************
  // ** Zona
  // ********************************************************

  def mismaZona(pedidoNuevo) {
    ultimoPedido().direccion.esCercaDe(pedidoNuevo.direccion)
  }

  def ultimoPedido() {
    pedidosAsignados.get(pedidosAsignados.size() - 1)
  }

}
