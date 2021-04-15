package edu.ucalgary.ensf409;

import java.util.*;
import java.util.regex.*;
import java.io.*;

/**
 * @author Athul Rajagopal, Lucas Ion, Colton Giesbrecht, Amrit Mahendrarajah
 * @version 2.0
 * @since 1.0
 */

 /**
  * Runs the furniture inventory UI
  * It does this by creating a FileIO object and passing in key information that is collected thorugh the main
  * method. The key information that is then passed to the FileIO object is the category, type and quantity
  * The main class then uses a Print Writer object to write the result of formatOutput to the .txt file: output
  *
  */

public class Main {
	
	static File outFile;
    static FileWriter fw;
    static PrintWriter pw;

	/**
	 * The main method of class Main. 
	 * Accepts no @param args. Computes the File I/O for the UI
	 */
	public static void main(String[] args) {

		StringBuilder output = new StringBuilder();

		FileIO fileIO = new FileIO();

		Scanner scan = new Scanner(System.in);

		outFile = new File("output.txt");

        try {
            fw = new FileWriter(outFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        pw = new PrintWriter(fw);




		Inventory furnitureInventory = new Inventory("jdbc:mysql://localhost/inventory", "lucas", "ensf409");
		furnitureInventory.initializeConnection();
System.out.println();
System.out.println();
System.out.println();
        System.out.println("                       Loading                          ");
for(int i = 0; i < 55; i++){
	System.out.print("*");
try {
	Thread.sleep(75);
} catch (Exception e) {
	//TODO: handle exception
	e.printStackTrace();
}
	}
	System.out.println();


	System.out.println("--------------------------------------------------------");
	System.out.println("|                                                      |");
	System.out.println("|                                                      |");
	System.out.println("|                                                      |");
	System.out.println("|                                                      |");
	System.out.println("|                                                      |");
	System.out.println("|         Welcome to the furniture database            |");
	System.out.println("|                                                      |");
	System.out.println("|                                                      |");
	System.out.println("|                                                      |");
	System.out.println("|                                                      |");
	System.out.println("|          Please fill in your information...          |");
	System.out.println("|                                                      |");
	System.out.println("|                                                      |");
	System.out.println("--------------------------------------------------------");
	System.out.println();

	String facultyName = null;
	String contact = null;
	String date;

	

	/**
	 * Collecting input for the Faculty, and error checking to ensure
	 * the input is valid
	 */
	

	System.out.print("What is your faculty: ");
	facultyName = scan.nextLine();
	Pattern nameCheck = Pattern.compile("^([A-z]+|[A-z]\s|[A-z]|[&|and|-]+\s[A-z][&]*)+$");
	Matcher invalidName = nameCheck.matcher(facultyName);

	if(invalidName.find()== false){
		System.out.println("You did not enter a valid name, please enter name");
		facultyName = scan.nextLine();
		invalidName = nameCheck.matcher(facultyName);
		while(true){
			if(invalidName.matches() == false){
			System.out.println("You did not enter a valid name, please enter a name");
			facultyName = scan.nextLine();
			invalidName = nameCheck.matcher(facultyName);
			if(invalidName.matches()==true){
				break;
			}
			}
			else{
				break;
			}
			
		}

	}


	/**
	 * Collecting input for the first and last name, and error checking to ensure
	 * the input is valid
	 */


	System.out.println();
	System.out.print("What is your first and last name: ");
	contact = scan.nextLine();
	Pattern humanNameCheck = Pattern.compile("^([A-Z][A-z.,\\-']*\\s[A-Z][A-z,.\\-']*)$");
	Matcher invalidHuman = humanNameCheck.matcher(contact);
	
	if(invalidHuman.find()== false){
		System.out.println("You did not enter a valid name, please enter a name that starts with a Capital for the first and last name");
		contact = scan.nextLine();
		invalidHuman = humanNameCheck.matcher(contact);
		while(true){
			if(invalidHuman.matches() == false){
			System.out.println("You did not enter a valid name, please enter a name that starts with a Capital for the first and last name");
			contact = scan.nextLine();
			invalidHuman = humanNameCheck.matcher(contact);
			}
			else{
				break;
			}
			
		}

	}




	/**
	 * Collecting input for the date and error checking to ensure
	 * the input is valid
	 */


	System.out.println();
	System.out.print("What is date you wish to place this order on (MM/DD/YYYY): ");
	date = scan.nextLine();	

	Pattern datePattern = Pattern.compile("^((?:[0][1-9]|[0-1][0-2])\\/(?:[0][1-9]|[3][0-1]|[0-2][1-9])\\/(?:[2][0-9][2-9][1-9]))$");

	Matcher invalidDate = datePattern.matcher(date);

	
	if(invalidDate.find()== false){
		System.out.println("You did not enter a valid date, please enter a date that matches the format MM/DD/YYYY");
		date = scan.nextLine();
		invalidDate = datePattern.matcher(date);
		while(true){
			if(invalidDate.matches() == false){
			System.out.println("You did not enter a valid date, please enter a date that matches the format MM/DD/YYYY");
			date = scan.nextLine();
			invalidDate = datePattern.matcher(date);
			}
			else{
				break;
			}
			
		}
	}

	/**
	 * Printing loading stars
	 */

	System.out.println();
	System.out.println("                       Processing                          ");
	for(int i = 0; i < 55; i++){
		System.out.print("*");
	try {
		Thread.sleep(75);
	} catch (Exception e) {
		//TODO: handle exception
		e.printStackTrace();
	}
		}

	try {
		Thread.sleep(250);
	} catch (Exception e) {
		//TODO: handle exception
		e.printStackTrace();
	}
	System.out.println();
	System.out.println();
	System.out.println("                     Status: Approved                          ");
	try {
		Thread.sleep(750);
	} catch (Exception e) {
		//TODO: handle exception
		e.printStackTrace();
	}
	System.out.println();

		/**
		 * Displaying GUI to select categories
		 */


		System.out.println("--------------------------------------------------------");
		System.out.println("|                                                      |");
		System.out.println("|                                                      |");
		System.out.println("|                                                      |");
		System.out.println("|                                                      |");
		System.out.println("|                                                      |");
		System.out.println("|         Welcome to the furniture database            |");
		System.out.println("|                                                      |");
		System.out.println("|                                                      |");
		System.out.println("|                                                      |");
		System.out.println("|                                                      |");
		System.out.println("|             Please select a category                 |");
		System.out.println("|       Chair: 1, Desk: 2, Filing: 3, Lamp: 4          |");
		System.out.println("|                                                      |");
		System.out.println("--------------------------------------------------------");
		System.out.println();

		
		String cat = null;
		String type = null;
		String quan;
		int quantity = 0;
		
		String category = scan.nextLine();


		/**
		 * Collecting input for the category type, and error checking to ensure
		 * the input is valid
	 	*/

		Pattern invalidCheck = Pattern.compile("^([1-4])$");
		Pattern quantityCheck = Pattern.compile("^[1-9][0-9]*$");
		Matcher invalidNum = invalidCheck.matcher(category);

		if(invalidNum.find()== false){
			System.out.println("You did not enter numbers, please enter either 1,2,3 or 4");
			category = scan.nextLine();
			invalidNum = invalidCheck.matcher(category);
			while(true){
				System.out.println("You did not enter numbers, please enter either 1,2,3 or 4");
				category = scan.nextLine();
				invalidNum = invalidCheck.matcher(category);
				if(invalidNum.find()== true){
					break;
				}
			}

		}

		int catSelect = Integer.parseInt(category);
	
		

		if(catSelect == 1){
			cat = "Chair";
		}
		else if(catSelect ==2){
			cat = "Desk";
		}
		else if(catSelect ==3){
			cat = "Filing";
		}
		else if(catSelect ==4){
			cat = "Lamp";
		}

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		/**
		 * GUI to select chair type
		 */

		if(catSelect == 1){
		System.out.println("--------------------------------------------------------");
		System.out.println("|                                                      |");
		System.out.println("|                                                      |");
		System.out.println("|                                                      |");
		System.out.println("|                                                      |");
		System.out.println("|                                                      |");
		System.out.println("|              Category Selected: Chair                |");
		System.out.println("|                                                      |");
		System.out.println("|                                                      |");
		System.out.println("|                                                      |");
		System.out.println("|                                                      |");
		System.out.println("|             Please select a type:                    |");
		System.out.println("|             Kneeling: 1, Mesh: 2,                    |");
		System.out.println("|        Executive: 3, Ergonomic:4, Task: 5            |");
		System.out.println("|                                                      |");
		System.out.println("--------------------------------------------------------");
		System.out.println();



	/**
	 * Collecting input for the chair type, and error checking to ensure
	 * the input is valid
	 */


		String typeString = scan.nextLine();
		Pattern invalidChair = Pattern.compile("^([1-5])$");
		invalidNum = invalidChair.matcher(typeString);
		//invalidNum = invalidCheck.matcher(typeString);

		if(invalidNum.find()== false){
			System.out.println("You did not enter numbers, please enter either 1,2,3,4 or 5");
			typeString = scan.nextLine();
			invalidNum = invalidChair.matcher(typeString);
			while(true){
				System.out.println("You did not enter numbers, please enter either 1,2,3,4  or 5");
				typeString = scan.nextLine();
				invalidNum = invalidChair.matcher(typeString);
				if(invalidNum.find()== true){
					break;
				}
			}

		}

		int typeSelect = Integer.parseInt(typeString);

		if(typeSelect != 1 && typeSelect != 2 && typeSelect != 3 && typeSelect != 4 && typeSelect !=5){
			while(true){
				System.out.println("That was an invalid input please try again!");
				typeSelect = Integer.parseInt(scan.nextLine());
				if(typeSelect == 1 ||typeSelect == 2 || typeSelect == 3 || typeSelect == 4 || typeSelect ==5 ){
					break;
				}
			}
			}


			if (typeSelect ==1){
			System.out.println("How many Kneeling Chairs would you like?");
			type = "Kneeling";
			}
			else if (typeSelect ==2){
			System.out.println("How many Mesh Chairs would you like?");
			type = "Mesh";
			}
			else if (typeSelect ==3){
			System.out.println("How many Executive Chairs would you like?");
			type = "Excutive";
			}
			else if (typeSelect ==4){
			System.out.println("How many Ergonomic Chairs would you like?");
			type = "Ergonomic";
			}
			else if (typeSelect ==5){
			System.out.println("How many Task Chairs would you like?");
			type = "Task";
			}

			quan = scan.nextLine();


			/**
	 		* Collecting input for the chair quantity, and error checking to ensure
	 		* the input is valid
	 		*/

			invalidNum = quantityCheck.matcher(quan);

			if(invalidNum.find()== false){
				System.out.println("You did not enter numbers, please enter a positive integer");
				quan = scan.nextLine();
				invalidNum = quantityCheck.matcher(quan);
				while(true){
					System.out.println("You did not enter numbers, please enter a positive integer");
					quan = scan.nextLine();
					invalidNum = quantityCheck.matcher(quan);
					if(invalidNum.find()== true){
						break;
					}
				}
	
			}

			quantity = Integer.parseInt(quan);
			
			
		}
		else if(catSelect == 2){


			/**
			 * Collecting input for the Desk type, and error checking to ensure
			 * the input is valid
			 */



			System.out.println("--------------------------------------------------------");
			System.out.println("|                                                      |");
			System.out.println("|                                                      |");
			System.out.println("|                                                      |");
			System.out.println("|                                                      |");
			System.out.println("|                                                      |");
			System.out.println("|              Category Selected: Desk                 |");
			System.out.println("|                                                      |");
			System.out.println("|                                                      |");
			System.out.println("|                                                      |");
			System.out.println("|                                                      |");
			System.out.println("|              Please select a type:                   |");
			System.out.println("|              Standing: 1, Adjustable: 2,             |");
			System.out.println("|                 Traditional: 3                       |");
			System.out.println("|                                                      |");
			System.out.println("--------------------------------------------------------");
			System.out.println();



		/**
	 	* Collecting input for the Desk type, and error checking to ensure
	 	* the input is valid
	 	*/


		String typeString = scan.nextLine();
		Pattern invalidDesk = Pattern.compile("^([1-3])$");
		invalidNum = invalidDesk.matcher(typeString);
	

		if(invalidNum.find()== false){
			System.out.println("You did not enter numbers, please enter either 1,2, or 3");
			typeString = scan.nextLine();
			invalidNum = invalidDesk.matcher(typeString);
			while(true){
				System.out.println("You did not enter numbers, please enter either 1,2, or 3");
				typeString = scan.nextLine();
				invalidNum = invalidDesk.matcher(typeString);
				if(invalidNum.find()== true){
					break;
				}
			}

		}


			int typeSelect = Integer.parseInt(typeString);
	
			if(typeSelect != 1 && typeSelect != 2 && typeSelect != 3 ){
				while(true){
					System.out.println("That was an invalid input please try again!");
					typeSelect = Integer.parseInt(scan.nextLine());
					if(typeSelect == 1 ||typeSelect == 2 || typeSelect == 3){
						break;
					}
				}
				}
	
				if (typeSelect ==1){
				System.out.println("How many Standing Desks would you like?");
				type = "Standing";
				}
			else if (typeSelect ==2){
			System.out.println("How many Adjustable Desks would you like?");
			type = "Adjustable";
			}
			else if (typeSelect ==3){
			System.out.println("How many Traditional Desks would you like?");
			type = "Traditional";
			}
			
			
			/**
	 		* Collecting input for the Desk quantity, and error checking to ensure
	 		* the input is valid
	 		*/


			quan = scan.nextLine();

			invalidNum = quantityCheck.matcher(quan);

			if(invalidNum.find()== false){
				System.out.println("You did not enter numbers, please enter a positive integer");
				quan = scan.nextLine();
				invalidNum = quantityCheck.matcher(quan);
				while(true){
					System.out.println("You did not enter numbers, please enter a positive integer");
					quan = scan.nextLine();
					invalidNum = quantityCheck.matcher(quan);
					if(invalidNum.find()== true){
						break;
					}
				}
	
			}

			 quantity = Integer.parseInt(quan);

			}
			else if(catSelect == 3){


				/**
	 			*Collecting input for the Filing, and error checking to ensure
	 			* the input is valid
	 			*/

				System.out.println("--------------------------------------------------------");
				System.out.println("|                                                      |");
				System.out.println("|                                                      |");
				System.out.println("|                                                      |");
				System.out.println("|                                                      |");
				System.out.println("|                                                      |");
				System.out.println("|              Category Selected: Filing               |");
				System.out.println("|                                                      |");
				System.out.println("|                                                      |");
				System.out.println("|                                                      |");
				System.out.println("|                                                      |");
				System.out.println("|              Please select a type:                   |");
				System.out.println("|              Small: 1, Medium: 2,                    |");
				System.out.println("|                   Large: 3                           |");
				System.out.println("|                                                      |");
				System.out.println("--------------------------------------------------------");
				System.out.println();

				String typeString = scan.nextLine();
				Pattern invalidFiling = Pattern.compile("^([1-3])$");
				invalidNum = invalidFiling.matcher(typeString);
	


			/**
	 		* Collecting input for the Filing type, and error checking to ensure
	 		* the input is valid
	 		*/	


		if(invalidNum.find()== false){
			System.out.println("You did not enter numbers, please enter either 1,2,or 3");
			typeString = scan.nextLine();
			invalidNum = invalidFiling.matcher(typeString);
			while(true){
				System.out.println("You did not enter numbers, please enter either 1,2, or 3");
				typeString = scan.nextLine();
				invalidNum = invalidFiling.matcher(typeString);
				if(invalidNum.find()== true){
					break;
				}
			}

		}



				int typeSelect = Integer.parseInt(typeString);
		
				if(typeSelect != 1 && typeSelect != 2 && typeSelect != 3 ){
					while(true){
						System.out.println("That was an invalid input please try again!");
						typeSelect = Integer.parseInt(scan.nextLine());
						if(typeSelect == 1 ||typeSelect == 2 || typeSelect == 3){
							break;
						}
					}
					}
		
					if (typeSelect ==1){
				System.out.println("How many Small Filings would you like?");
				type = "Small";
					}
				else if (typeSelect ==2){
				System.out.println("How many Medium Filings would you like?");
				type = "Medium";
				}
				else if (typeSelect ==3){
				System.out.println("How many Large Filings would you like?");
				type = "Large";
				}
				
				
				/**
	 			* Collecting input for the Filing Quantity, and error checking to ensure
	 			* the input is valid
	 			*/


			quan = scan.nextLine();

			invalidNum = quantityCheck.matcher(quan);

			if(invalidNum.find()== false){
				System.out.println("You did not enter numbers, please enter a positive integer");
				quan = scan.nextLine();
				invalidNum = quantityCheck.matcher(quan);
				while(true){
					System.out.println("You did not enter numbers, please enter a positive integer");
					quan = scan.nextLine();
					invalidNum = quantityCheck.matcher(quan);
					if(invalidNum.find()== true){
						break;
					}

				}
	
			}


			 quantity = Integer.parseInt(quan);
				
	
			
			}
				else if(catSelect == 4){

					/**
	 				* Collecting input for the Lamp, and error checking to ensure
	 				* the input is valid
	 				*/
					System.out.println("--------------------------------------------------------");
					System.out.println("|                                                      |");
					System.out.println("|                                                      |");
					System.out.println("|                                                      |");
					System.out.println("|                                                      |");
					System.out.println("|                                                      |");
					System.out.println("|              Category Selected: Lamp                 |");
					System.out.println("|                                                      |");
					System.out.println("|                                                      |");
					System.out.println("|                                                      |");
					System.out.println("|                                                      |");
					System.out.println("|              Please select a type:                   |");
					System.out.println("|              Desk: 1, Study: 2,                      |");
					System.out.println("|                 Swingarm: 3                          |");
					System.out.println("|                                                      |");
					System.out.println("--------------------------------------------------------");
					System.out.println();



					String typeString = scan.nextLine();
					Pattern invalidLamp = Pattern.compile("^([1-3])$");
					invalidNum = invalidLamp.matcher(typeString);
					

			/**
	 		* Collecting input for the Lamp Type, and error checking to ensure
	 		* the input is valid
	 		*/


			if(invalidNum.find()== false){
			System.out.println("You did not enter numbers, please enter either 1,2, or 3");
			typeString = scan.nextLine();
			invalidNum = invalidLamp.matcher(typeString);
			while(true){
				System.out.println("You did not enter numbers, please enter either 1,2,or 3");
				typeString = scan.nextLine();
				invalidNum = invalidLamp.matcher(typeString);
				if(invalidNum.find()== true){
					break;
				}
			}

		}


					int typeSelect = Integer.parseInt(typeString);
			
					if(typeSelect != 1 && typeSelect != 2 && typeSelect != 3 ){
						while(true){
							System.out.println("That was an invalid input please try again!");
							typeSelect = Integer.parseInt(scan.nextLine());
							if(typeSelect == 1 ||typeSelect == 2 || typeSelect == 3){
								break;
							}
						}
						}
			
					if (typeSelect ==1){
					System.out.println("How many Desk Lamps would you like?");
					type = "Desk";
					}
					else if (typeSelect ==2){
					System.out.println("How many Study Lamps would you like?");
					type = "Study";
					}
					else if (typeSelect ==3){
					System.out.println("How many Swingarm Lamps would you like?");
					type = "Swing Arm";
					}
					
					/**
	 				* Collecting input for the Lamp Type, and error checking to ensure
	 				* the input is valid
	 				*/
					
					quan = scan.nextLine();

					invalidNum = quantityCheck.matcher(quan);
		
					if(invalidNum.find()== false){
						System.out.println("You did not enter numbers, please enter a positive integer");
						quan = scan.nextLine();
						invalidNum = quantityCheck.matcher(quan);
						while(true){
							System.out.println("You did not enter numbers, please enter a positive integer");
							quan = scan.nextLine();
							invalidNum = quantityCheck.matcher(quan);
							if(invalidNum.find()== true){
								break;
							}
						}
			
					}
		
					
					 quantity = Integer.parseInt(quan);

					}
			
		/**
		 * Setting the relevant values of the FileIO object
		 */
	
		fileIO.setCat(cat);
		fileIO.setType(type);
		fileIO.setQuantity(quantity);
		fileIO.setContact(contact);
		fileIO.setDate(date);
		fileIO.setFacultyName(facultyName);

		/**
		 * If the file is not empty, write to the file and close the print writer object
		 */
	
		String out = fileIO.formatOutput();
		System.out.println(out);
		if(!(out.equals(""))){
			System.out.println("Output results are also noted on the order form: output.txt in the working directory");
		}
		pw.print(out);
		
		pw.close();
		

	}


}
