package complejidad;

import tareas.TareaSimple;

/**
 * Esta clase representa la complejidad de cada tarea.
 * A partir de esta clase se podra calcucar el costo de cada tarea, ya que depende de la complejidad.
 * 
 * La complejidad de cada tarea se puede cambiar en tiempo de ejecucion. 
 * 
 * @author deby
 *
 */
abstract class Complejidad {

  public static final COSTO_MINIMO_TAREA = 25.0;

  abstract def getCostoTarea(tarea)

  /**
   * Todas las tareas tienen un costo mínimo de 
   * la cantidad de días por un costo.
   * 
   *  @param tareaSimple a la que se le aplicará el costo mínimo
   *  @return costo mínimo de la tarea
   */
  def costoMinimoPorTarea(tareaSimple) {
    tareaSimple.cantidadDias * COSTO_MINIMO_TAREA
  }
}
