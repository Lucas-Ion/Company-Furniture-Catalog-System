package edu.ucalgary.ensf409;

/**
 * @author Athul Rajagopal, Lucas Ion, Colton Giesbrecht, Amrit Mahendrarajah
 * @version 1.0
 * @since 1.0
 */

//Contains information about an individual filing, including its ID, Type, Price, ManuID, and 
//whether it has rails, drawers, and a cabinet.
public class Filing extends Furniture {

	Boolean hasRails = false;
	Boolean hasDrawers = false;
	Boolean hasCabinet = false;

	public Filing(String id, String type, String rails, String drawers, String cabinet, int price, String manuId) {
		super(null, price, manuId, id, type);

		if (rails.equals("Y")) {
			hasRails = true;
		}
		if (drawers.equals("Y")) {
			hasDrawers = true;
		}
		if (cabinet.equals("Y")) {
			hasCabinet = true;
		}

		hasComponents = new Boolean[] { hasRails, hasDrawers, hasCabinet };
	}
}
