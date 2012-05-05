package tareas;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Esta clase representa la tarea compuesta, es decir, aquella que tiene subareas.
 * Por lo tanto el costo y el tiempo total de estas tareas dependera de sus subtareas.
 * Por ejemplo, si una tarea compuesta tiene dos tareas simples de 2 y 3 dias, el tiempo
 * total de esta tarea sera de 5 dias. Lo mismo para calcular el costo.
 * 
 * A su vez una tarea compuesta puede tener otras tareas compuestas entre sus subtareas.
 * 
 * @author deby
 *
 */
class TareaCompuesta {

  final tareas

  TareaCompuesta(tareas) {
    this.tareas = tareas
  }

  /** 
   * El costo de la tarea compuesta depende de la suma del costo de las subtareas (tanto simple como compuestas)
   */
  def getCosto() {
    tareas.collect { it.costo }.sum()
  }
}
