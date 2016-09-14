package yakush.airlines.exceptions;

public class NoXMLFileException extends Exception {

	private String message;

	public NoXMLFileException() {
		super();
	}

	public NoXMLFileException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {

		return message;

	}

}
