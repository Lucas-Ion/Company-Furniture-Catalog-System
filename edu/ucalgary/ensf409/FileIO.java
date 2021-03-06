package edu.ucalgary.ensf409;

import java.util.*;
import java.io.*;

/**
 * @author Athul Rajagopal, Lucas Ion, Colton Giesbrecht, Amrit Mahendrarajah
 * @version 1.4
 * @since 1.0
 */



/**
 * The FileIO class handles the user input passed to it by main, and then returns the 
 * relevant output file in .txt form based on the current database values
 */

public class FileIO {
    


	public static File outFile;
    public static FileWriter fw;
    public static PrintWriter pw;

    private  String cat = null;
    private  String type = null;
    private  int quantity = 0;
    private  String date = null;
    private  String facultyName = null;
    private String contact = null;
	String deskError;
	String chairError;
	String filingError;
	String lampError;

    
    /**
	 * Default constructor, does nothing
	 */

    public FileIO(){
    
    }

	/**
	 * 
	 * @param cat @param setType @param setQuantity @param setContact @param setFacultyName @param setDate
	 * are the standard setters for this function, to populate the FileIO object
	 */
    public void setCat(String cat){
        this.cat = cat;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setContact(String contact){
        this.contact = contact;
    }
    public void setFacultyName(String facultyName){
        this.facultyName = facultyName;
    }
    public void setDate(String date){
        this.date = date;
    }


	/**
	 * A public method with creates a return string based on the database and FileIO varibles, and returns a string
	 * with the formatted output to be written to the .txt file. Accepts no arguments
	 * @return String
	 */

	public String formatOutput(){

         StringBuilder output = new StringBuilder();

		 Scanner scan = new Scanner(System.in);


		Inventory furnitureInventory = new Inventory("jdbc:mysql://localhost/inventory", "lucas", "ensf409");
		furnitureInventory.initializeConnection();

		

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
                output.append("Contact: " + contact);
                output.append("\n");
				//pw.println("Date " + date);
                output.append("Date: " + date);
                output.append("\n");
				//pw.println();
				//pw.println("Original Request: " + type + " " + cat + ", " + quantity);
                output.append("\n");
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
			/**
			 * If the order cannot be fulfilled, it informs the user of avaliable manufacturers
			 */
			else{

				
				
				System.out.println("Order not possible");
				//System.out.println("Noted on order sheet");
				System.out.println("User Request: " + type + " " + cat + ", " + quantity);	
				if(cat == "Desk"){
					deskError = "Order cannot be fulfilled based on current inventory. Suggested manufacturers are Office Furnishings, Furniture Goods, and Fine Office Supplies.";
					System.out.println(deskError);
				}
				else if(cat =="Chair"){
					chairError = "Order cannot be fulfilled based on current inventory. Suggested manufacturers are Office Furnishings, Chairs R Us, Furniture Goods, and Fine Office Supplies.";
					System.out.println(chairError);

				}
				
				else if(cat =="Filing"){
					filingError = "Order cannot be fulfilled based on current inventory. Suggested manufacturers are Office Furnishings, Furniture Goods, and Fine Office Supplies.";
					System.out.println("Order cannot be fulfilled based on current inventory. Suggested manufacturers are Office Furnishings, Furniture Goods, and Fine Office Supplies.");

				}
				else if(cat =="Lamp"){
					System.out.println("Order cannot be fulfilled based on current inventory. Suggested manufacturers are Chairs R Us, Furniture Goods, and Fine Office Supplies.");

				}


			
			}
			
		}
		furnitureInventory.close();
		//pw.close();

		
        return output.toString();
	}



}
