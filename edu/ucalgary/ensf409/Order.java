package edu.ucalgary.ensf409;

/**
 * @author Athul Rajagopal, Lucas Ion, Colton Giesbrecht, Amrit Mahendrarajah
 * @version 1.0
 * @since 1.0
 */

import java.util.ArrayList;

public class Order {

	private int[] numOfComponents;
	private int totalCost;
	private int numOfFurniture;
	private ArrayList<Furniture> furnitureBought;
	private FurnitureCategory category;
	private String type;

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

	public FurnitureCategory getCategory() {
		return category;
	}

	public void setCategory(FurnitureCategory category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
