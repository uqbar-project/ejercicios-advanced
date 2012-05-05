package complejidad;

import tareas.TareaSimple;

class ComplejidadMinima extends Complejidad {

  @Override
  def getCostoTarea(tareaSimple) {
    // uso el metodo de la super clase ya que la complejidad minima
    // no le agrega nada mas que el costo minimo que tienen todas las tareas.
    costoMinimoPorTarea(tareaSimple);
  }
}
