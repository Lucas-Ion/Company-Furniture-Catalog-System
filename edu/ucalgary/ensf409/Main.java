package edu.ucalgary.ensf409;

/**
 * @author Colton Giesbrecht <a href=
 *         "mailto:colton.giesbrecht1@ucalgary.ca">colton.giesbrecht@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 */

public class Main {

	public static void main(String[] args) {

		Inventory furnitureInventory = new Inventory("jdbc:mysql://localhost/inventory", "java", "SQL4life?");
		furnitureInventory.initializeConnection();

		// Pretend this is the user's selected category and type of furniture
		String selectedCategory = "Lamp", selectedType = "Desk";
		// This is the pretend number of furniture
		int selectedNum = 2;

		FurnitureCategory catg = FurnitureCategory.getCategory(selectedCategory);
		if (catg == FurnitureCategory.NotAFurnitureCategory) {
			System.out.println("Not a category");
		} else {
			FurnitureOrder request = new FurnitureOrder(catg, selectedType, selectedNum);
			Order order = null;
			if (request.attemptOrder(furnitureInventory)) {
				order = request.getCheapestOrder();
				System.out.println(order.getTotalCost());
				for (Furniture furn : order.getFurnitureBought()) {
					System.out.println(furn.id);
				}
			}
			request.sendOrderToDatabase(furnitureInventory);
		}
		furnitureInventory.close();
	}
}
