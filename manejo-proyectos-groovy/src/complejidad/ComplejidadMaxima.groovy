package complejidad;

import tareas.TareaSimple;

class ComplejidadMaxima extends Complejidad {

  public static final CANTIDAD_DIAS_EXTRA = 10
  public static final PORCENTAJE_COMPLEJIDAD_MAXIMA = 7
  public static final PRECIO_POR_DIA_EXTRA = 10

  @Override
  def getCostoTarea(tarea) {
    double costoTarea = costoMinimoPorTarea(tarea) * (1 + PORCENTAJE_COMPLEJIDAD_MAXIMA / 100)
    if (tarea.cantidadDias <= CANTIDAD_DIAS_EXTRA)
      costoTarea
    else
      costoTarea + ((tarea.cantidadDias - CANTIDAD_DIAS_EXTRA) * PRECIO_POR_DIA_EXTRA)
  }
}
