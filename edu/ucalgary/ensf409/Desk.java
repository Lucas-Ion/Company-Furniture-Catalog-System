package edu.ucalgary.ensf409;

/**
 * @author Athul Rajagopal, Lucas Ion, Colton Giesbrecht, Amrit Mahendrarajah
 * @version 1.1
 * @since 1.0
 */

//Contains information about an individual desk, including its ID, Type, Price, ManuID, and 
//whether it has legs, a top, and a drawer.
public class Desk extends Furniture {

	Boolean hasLegs = false;
	Boolean hasTop = false;
	Boolean hasDrawer = false;

	public Desk(String id, String type, String legs, String top, String drawer, int price, String manuId) {
		super(null, price, manuId, id, type);

		if (legs.equals("Y")) {
			hasLegs = true;
		}
		if (top.equals("Y")) {
			hasTop = true;
		}
		if (drawer.equals("Y")) {
			hasDrawer = true;
		}

		hasComponents = new Boolean[] { hasLegs, hasTop, hasDrawer };

	}
}
