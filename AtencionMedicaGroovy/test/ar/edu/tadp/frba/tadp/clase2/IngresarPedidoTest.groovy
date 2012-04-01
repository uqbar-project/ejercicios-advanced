package ar.edu.tadp.frba.tadp.clase2

import static TestConstants.*
import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

import ar.edu.tadp.frba.tadp.prestadores.Especialidad
import ar.edu.tadp.frba.tadp.prestadores.Medico

class IngresarPedidoTest  {

  def pedidoTraumatologia = new Pedido(Especialidad.TRAUMATOLOGIA, MEDRANO_951)
  def cardiologo = new Medico(Especialidad.CARDIOLOGIA, Pagers.nullPager)
  def clinico = new Medico(Especialidad.CLINICA, Pagers.nullPager)
  def equipo1
  def equipo2

  @Before
  void initialize (){
    Clinica.initialize(new MapaMock(), cardiologo)
  }

  @Test(expected=NoHayPrestadorDisponibleException.class)
  void noHayPrestadorApto(){
    Clinica.getInstance().ingresarPedido(pedidoTraumatologia)
  }

  @Test
  void hayPrestadorApto(){
    assertEquals(cardiologo, Clinica.getInstance().ingresarPedido(new Pedido(Especialidad.CARDIOLOGIA, MEDRANO_951)))
  }
}
