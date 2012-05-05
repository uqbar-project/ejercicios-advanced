package tareas;

import java.util.ArrayList;
import java.util.Collection;

import proyecto.Impuesto;

import complejidad.Complejidad;


/**
 * Esta tarea representa una tarea "final", a la que se la calcula la cantidad de dias
 * y el costo segun la complejidad.
 * Esta tarea no puede tener subtareas.
 * 
 * @author deby
 */
class TareaSimple {

  final complejidad
  final cantidadDias
  final impuestos

  TareaSimple(complejidad, cantidadDias, impuestos) {
    this.complejidad = complejidad
    this.cantidadDias = cantidadDias
    this.impuestos = impuestos
  }

  def getCosto() {
    complejidad.getCostoTarea(this) * (1 + porcentajeImpuestos / 100);
  }

  /** 
   * Sumo todos los impuesto que se le hayan aplicado a esta tarea
   */
  protected def getPorcentajeImpuestos() {
    impuestos.collect { it.porcentajeImpuesto }.sum()
  }
}
