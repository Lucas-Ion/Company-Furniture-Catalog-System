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
	private ArrayList<Furniture> furnitureBought;

	public Order(int numOfComponentTypes, int numOfFurniture) {
		numOfComponents = new int[numOfComponentTypes];
		furnitureBought = new ArrayList<Furniture>();
		totalCost = 0;
		this.numOfFurniture = numOfFurniture;
	}

	public void addParts(Furniture furniture) {

		totalCost += furniture.price;
		furnitureBought.add(furniture);
		for (int i = 0; i < numOfComponents.length; i++) {
			if (furniture.hasComponents[i]) {
				numOfComponents[i]++;
			}
		}
	}

	public boolean isOrderFulfilled() {

		for (int numOfComponent : numOfComponents) {
			if (numOfComponent < numOfFurniture) {
				return false;
			}
		}
		return true;
	}

	public int[] getNumOfComponents() {
		return numOfComponents;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public int getNumOfFurniture() {
		return numOfFurniture;
	}

	public Furniture[] getFurnitureBought() {
		return furnitureBought.toArray(Furniture[]::new);
	}

	public int getNumFurnitureBought() {
		return furnitureBought.size();
	}

}
