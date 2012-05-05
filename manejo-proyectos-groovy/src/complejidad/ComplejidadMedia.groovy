package complejidad;

import tareas.TareaSimple;

class ComplejidadMedia extends Complejidad {

  public static final PORCENTAJE_COMPLEJIDAD_MEDIA = 5;

  @Override
  def getCostoTarea(tarea) {
    costoMinimoPorTarea(tarea) * (1 + PORCENTAJE_COMPLEJIDAD_MEDIA / 100)
  }
}
