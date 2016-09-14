package yakush.airlines.utils.comporator.sort;

import yakush.airlines.planes.PassengerPlanes;

import java.util.Comparator;

public class ByRangeComporator implements Comparator<PassengerPlanes> {

	@Override
	public int compare(PassengerPlanes planeOne, PassengerPlanes planeTwo) {
		return planeOne.getRange().compareTo(planeTwo.getRange());
	}

}
