package edu.ucalgary.ensf409;

/**
 * @author Athul Rajagopal, Lucas Ion, Colton Giesbrecht, Amrit Mahendrarajah
 * @version 1.1
 * @since 1.0
 */

/**
 * Holds info on inventory furniture entries.
 */
public class Furniture {

	protected Boolean[] hasComponents;
	protected int price;
	protected String manuId;
	protected String id;
	protected String type;

	/**
	 * @param hasComponents array of booleans true if their corresponding part of
	 *                      the furniture exists
	 * @param price         price of furniture
	 * @param manuId        id from manufacture
	 * @param id            assigned by database
	 * @param type          subcategory of furniture
	 */
	public Furniture(Boolean[] hasComponents, int price, String manuId, String id, String type) {
		this.hasComponents = hasComponents;
		this.price = price;
		this.manuId = manuId;
		this.id = id;
		this.type = type;
	}

}
