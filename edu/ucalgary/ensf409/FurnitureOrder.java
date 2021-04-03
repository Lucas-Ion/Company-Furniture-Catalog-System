package edu.ucalgary.ensf409;

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
	}

	public boolean attemptOrder(Inventory inventory) {

		Furniture[] listOfCategory = getFurnitureArray(inventory);

		Order[] possibleOrders = new Order[(int) Math.pow(listOfCategory.length, 2)];

		for (int i = 0; i < listOfCategory.length; i++) {
			for (int j = 0; j < listOfCategory.length; j++) {

			}
		}

		return false;
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
}
