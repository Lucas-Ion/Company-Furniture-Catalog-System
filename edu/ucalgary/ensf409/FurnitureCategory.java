package edu.ucalgary.ensf409;
/**
 * @author Colton Giesbrecht <a href="mailto:colton.giesbrecht1@ucalgary.ca">colton.giesbrecht@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 */

/**
 * Enum for the categories of valid furniture.
 */
public enum FurnitureCategory {

	Chair, Desk, Filing, Lamp, NotAFurnitureCategory;

	/**
	 * Holds the valid category types of furniture.
	 * 
	 * Will return NotAFurnitureCategory if not a valid category.
	 * 
	 * @param s string value of category
	 * @return category enum of the s
	 */
	public static FurnitureCategory getCategory(String s) {

		for (FurnitureCategory cat : values()) {
			if (cat.toString().equals(s)) {
				return cat;
			}
		}
		return NotAFurnitureCategory;
	}
}
