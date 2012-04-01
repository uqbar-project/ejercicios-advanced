package ar.edu.tadp.frba.tadp.clase2

import groovy.transform.TupleConstructor
import ar.edu.tadp.frba.tadp.prestadores.Especialidad

@TupleConstructor
class Pedido {
  final especialidad
  final direccion
}
