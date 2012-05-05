package ar.edu.tadp.frba.tadp.clase2

import groovy.transform.TupleConstructor

@TupleConstructor
class Direccion {
  final calle
  final numero

  boolean esCercaDe(otraDireccion) {
    Clinica.instance.mapa.sonCercanas(this, otraDireccion)
  }
}
