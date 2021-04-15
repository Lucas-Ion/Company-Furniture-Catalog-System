package edu.ucalgary.ensf409;

/**
 * @author Athul Rajagopal, Lucas Ion, Colton Giesbrecht, Amrit Mahendrarajah
 * @version 1.0
 * @since 1.0
 */

import java.util.ArrayList;

/**
 * Holds the furniture and properties of a furniture order.
 */
public class Order {

	private int[] numOfComponents;
	private int totalCost;
	private int numOfFurniture;
	private ArrayList<Furniture> furnitureBought;
	private FurnitureCategory category;
	private String type;

	/**
	 * Creates an order with the number of furniture and the number of furniture
	 * components they contain.
	 * 
	 * @param numOfComponentTypes
	 * @param numOfFurniture
	 */
	public Order(int numOfComponentTypes, int numOfFurniture) {
		numOfComponents = new int[numOfComponentTypes];
		furnitureBought = new ArrayList<Furniture>();
		totalCost = 0;
		this.numOfFurniture = numOfFurniture;
	}

	/**
	 * Adds a furniture to the order and its parts
	 * 
	 * @param furniture
	 */
	public void addParts(Furniture furniture) {

		totalCost += furniture.price;
		furnitureBought.add(furniture);
		for (int i = 0; i < numOfComponents.length; i++) {
			if (furniture.hasComponents[i]) {
				numOfComponents[i]++;
			}
		}
	}

	/**
	 * Returns if the number of parts fullfill the number of furniture.
	 * 
	 * @return isFullfilled
	 */
	public boolean isOrderFulfilled() {

		for (int numOfComponent : numOfComponents) {
			if (numOfComponent < numOfFurniture) {
				return false;
			}
		}
		return true;
	}

	/**
	 * getter
	 * 
	 * @return numOfComponents
	 */
	public int[] getNumOfComponents() {
		return numOfComponents;
	}

	/**
	 * getter
	 * 
	 * @return totalCost
	 */
	public int getTotalCost() {
		return totalCost;
	}

	/**
	 * getter
	 * 
	 * @return numOfFurniture
	 */
	public int getNumOfFurniture() {
		return numOfFurniture;
	}

	/**
	 * getter
	 * 
	 * @return furnitureBought
	 */
	public Furniture[] getFurnitureBought() {
		return furnitureBought.toArray(Furniture[]::new);
	}

	/**
	 * getter
	 * 
	 * @return numFurnitureBought
	 */
	public int getNumFurnitureBought() {
		return furnitureBought.size();
	}

	/**
	 * getter
	 * 
	 * @return category
	 */
	public FurnitureCategory getCategory() {
		return category;
	}

	/**
	 * setter
	 * 
	 * @param category
	 */
	public void setCategory(FurnitureCategory category) {
		this.category = category;
	}

	/**
	 * getter
	 * 
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * setter
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

}
