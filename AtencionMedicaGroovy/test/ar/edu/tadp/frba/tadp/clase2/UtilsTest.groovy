package ar.edu.tadp.frba.tadp.clase2

import java.util.Calendar

import org.junit.Test

class UtilsTest {

  @Test
  void dateTest() {
    Calendar cal = Calendar.getInstance()
    System.out.println(cal.get(Calendar.MONTH))
    cal.add(Calendar.MONTH, -3)
    System.out.println(cal.get(Calendar.MONTH))
  }
}
