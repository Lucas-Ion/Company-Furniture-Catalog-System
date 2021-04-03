/**
 * @author Colton Giesbrecht <a href="mailto:colton.giesbrecht1@ucalgary.ca">colton.giesbrecht@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 */

/*
* Order.java does
*/
package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class Order {

	private int[] numOfComponents;
	private int totalCost;
	private int numOfFurniture;
	ArrayList<Furniture> furnitureBought;

	public Order(int numOfComponentTypes, int numOfFurniture) {
		numOfComponents = new int[numOfComponentTypes];
		furnitureBought = new ArrayList<Furniture>();
		totalCost = 0;
		this.numOfFurniture = numOfFurniture;
	}

	public boolean addParts(Furniture furniture) {

		boolean isComplete = true;
		for (int i = 0; i < furniture.hasComponents.length; i++) {
			if (furniture.hasComponents[i] == true) {
				numOfComponents[i]++;
			}
			if (numOfComponents[i] != numOfFurniture) {
				isComplete = false;
			}
		}
		totalCost += furniture.price;
		furnitureBought.add(furniture);
		return isComplete;
	}
}
