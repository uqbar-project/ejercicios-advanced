package test

import static junit.framework.Assert.*

import org.junit.Before
import org.junit.Test

import complejidad.ComplejidadMaxima
import complejidad.ComplejidadMedia
import complejidad.ComplejidadMinima

import proyecto.Impuesto
import proyecto.Proyecto
import tareas.TareaCompuesta
import tareas.TareaSimple

class TestManejoDeProyecto {

  def impuestoA = new Impuesto(3)
  def impuestoB = new Impuesto(5)
  def minima = new ComplejidadMinima()
  def media = new ComplejidadMedia()
  def maxima = new ComplejidadMaxima()
  def tareaSimple1
  def tareaSimple2
  def tareaSimple3
  def tareaSimple4
  def tareaCompuesta1
  def tareaCompuesta2
  def proyecto

  @Before
  void setUp () {
    tareaSimple1 = new TareaSimple(minima, 2, [impuestoA])
    tareaSimple2 = new TareaSimple(media, 3, [impuestoB])
    tareaSimple3 = new TareaSimple(maxima, 4, [impuestoA, impuestoB])
    tareaSimple4 = new TareaSimple(maxima, 12, [impuestoA])

    tareaCompuesta2 = new TareaCompuesta([tareaSimple3, tareaSimple4])

    tareaCompuesta1 = new TareaCompuesta([
      tareaSimple2,
      tareaCompuesta2
    ])


    proyecto = new Proyecto([
      tareaSimple1,
      tareaCompuesta1
    ])
  }

  @Test
  void costoTareasSimples() {
    //25 * 2 + impuestoA 0.03
    assertEquals(51.5, tareaSimple1.costo, 0.001)

    //25 * 3 + impuestoB 0.05
    assertEquals(82.6875, tareaSimple2.costo, 0.001)

    //25 * 4 + impuest0A 0.03 + impuestoB 0.05
    assertEquals(115.56, tareaSimple3.costo, 0.001)

    //25 * 12 + impuestoA 0.03 + 2 tareas extras
    assertEquals(351.23, tareaSimple4.costo, 0.001)
  }

  @Test
  void costoTareasCompuestas() {
    // la tarea compuesta2 tiene como subtareas la tarea simple 3 y tarea simple 4
    assertEquals(466.79, tareaCompuesta2.costo, 0.001)

    // la tarea compuesta1 tiene como subtareas la tarea simple 2 y la tarea compuesta 2
    assertEquals(549.4775, tareaCompuesta1.costo, 0.001)
  }

  @Test
  void costoProyecto() {
    // el proyecto tiene 2 tareas, tarea simple 1 y tarea compuesta 1
    assertEquals(600.977, proyecto.costoProyecto, 0.001)
  }
}
