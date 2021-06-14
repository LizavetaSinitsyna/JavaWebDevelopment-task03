package by.epamtc.sinitsyna.task1.exception;

public class NonPositiveException extends Exception {

	private static final long serialVersionUID = 1L;

	public NonPositiveException() {
		super();
	}

	public NonPositiveException(String message) {
		super(message);
	}

	public NonPositiveException(String message, Throwable cause) {
		super(message, cause);
	}

	public NonPositiveException(Throwable cause) {
		super(cause);
	}

}
