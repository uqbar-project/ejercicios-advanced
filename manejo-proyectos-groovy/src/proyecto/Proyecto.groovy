package proyecto;

class Proyecto {

  final tareas
  
  def Proyecto(tareas) {
    this.tareas = tareas
  }
	
  def getCostoProyecto() {
    tareas.collect { it.costo }.sum()
	}
}
