package yakush.airlines.planes;

public class PassengerPlanes extends AbstractPlanes{

	private final Integer maxPassCapacity;

	public PassengerPlanes(String model, int range, int maxLoadCapacity, int maxPassCapacity) {
		super(model, range, maxLoadCapacity);
		this.maxPassCapacity = maxPassCapacity;
	}

	@Override
	public void fly() {
		System.out.println("Passenger plane '" + getModel() + "' is flying!");
	}

	/*Getters*/
	public Integer getMaxPassCapacity() {
		return maxPassCapacity;
	}

	@Override
	public String toString() {

		return "Model: " + getModel() + "\n"
				+ "Range: " + getRange() + "\n"
				+ "Max load capacity: " + getMaxLoadCapacity() + "\n"
				+ "Max passenger capacity: " + getMaxPassCapacity() + "\n";

	}

}

