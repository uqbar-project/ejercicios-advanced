package ar.edu.tadp.frba.tadp.prestadores

import ar.edu.tadp.frba.tadp.clase2.Pedido

/**
 * Prestador es cualquier elemento del sistema que puede ser asignado apra
 * atender un pedido.
 * 
 * @author npasserini
 */
abstract class Prestador {

  def podesAtender(pedido) {
    sosAptoParaAtender(pedido) && tenesDisponibilidadPara(pedido)
  }

  protected abstract def sosAptoParaAtender(pedido)

  abstract def tenesDisponibilidadPara(pedido)

  abstract def finalizarPedido(pedido)

  abstract def asignarPedido(pedido)
}
