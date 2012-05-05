package ar.edu.tadp.frba.tadp.clase2

import groovy.transform.TupleConstructor

import java.util.ArrayList
import java.util.Arrays
import java.util.Collection

import ar.edu.tadp.frba.tadp.prestadores.Prestador

@TupleConstructor
class Clinica {
  final mapa
  final prestadores

  def ingresarPedido(pedido) {
    for (def prestador : prestadoresPara(pedido)) {
      try {
        prestador.asignarPedido(pedido)
        return prestador
      }
      catch (NoSePuedeNotificarException e) {
        continue
      }
    }
    throw new NoHayPrestadorDisponibleException()
  }

  def prestadoresPara(unPedido) {
    prestadores.findAll { it.podesAtender(unPedido) }
  }

  static clinica

  static def getInstance() {
    clinica
  }

  static def initialize (mapa, prestadores) {
    clinica = new Clinica(mapa, prestadores)
  }
}
