package edu.ucalgary.ensf409;

import java.util.*;
import java.io.*;


public class FileIO {
    


	static File outFile;
    static FileWriter fw;
    static PrintWriter pw;

    private  String cat = null;
    private  String type = null;
    private  int quantity = 0;
    private  String date = null;
    private  String facultyName = null;
    private String contact = null;

    
    

    public FileIO(){
    
    }

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
                output.append("Contract: " + contact);
                output.append("\n");
				//pw.println("Date " + date);
                output.append("Date " + date);
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
			else{

				
				System.out.println("Order not possible");
				//System.out.println("Noted on order sheet");
				System.out.println("User Request: " + type + " " + cat + ", " + quantity);	
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
