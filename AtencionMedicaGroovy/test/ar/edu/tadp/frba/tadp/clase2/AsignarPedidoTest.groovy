package ar.edu.tadp.frba.tadp.clase2

import static TestConstants.*
import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertTrue

import org.junit.Before
import org.junit.Test

import ar.edu.tadp.frba.tadp.prestadores.Ambulancia
import ar.edu.tadp.frba.tadp.prestadores.Especialidad
import ar.edu.tadp.frba.tadp.prestadores.Medico

class AsignarPedidoTest  {
  def clinico = new Medico(Especialidad.CLINICA, Pagers.nullPager)
  def ambulancia = new Ambulancia([clinico])
  def pedido = new Pedido(Especialidad.CLINICA, MEDRANO_951)
  def otroPedidoEnLaMismaZona = new Pedido(Especialidad.CLINICA, HONDURAS_3895)
  def otroPedidoMasLejano = new Pedido(Especialidad.CLINICA, MOZART_2300)

  @Before
  void initialize() {
    Clinica.initialize(new MapaMock(), [])
  }

  @Test
  void medicoNoPuedeAtenderMasDeUnPedidoPorVez() {
    // Luego de asignar un pedido no se le puede asignar otro
    clinico.asignarPedido(pedido)
    assertFalse(clinico.tenesDisponibilidadPara(otroPedidoEnLaMismaZona))
    assertFalse(clinico.tenesDisponibilidadPara(otroPedidoMasLejano))

    // Si finalizo el primer pedido ahora sí tiene disponibilidad.
    clinico.finalizarPedido(pedido)
    assertTrue(clinico.tenesDisponibilidadPara(otroPedidoEnLaMismaZona))
  }

  @Test
  void ambulanciaPuedeAtenderSiEstaLibre() {
    assertTrue(ambulancia.tenesDisponibilidadPara(pedido))
  }

  @Test
  void ambulanciaPuedeAtenderPedidosEnLaZona() {
    ambulancia.asignarPedido(pedido)
    assertTrue(ambulancia.tenesDisponibilidadPara(otroPedidoEnLaMismaZona))
  }

  @Test
  void ambulanciaNoPuedeAtenderPedidosEnOtraZona() {
    ambulancia.asignarPedido(pedido)
    assertFalse(ambulancia.tenesDisponibilidadPara(otroPedidoMasLejano))
  }
}



