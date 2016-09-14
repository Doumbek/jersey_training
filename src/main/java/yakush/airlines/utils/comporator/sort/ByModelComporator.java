package yakush.airlines.utils.comporator.sort;

import yakush.airlines.planes.PassengerPlanes;

import java.util.Comparator;

public class ByModelComporator implements Comparator<PassengerPlanes> {
	@Override
	public int compare(PassengerPlanes planeOne, PassengerPlanes planeTwo) {
		return planeOne.getModel().compareToIgnoreCase(planeTwo.getModel());
	}
}
