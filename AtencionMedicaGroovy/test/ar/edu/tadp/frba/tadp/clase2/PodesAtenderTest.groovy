package ar.edu.tadp.frba.tadp.clase2

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import static TestConstants.*
import ar.edu.tadp.frba.tadp.prestadores.Ambulancia
import ar.edu.tadp.frba.tadp.prestadores.Especialidad
import ar.edu.tadp.frba.tadp.prestadores.Medico

class PodesAtenderTest  {
  def pedidoTraumatologia = new Pedido(Especialidad.TRAUMATOLOGIA, MEDRANO_951)
  def pedidoClinico = new Pedido(Especialidad.CLINICA, MEDRANO_951)
  def pedidoCardiologia = new Pedido(Especialidad.CARDIOLOGIA, MEDRANO_951)

  def traumatologo = new Medico(Especialidad.TRAUMATOLOGIA, Pagers.nullPager)
  def cardiologo = new Medico(Especialidad.CARDIOLOGIA, Pagers.nullPager)
  def clinico = new Medico(Especialidad.CLINICA, Pagers.nullPager)
  def equipo1
  def equipo2

  @Before
  void inicializacionDelTest() {
    equipo1 = new Ambulancia([traumatologo, clinico])
    equipo2 = new Ambulancia([cardiologo, clinico])
  }

  @Test
  void medicoDeMismaEspecialidadPuedeAtenderPedido() {

    assertTrue(traumatologo.podesAtender(pedidoTraumatologia))
  }

  @Test
  void medicoDeOtraEspecialidadNoPuedeAtenderPedido() {
    assertFalse(cardiologo.podesAtender(pedidoTraumatologia))
    assertTrue(cardiologo.podesAtender(pedidoCardiologia))
  }

  @Test
  void ambulanciaConMedicoDeLaEspecialidadPuedeAtenderPedido() {
    assertTrue(equipo1.podesAtender(pedidoTraumatologia))
  }

  @Test
  void ambulanciaPedidoMedicoDeLaEspecialidad() {
    assertTrue(equipo2.podesAtender(pedidoClinico))
    assertFalse(equipo2.podesAtender(pedidoTraumatologia))
  }
}
