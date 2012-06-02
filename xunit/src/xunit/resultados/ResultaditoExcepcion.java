package xunit.resultados;

import xunit.Resultadito;

public class ResultaditoExcepcion extends Resultadito {

	private Throwable exception;

	public ResultaditoExcepcion(Throwable e) {
		this.exception = e;
	}

	@Override
	public boolean tiroExcepcion() {
		return true;
	}
}
