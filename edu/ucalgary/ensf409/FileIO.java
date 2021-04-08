package edu.ucalgary.ensf409;

import java.util.*;
import java.io.*;


public class FileIO {
    


	static File outFile;
    static FileWriter fw;
    static PrintWriter pw;
    

    public FileIO(){
    
    }

	public String formatOutput(){

         StringBuilder output = new StringBuilder();

		 Scanner scan = new Scanner(System.in);

		// outFile = new File("output.txt");

        // try {
        //     fw = new FileWriter(outFile);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // pw = new PrintWriter(fw);

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

	System.out.print("What is your faculty: ");
	facultyName = scan.nextLine();
	System.out.println();
	System.out.print("What is your first and last name: ");
	contact = scan.nextLine();
	System.out.println();
	System.out.print("What is date you wish to place this order on (MM/DD/YYYY): ");
	date = scan.nextLine();
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
		int quantity = 0;
		int catSelect = Integer.parseInt(scan.nextLine());
		
		if(catSelect != 1 && catSelect != 2 && catSelect != 3 && catSelect != 4){
		while(true){
			System.out.println("That was an invalid input please try again!");
			catSelect = Integer.parseInt(scan.nextLine());
			if(catSelect == 1 || catSelect == 2 || catSelect == 3 || catSelect == 4){
				break;
			}
		}
		}

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
		int typeSelect = Integer.parseInt(scan.nextLine());

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

			quantity = Integer.parseInt(scan.nextLine());
			
			
		}
		else if(catSelect == 2){
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
			int typeSelect = Integer.parseInt(scan.nextLine());
	
			if(typeSelect != 1 && typeSelect != 2 && typeSelect != 3 ){
				while(true){
					System.out.println("That was an invalid input please try again!");
					catSelect = Integer.parseInt(scan.nextLine());
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
			
			
			quantity = Integer.parseInt(scan.nextLine());
			}
			else if(catSelect == 3){
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
				System.out.println("|                   Large: 2                           |");
				System.out.println("|                                                      |");
				System.out.println("--------------------------------------------------------");
				System.out.println();
				int typeSelect = Integer.parseInt(scan.nextLine());
		
				if(typeSelect != 1 && typeSelect != 2 && typeSelect != 3 ){
					while(true){
						System.out.println("That was an invalid input please try again!");
						catSelect = Integer.parseInt(scan.nextLine());
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
				
				
			 quantity = Integer.parseInt(scan.nextLine());
				}
				else if(catSelect == 4){
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
					int typeSelect = Integer.parseInt(scan.nextLine());
			
					if(typeSelect != 1 && typeSelect != 2 && typeSelect != 3 ){
						while(true){
							System.out.println("That was an invalid input please try again!");
							catSelect = Integer.parseInt(scan.nextLine());
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
					
					
				 quantity = Integer.parseInt(scan.nextLine());
					}
			
		
		
		

	

		// Pretend this is the user's selected category and type of furniture
	//	String selectedCategory = "Filing", selectedType = "Small";
		// This is the pretend number of furniture
		//int selectedNum = 1;

		//System.out.println(cat);
		//System.out.println(type);
		//System.out.println(quantity);

		



		FurnitureCategory catg = FurnitureCategory.getCategory(cat);
		if (catg == FurnitureCategory.NotAFurnitureCategory) {
			System.out.println("Not a category");
		} 
		else {
			FurnitureOrder request = new FurnitureOrder(catg, type, quantity);
			Order order = null;
			if (request.attemptOrder(furnitureInventory)) {


				System.out.println("                       Placing Order                          ");
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
		System.out.println();
		System.out.println("                       Order Placed!                         ");



				//pw.println("Furniture Order Form");
                output.append("Furniture Order Form");
                output.append("\n");
				//pw.println();
                output.append("\n");
				//pw.println("Faculty Name: " + facultyName);
                output.append("Faculty name: " + facultyName);
                output.append("\n");
				//pw.println("Contact: " + contact);
                output.append("Contract: " + contact);
                output.append("\n");
				//pw.println("Date " + date);
                output.append("Date " + date);
                output.append("\n");
				//pw.println();
				//pw.println("Original Request: " + type + " " + cat + ", " + quantity);
                output.append("Original Request: " + type + " " + cat + ", " + quantity);
                output.append("\n");	
                output.append("\n");
				//pw.println();
				//pw.println("Items ordered");
                output.append("Items ordered");
                output.append("\n");
				order = request.getCheapestOrder();
				//System.out.println(order.getTotalCost());
				for (Furniture furn : order.getFurnitureBought()) {
					//pw.println("ID: "+ furn.id);
                    output.append("ID: "+ furn.id);
                    output.append("\n");
				}
                output.append("\n");
				//pw.println();
				//pw.println("Total Price: $" + order.getTotalCost());
                output.append("Total Price: $" + order.getTotalCost());
                output.append("\n");

				request.sendOrderToDatabase(furnitureInventory);

			}
			else{

				
				System.out.println("Order not possible");
				System.out.println("Noted on order sheet");
				pw.println("User Request: " + type + " " + cat + ", " + quantity);	
				if(cat == "Desk"){
					System.out.println("Order cannot be fulfilled based on current inventory. Suggested manufacturers are Office Furnishings, Furniture Goods, and Fine Office Supplies.");
				}
				else if(cat =="Chair"){
					System.out.println("Order cannot be fulfilled based on current inventory. Suggested manufacturers are Office Furnishings, Chairs R Us, Furniture Goods, and Fine Office Supplies.");

				}
				
				else if(cat =="Filing"){
					System.out.println("Order cannot be fulfilled based on current inventory. Suggested manufacturers are Office Furnishings, Furniture Goods, and Fine Office Supplies.");

				}
				else if(cat =="Lamp"){
					System.out.println("Order cannot be fulfilled based on current inventory. Suggested manufacturers are Chairs R Us, Furniture Goods, and Fine Office Supplies.");

				}



				// ArrayList<String> manuPrint = furnitureInventory.findManufacturers("Desk");
				// for(int i = 0; i < manuPrint.size(); i++){
				// 	System.out.println(manuPrint.get(i));
				// }
			
			}
			
		}
		furnitureInventory.close();
		//pw.close();

        return output.toString();
	}



}
