package br.com.unbox.desafio.auth.server.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -5965417955657540640L;
	private String message;

	public BusinessException(String message) {
		super(message);
		this.message = message;
	}
	
	public String getErrorMessage() {
		return message;
	}
	
}
