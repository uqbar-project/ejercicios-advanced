package ar.edu.tadp.frba.tadp.clase2

import static TestConstants.*
import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import ar.edu.tadp.frba.tadp.prestadores.Ambulancia
import ar.edu.tadp.frba.tadp.prestadores.Especialidad
import ar.edu.tadp.frba.tadp.prestadores.Medico

public class EncontrarPrestadoresTest {

  def pedidoTraumatologia = new Pedido(Especialidad.TRAUMATOLOGIA, MEDRANO_951)
  def traumatologo = new Medico(Especialidad.TRAUMATOLOGIA, Pagers.nullPager)
  def cardiologo = new Medico(Especialidad.CARDIOLOGIA, Pagers.nullPager)
  def clinico = new Medico(Especialidad.CLINICA, Pagers.nullPager)
  def equipo1
  def equipo2
  def clinica

  @Before
  void inicializacionDelTest() {
    equipo1 = new Ambulancia([traumatologo, clinico])
    equipo2 = new Ambulancia([cardiologo, clinico])
    clinica = new Clinica(null, [
      traumatologo,
      cardiologo,
      clinico,
      equipo1,
      equipo2
    ])
  }

  @Test
  void prestadoresQuePuedenAtender() {
    def prestadores = clinica.prestadoresPara(pedidoTraumatologia)

    assertTrue(prestadores.contains(traumatologo))
    assertTrue(prestadores.contains(equipo1))
    assertEquals(2, prestadores.size())
  }
}
