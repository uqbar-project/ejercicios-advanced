package ar.edu.tadp.frba.tadp.clase2;

/**
 * Algunos pagers.
 * 
 * Bien se podría haber definido clases concretas, como en la versión Java,
 * que definan el método notificar, pero para mostrar la flexiblidad del lenguaje, que soporta
 * también una orientación a objetos prototipada, alla JS, acá se implementan sin usar clases.  
 *  
 * @author flbulgarelli
 */
class Pagers {
  
  static def nullPager = [notificar:{}]
  
  static def errorPager = [notificar: {throw new NoSePuedeNotificarException()}]

}
