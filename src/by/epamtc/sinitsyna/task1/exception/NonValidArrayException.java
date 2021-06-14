package by.epamtc.sinitsyna.task1.exception;

public class NonValidArrayException extends Exception {

	private static final long serialVersionUID = 1L;

	public NonValidArrayException() {
		super();
	}

	public NonValidArrayException(String message) {
		super(message);
	}

	public NonValidArrayException(String message, Throwable cause) {
		super(message, cause);
	}

	public NonValidArrayException(Throwable cause) {
		super(cause);
	}
}