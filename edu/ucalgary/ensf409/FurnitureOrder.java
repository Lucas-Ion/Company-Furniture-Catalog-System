package edu.ucalgary.ensf409;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Athul Rajagopal, Lucas Ion, Colton Giesbrecht, Amrit Mahendrarajah
 * @version 1.0
 * @since 1.0
 */

/**
 * Generates a order for a set of furniture. Will find the cheapest if it
 * exists.
 */
public class FurnitureOrder {

	private FurnitureCategory category;
	private String type;
	private int numOfFurniture;
	private Order cheapestOrder;

	/**
	 * Builds a furniture order.
	 * 
	 * @param category       furniture category
	 * @param type           subcategory of furniture
	 * @param numOfFurniture amount of furniture to order
	 */
	public FurnitureOrder(FurnitureCategory category, String type, int numOfFurniture) {
		this.category = category;
		this.type = type;
		this.numOfFurniture = numOfFurniture;
		cheapestOrder = null;
	}

	/**
	 * Finds all possible combinations to fulfill order and picks the cheapest one
	 * with the least amount of purchases.
	 * 
	 * @param inventory the database inventory object containing furniture
	 * @return boolean if order was successful
	 */
	public boolean attemptOrder(Inventory inventory) {

		Furniture[] listOfCategory = getFurnitureArray(inventory);
		if (listOfCategory.length == 0) {
			return false;
		}
		ArrayList<Order> possibleOrders = new ArrayList<Order>();
		calcPossibleOrders(listOfCategory, new ArrayList<Furniture>(), possibleOrders);
		return findCheapestOrder(possibleOrders);
	}

	/**
	 * Completes the order on the database by removing purchased furniture.
	 * 
	 * @param inventory the database inventory object containing furniture
	 */
	public void sendOrderToDatabase(Inventory inventory) {

		for (Furniture furniture : cheapestOrder.getFurnitureBought()) {
			inventory.deleteFurniture(category.toString(), furniture.id);
		}
	}

	/**
	 * cheapestOrder getter
	 * 
	 * @return cheapestOrder field
	 */
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

	/**
	 * Fills the ArrayList possibleOrders with all possible orders fulfilling the
	 * requirements.
	 * 
	 * @param furniture          the list of furniture to choose from
	 * @param furnitureToBeAdded the selected furniture waiting to be added
	 * @param possibleOrders     the list of possible valid orders
	 */
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

	/**
	 * Finds the cheapest order in the given arraylist.
	 * 
	 * @param orders the list of possible orders
	 * @return boolean true if cheapest exists.
	 */
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
			cheapestOrder.setCategory(category);
			cheapestOrder.setType(type);
			return true;
		} else {
			return false;
		}
	}
}
