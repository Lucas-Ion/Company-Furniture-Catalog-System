package edu.ucalgary.ensf409;

import java.util.Arrays;

/**
 * @author Colton Giesbrecht <a href=
 *         "mailto:colton.giesbrecht1@ucalgary.ca">colton.giesbrecht@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 */

public class Main {

	public static void main(String[] args) {

		Furniture[] test = new Furniture[1];
		test[0] = new Chair("C2", "asdad", "Y", "N", "N", "Y", 2, "asd");
		System.out.println(test[0].hasComponents[0]);
		Furniture[] test2 = Arrays.copyOf(test, test.length);
		test2[0].hasComponents[0] = false;
		System.out.println(test[0].hasComponents[0]);
	}
}
