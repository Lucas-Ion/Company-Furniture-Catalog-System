package edu.ucalgary.ensf409;

//Contains information about an individual filing, including its ID, Type, Price, ManuID, and 
//whether it has a base and a bulb.
public class Lamp extends Furniture {

	Boolean hasBase = false;
	Boolean hasBulb = false;

	public Lamp(String id, String type, String base, String bulb, int price, String manuId) {
		super(null, price, manuId, id, type);
		this.id = new String(id);
		this.type = new String(type);
		if (base.equals("Y")) {
			hasBase = true;
		}
		if (bulb.equals("Y")) {
			hasBulb = true;
		}
		this.price = price;
		this.manuId = new String(manuId);
		hasComponents = new Boolean[] { hasBase, hasBulb };
	}
}
