package yakush.airlines.planes;

public abstract class AbstractPlanes implements Planes {

	private final String model;
	private final Integer range;
	private final Integer maxLoadCapacity;

	public AbstractPlanes(String model, int range, int maxLoadCapacity) {
		this.model = model;
		this.range = range;
		this.maxLoadCapacity = maxLoadCapacity;
	}

	@Override
	public void startEngine() {
		System.out.println("Engine was started!");
	}

	@Override
	public void changePower() {
		System.out.println("Power is maximum!");
	}

	@Override
	public abstract void fly();

	/*Getters*/
	public String getModel() {
		return model;
	}

	public Integer getRange() {
		return range;
	}

	public Integer getMaxLoadCapacity() {
		return maxLoadCapacity;
	}

}
