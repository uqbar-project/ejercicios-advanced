package ar.edu.tadp.frba.tadp.clase2
import static ar.edu.tadp.frba.tadp.clase2.TestConstants.*

class MapaMock {

  def sonCercanas(direccion, otraDireccion) {
    return direccion == otraDireccion ||
    (direccion == MEDRANO_951 && otraDireccion == HONDURAS_3895) ||
    (direccion == HONDURAS_3895 && otraDireccion == MEDRANO_951)
  }
}
