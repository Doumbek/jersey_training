package yakush.airlines.exceptions;

public class NoTxtFileException extends Exception {

	private String message;

	public NoTxtFileException() {
		super();
	}

	public NoTxtFileException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {

		return message;

	}

}
