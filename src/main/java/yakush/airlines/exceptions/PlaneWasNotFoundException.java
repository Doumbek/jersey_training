package yakush.airlines.exceptions;

public class PlaneWasNotFoundException extends Exception  {

	private String message;


	public PlaneWasNotFoundException() {
		super();
	}

	public PlaneWasNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {

		return message;

	}

}
