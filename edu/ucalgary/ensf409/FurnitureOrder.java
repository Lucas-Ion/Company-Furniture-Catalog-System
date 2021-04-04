package edu.ucalgary.ensf409;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Colton Giesbrecht <a href=
 *         "mailto:colton.giesbrecht1@ucalgary.ca">colton.giesbrecht@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 */

public class FurnitureOrder {

	private FurnitureCategory category;
	private String type;
	private int numOfFurniture;
	private Furniture[] furniture;
	private Order cheapestOrder;

	/**
	 * @param category
	 * @param type
	 * @param numOfFurniture
	 */
	public FurnitureOrder(FurnitureCategory category, String type, int numOfFurniture) {
		this.category = category;
		this.type = type;
		this.numOfFurniture = numOfFurniture;
		furniture = new Furniture[numOfFurniture];
		cheapestOrder = null;
	}

	public boolean attemptOrder(Inventory inventory) {

		Furniture[] listOfCategory = getFurnitureArray(inventory);
		ArrayList<Order> possibleOrders = new ArrayList<Order>();
		calcPossibleOrders(listOfCategory, new ArrayList<Furniture>(), possibleOrders);
		return findCheapestOrder(possibleOrders);
	}

	public void sendOrderToDatabase(Inventory inventory) {

		for (Furniture furniture : cheapestOrder.getFurnitureBought()) {
			inventory.deleteFurniture(category.toString(), furniture.id);
		}
	}

	public Furniture[] getFurniture() {
		return furniture;
	}

	public Desk[] getDesks() {
		if (category == FurnitureCategory.Desk) {
			return (Desk[]) furniture;
		}
		return null;
	}

	public Filing[] getFilings() {
		if (category == FurnitureCategory.Filing) {
			return (Filing[]) furniture;
		}
		return null;
	}

	public Lamp[] getLamps() {
		if (category == FurnitureCategory.Lamp) {
			return (Lamp[]) furniture;
		}
		return null;
	}

	public Chair[] getChairs() {
		if (category == FurnitureCategory.Chair) {
			return (Chair[]) furniture;
		}
		return null;
	}

	public Order getCheapestOrder() {
		return cheapestOrder;
	}

	private Furniture[] getFurnitureArray(Inventory inventory) {

		switch (category) {
		case Chair:
			return inventory.selectChairsByType(type).toArray(Furniture[]::new);
		case Desk:
			return inventory.selectDesksByType(type).toArray(Furniture[]::new);
		case Filing:
			return inventory.selectFilingsByType(type).toArray(Furniture[]::new);
		case Lamp:
			return inventory.selectLampsByType(type).toArray(Furniture[]::new);
		case NotAFurnitureCategory:
			throw new IllegalArgumentException("Category should be an avalible category!");
		default:
			throw new IllegalStateException("Category should be a valid category!");
		}
	}

	private void calcPossibleOrders(Furniture[] furniture, ArrayList<Furniture> furnitureToBeAdded,
			ArrayList<Order> possibleOrders) {

		int numOfComponents = furniture[0].hasComponents.length;
		for (int i = 0; i < furniture.length; i++) {
			Order newOrder = new Order(numOfComponents, numOfFurniture);
			ArrayList<Furniture> newFurnitureToBeAdded = new ArrayList<Furniture>(furnitureToBeAdded);
			newFurnitureToBeAdded.add(furniture[i]);
			newFurnitureToBeAdded.forEach(newOrder::addParts);
			if (newOrder.isOrderFulfilled()) {
				possibleOrders.add(newOrder);
			}
			if (furniture.length - (i + 1) > 0) {
				calcPossibleOrders(Arrays.copyOfRange(furniture, i + 1, furniture.length), newFurnitureToBeAdded,
						possibleOrders);
			}
		}
	}

	private boolean findCheapestOrder(ArrayList<Order> orders) {

		Order cheapest = null;

		for (Order order : orders) {
			if (cheapest == null || order.getTotalCost() < cheapest.getTotalCost()
					|| (order.getTotalCost() == cheapest.getTotalCost()
							&& order.getNumFurnitureBought() < cheapest.getNumFurnitureBought())) {
				cheapest = order;
			}
		}

		if (cheapest != null) {
			cheapestOrder = cheapest;
			return true;
		} else {
			return false;
		}
	}
}
