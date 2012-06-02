package xunit.resultados;

import xunit.Resultadito;

public class ResultaditoFallo extends Resultadito {

	@Override
	public boolean fallo() {
		return true;
	}
}
