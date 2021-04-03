/**
 * @author Colton Giesbrecht <a href="mailto:colton.giesbrecht1@ucalgary.ca">colton.giesbrecht@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 */

/*
* Furniture.java does
*/
package edu.ucalgary.ensf409;

/**
*
*/
public class Furniture {

	protected Boolean[] hasComponents;
	protected int price;
	protected String manuId;
	protected String id;
	protected String type;

	/**
	 * @param hasComponents
	 * @param price
	 * @param manuId
	 * @param id
	 * @param type
	 */
	public Furniture(Boolean[] hasComponents, int price, String manuId, String id, String type) {
		this.hasComponents = hasComponents;
		this.price = price;
		this.manuId = manuId;
		this.id = id;
		this.type = type;
	}

}
