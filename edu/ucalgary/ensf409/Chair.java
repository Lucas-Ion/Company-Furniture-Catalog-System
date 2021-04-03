package edu.ucalgary.ensf409;

//Contains information about an individual chair, including its ID, Type, Price, ManuID, and 
//whether it has legs, arms, a seat, and a cushion.
public class Chair extends Furniture {

	Boolean hasLegs = false;
	Boolean hasArms = false;
	Boolean hasSeat = false;
	Boolean hasCushion = false;

	public Chair(String id, String type, String legs, String arms, String seat, String cushion, int price,
			String manuId) {
		super(null, price, manuId, id, type);
		if (legs.equals("Y")) {
			hasLegs = true;
		}
		if (arms.equals("Y")) {
			hasArms = true;
		}
		if (seat.equals("Y")) {
			hasSeat = true;
		}
		if (cushion.equals("Y")) {
			hasCushion = true;
		}
		hasComponents = new Boolean[] { hasLegs, hasArms, hasSeat, hasCushion };
	}

}
