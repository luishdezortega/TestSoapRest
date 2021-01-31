package com.test.rest.api.exception;

/**
 * Clase que define una excepcion personalizada para el control de errores en la
 * aplicacion
 */
public class EmployeeException extends Exception {

	private static final long serialVersionUID = 8918303097908711059L;

	public EmployeeException(String message) {
		super(message);
	}

	public EmployeeException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmployeeException(Throwable cause) {
		super(cause);
	}

}
