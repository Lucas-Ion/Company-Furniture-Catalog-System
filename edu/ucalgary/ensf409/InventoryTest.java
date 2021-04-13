package edu.ucalgary.ensf409;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.sql.*;

import org.junit.Test;

/**
 * @author Athul Rajagopal, Lucas Ion, Colton Giesbrecht, Amrit Mahendrarajah
 * @version 1.0
 * @since 1.0
 */
//Please replace 'SQLusername' and 'SQLpassword' to match the username and password used to login to your local SQL server.
//Please also refresh your database 'inventory.sql' before running these tests as there are some tests which remove items from the database. Failure to do so would result in errors as the tests
//expect a full database. 
public class InventoryTest {
	private String SQLusername = "ensf409";
	private String SQLpassword = "ensf409";
	public InventoryTest()
	{
		
	}
	@Test //testing selectChairsByType to ensure that the returned ArrayList <Chair>  is as expected
	//this is accomplished by the testing function invidually accessing the database and populating ArrayList<chair> in a similar fashion to how the program would do it
	//if the ArrayList<Chair> does not match then there is an error
	public void test_selectChairsByType()
	{
		Connection dbConnect = null;
		ResultSet results = null;
		ArrayList<Chair> expectedchairs = new ArrayList<Chair>();
		try {
            	dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/inventory", SQLusername, SQLpassword);
            	Statement myStmt = dbConnect.createStatement();
            	results = myStmt.executeQuery("SELECT * FROM chair WHERE Type = '" + "Mesh" + "'");
            	while (results.next()) {
                    Chair ch = new Chair(results.getString("ID"), results.getString("Type"), results.getString("Legs"), results.getString("Arms"), results.getString("Seat"), results.getString("Cushion"), results.getInt("Price"), results.getString("ManuID"));
                    expectedchairs.add(ch);
                    
                }
            	/*System.out.println("Haaay gurrl");
            	 for (Chair chair : expectedchairs) {
                     System.out.println(chair.id + "     " + chair.hasLegs + "     " + chair.price);
                 }
                 */
            	myStmt.close();
            	results.close();
                dbConnect.close(); //close connection so that Inventory can use it 
        } catch (SQLException e) {
            e.printStackTrace();
        }
		Inventory invent = new Inventory("jdbc:mysql://localhost/inventory", SQLusername, SQLpassword);
		invent.initializeConnection();
		ArrayList<Chair> realchairs = invent.selectChairsByType("Mesh");
		//Object[] realchairr = realchairs.toArray();
		//Object[] expecchairr = expectedchairs.toArray();
		//assertArrayEquals("selectChairsByType did not return ArrayList<Chair> as expected",realchairr,expecchairr);
		//assertEquals("selectChairsByType did not return ArrayList<Chair> as expected",true,Arrays.deepEquals(expectedchairs.toArray(),realchairs.toArray()));
		assertEquals("selectChairsByType did not return ArrayList<Chair> as expected",true,Arrays.equals(expectedchairs.toArray(Chair[]::new),realchairs.toArray(Chair[]::new),( a, b)->a.id == b.id ?1:0));
	}
	@Test
	//testing selectDeskByType to ensure that the returned ArrayList <Desk>  is as expected
		//this is accomplished by the testing function invidually accessing the database and populating ArrayList<Desk> in a similar fashion to how the program would do it
		//if the ArrayList<Desk> does not match then there is an error
	public void test_selectDesksByType()
	{
		Connection dbConnect = null;
		ResultSet results = null;
		ArrayList<Desk> expecteddesk = new ArrayList<Desk>();
		try {
            	dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/inventory", SQLusername, SQLpassword);
            	Statement myStmt = dbConnect.createStatement();
            	results = myStmt.executeQuery("SELECT * FROM desk WHERE Type = '" + "Adjustable" + "'");
            	while (results.next()) {
                    Desk de = new Desk(results.getString("ID"), results.getString("Type"), results.getString("Legs"), results.getString("Top"), results.getString("Drawer"), results.getInt("Price"), results.getString("ManuID"));
                    expecteddesk.add(de);
                    
                }
            	myStmt.close();
            	results.close();
                dbConnect.close(); //close connection so that Inventory can use it 
        } catch (SQLException e) {
            e.printStackTrace();
        }
		Inventory invent = new Inventory("jdbc:mysql://localhost/inventory", SQLusername, SQLpassword);
		invent.initializeConnection();
		ArrayList<Desk> realdesk = invent.selectDesksByType("Adjustable");
		assertEquals("selectDesksByType did not return ArrayList<Desk> as expected",true,Arrays.equals(expecteddesk.toArray(Desk[]::new),realdesk.toArray(Desk[]::new),( a, b)->a.id == b.id ?1:0));
	}
	@Test
	//testing selectFilingsByType to ensure that the returned ArrayList <Filing>  is as expected
			//this is accomplished by the testing function invidually accessing the database and populating ArrayList<Filing> in a similar fashion to how the program would do it
			//if the ArrayList<Desk> does not match then there is an error
	public  void test_selectFilingsByType()
	{
		Connection dbConnect = null;
		ResultSet results = null;
		ArrayList<Filing> expectedfilings = new ArrayList<Filing>();
		try {
            	dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/inventory", SQLusername, SQLpassword);
            	Statement myStmt = dbConnect.createStatement();
            	results = myStmt.executeQuery("SELECT * FROM filing WHERE Type = '" + "Small" + "'");
            	while (results.next()) {
                    Filing de = new Filing(results.getString("ID"), results.getString("Type"), results.getString("Rails"), results.getString("Drawers"), results.getString("Cabinet"), results.getInt("Price"), results.getString("ManuID"));
                    expectedfilings.add(de);
                    
                }
            	myStmt.close();
            	results.close();
                dbConnect.close(); //close connection so that Inventory can use it 
        } catch (SQLException e) {
            e.printStackTrace();
        }
		Inventory invent = new Inventory("jdbc:mysql://localhost/inventory", SQLusername, SQLpassword);
		invent.initializeConnection();
		ArrayList<Filing> realfiling  = invent.selectFilingsByType("Small");
		assertEquals("selectFilingsByType did not return ArrayList<Filing> as expected",true,Arrays.equals(expectedfilings.toArray(Filing[]::new),realfiling.toArray(Filing[]::new),( a, b)->a.id == b.id ?1:0));
	}
	@Test
	//testing selectLampsByType to ensure that the returned ArrayList <Lamp>  is as expected
			//this is accomplished by the testing function invidually accessing the database and populating ArrayList<Filing> in a similar fashion to how the program would do it
			//if the ArrayList<Desk> does not match then there is an error
	public  void test_selectLampsByType()
	{
		Connection dbConnect = null;
		ResultSet results = null;
		ArrayList<Lamp> expectedlamp = new ArrayList<Lamp>();
		try {
            	dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/inventory", SQLusername, SQLpassword);
            	Statement myStmt = dbConnect.createStatement();
            	results = myStmt.executeQuery("SELECT * FROM lamp WHERE Type = '" + "Desk" + "'");
            	while (results.next()) {
                    Lamp la = new Lamp(results.getString("ID"), results.getString("Type"), results.getString("Base"), results.getString("Bulb"), results.getInt("Price"),  results.getString("ManuID"));
                    expectedlamp.add(la);
                    
                }
            	myStmt.close();
            	results.close();
                dbConnect.close(); //close connection so that Inventory can use it 
        } catch (SQLException e) {
            e.printStackTrace();
        }
		Inventory invent = new Inventory("jdbc:mysql://localhost/inventory", SQLusername, SQLpassword);
		invent.initializeConnection();
		ArrayList<Lamp> realLamp  = invent.selectLampsByType("Desk");
		assertEquals("selectLampsByType did not return ArrayList<Lamp> as expected",true,Arrays.equals(expectedlamp.toArray(Lamp[]::new),realLamp.toArray(Lamp[]::new),( a, b)->a.id == b.id ?1:0));
	}
	@Test
	public void test_insertChair()
	{
		Connection dbConnect = null;
		ResultSet results = null;
		try {
			Inventory invent = new Inventory("jdbc:mysql://localhost/inventory", SQLusername, SQLpassword);
			invent.initializeConnection();
			invent.insertChair("C0000", "Ergonomic", "Y", "Y", "N", "N", 69,  "002");
			//invent.close();
			dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/inventory", SQLusername, SQLpassword);
			Statement myStmt = dbConnect.createStatement();
			//String ID = "'C0000'";
			results = myStmt.executeQuery("SELECT  ID  FROM chair WHERE  ID = 'C0000'");
			results.next();
			assertEquals("InsertChair did not insert the item into the database, as the ID of the retrieved entry does not match the ID of the inserted entry",results.getString("ID"),"C0000");
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	@Test
	public void test_findManuIDs()
	{
		Connection dbConnect = null;
		ResultSet results = null;
		ArrayList<String> expectedvalue = new ArrayList<String>();
		try {
				dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/inventory", SQLusername, SQLpassword);
				Statement myStmt = dbConnect.createStatement();
	            results = myStmt.executeQuery("SELECT ManuID FROM " + "Chair" );
	            
	            results.next();
	            String tmp = results.getString("ManuID");
	            expectedvalue.add(tmp);
	            //the 3 lines above are needed to store the ManuID from the first line of results
	            while (results.next()) {
	                 if (!results.getString("ManuID").equals(tmp)) {
	                     tmp = results.getString("ManuID");
	                     expectedvalue.add(tmp);
	                 }
	            }
	            myStmt.close();
	            results.close();
	            dbConnect.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		Inventory invent = new Inventory("jdbc:mysql://localhost/inventory", SQLusername, SQLpassword);
		invent.initializeConnection();
		ArrayList<String> realvalue = invent.findManuIDs("Chair");
		assertEquals("findManuID did not return the expected ArrayList<String> which contains the manuID's",true,Arrays.equals(expectedvalue.toArray(String[]::new),realvalue.toArray(String[]::new),( a, b)->a == b ?1:0));
	}
	@Test
	public void test_findManufacturers()
	{
		Connection dbConnect = null;
		ResultSet results = null;
		
		ArrayList<String> ManuID = new ArrayList<String>();
		ArrayList<String> expectedManufacturerList = new ArrayList<String>();
		try {
				dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/inventory", SQLusername, SQLpassword);
				Statement myStmt = dbConnect.createStatement();
	            results = myStmt.executeQuery("SELECT ManuID FROM " + "Desk" );
	            
	            results.next();
	            String tmp = results.getString("ManuID");
	            ManuID.add(tmp);
	            //the 3 lines above are needed to store the ManuID from the first line of results
	            while (results.next()) {
	                 if (!results.getString("ManuID").equals(tmp)) {
	                     tmp = results.getString("ManuID");
	                     ManuID.add(tmp);
	                 }
	            }
	            myStmt.close();
	            results.close();
	            dbConnect.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		for(String manuID: ManuID)
		{
		try {
			dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/inventory", SQLusername, SQLpassword);
			Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT Name FROM manufacturer WHERE ManuID =  '" + manuID +"'" );
            
            
            while (results.next()) {
                 expectedManufacturerList.add(results.getString("Name"));
            }
            myStmt.close();
            results.close();
            dbConnect.close();
		
	}catch(SQLException e)
	{
		e.printStackTrace();
	}
		
	}
		//dbConnect.close();
		//inventory code here
		Inventory invent = new Inventory("jdbc:mysql://localhost/inventory", SQLusername, SQLpassword);
		invent.initializeConnection();
		ArrayList<String> realManufacturerList = invent.findManufacturers("Desk");
		assertEquals("findManufacturers did not return the expected ArrayList<String> which contains the manufacturer Names",true,Arrays.equals(expectedManufacturerList.toArray(String[]::new),realManufacturerList.toArray(String[]::new),( a, b)->a == b ?1:0));
		
		 
	}
	@Test
	/**
	 * Testing addParts method of Order class 
	 * Checking to ensure that the price is  added to totalCost, numOfComponents array is updated accordingly, and that the added furniture is added to  furnitureBought
	 */
	public void test_addParts()
	{
		Boolean[] parts = {true,true,true,true};
		Furniture furniture = new Furniture(parts,150,"0003","1234","swankydesk");
		Order testOrder = new Order(4,1);
		testOrder.addParts(furniture);
		int expectedcost = 150;
		ArrayList<Furniture> furnitureBoughtExpected = new ArrayList<Furniture>();
		furnitureBoughtExpected.add(furniture);
		int[] numOfComponentsExpected = {1,1,1,1};
		boolean furniturearraylistsareequal = Arrays.equals(testOrder.getFurnitureBought(),furnitureBoughtExpected.toArray(Furniture[]::new));
		boolean finalverdict = false;
		if(furniturearraylistsareequal == true && Arrays.equals(numOfComponentsExpected, testOrder.getNumOfComponents()) == true && expectedcost == testOrder.getTotalCost())
		{
			finalverdict = true;
		}
		assertEquals("addParts did not correctly add the part to testOrder",true,finalverdict);
	}
	@Test
	/**
	 * Testing isOrderFullfilled method of Order class
	 * if  the number of single components for a given furniture object is less than the desired number of furniture, this should return false 
	 */
	public void test_isOrderFullfilled()
	{
		Boolean[] parts = {true,true,false,true};
		Furniture furniture = new Furniture(parts,150,"0003","1234","swankydesk");
		Order testOrder = new Order(4,1);
		testOrder.addParts(furniture);
		boolean expected = false;
		assertEquals("isOrderFullfilled did not return boolean as expected ",expected,testOrder.isOrderFulfilled());
	}
	@Test
	/**
	 * Testing the getter method for NumOfComponents in Order class
	 * Fails if it does not return the expected Array
	 */
	public void test_getNumOfComponents()
	{
		Boolean[] parts = {true,true,false,true};
		Furniture furniture = new Furniture(parts,150,"0003","1234","swankydesk");
		Order testOrder = new Order(4,1);
		testOrder.addParts(furniture);
		int[] numOfComponentsExpected = {1,1,0,1};
		assertEquals("getNumOfComponents did not return the expected int[]",true,Arrays.equals(numOfComponentsExpected, testOrder.getNumOfComponents()));
	}
	@Test
	/*
	 *  Testing the getter method for getTotalCost in Order class
	 *  adding two pieces of furniture to the order 
	 *  will return false if the expectedTotalCost does not equal the value returned by getTotalCost
	 */
	public void test_getTotalCost()
	{
		Boolean[] parts = {true,true,true,true};
		Furniture furniture = new Furniture(parts,300,"0003","1234","swankydesk");
		Furniture furniture1 = new Furniture(parts,400,"0003","1234","swankydesk");
		Order testOrder = new Order(4,1);
		testOrder.addParts(furniture);
		testOrder.addParts(furniture1);
		int expectedTotalCost = 700;
		assertEquals("getTotalCost did not return the expected totalCost",expectedTotalCost,testOrder.getTotalCost());
	}
	@Test 
	/*
	 *  Testing the getter method for getNumOfFurniture in Order class
	 *  adding two pieces of furniture to the order 
	 *  will return false if the expectedNumOfFurniture does not equal the value returned by get
	 */
	public void test_getNumOfFurniture()
	{
		Order testOrder = new Order(4,2);
		int expectedNumOfFurniture = 2;
		assertEquals("getNumOfFurniture did not return the expected NumOfFurniture",expectedNumOfFurniture,testOrder.getNumOfFurniture());
	}
	@Test
	/*
	 * Testing the getter method for getFurnitureBought
	 * returns false if the Furniture[] returned does not match 
	 */
	public void test_getFurnitureBought()
	{
		Boolean[] parts = {true,true,true,true};
		Furniture furniture = new Furniture(parts,300,"0003","1234","swankydesk");
		Furniture furniture1 = new Furniture(parts,400,"0003","1234","swankydesk");
		Furniture[] expectedFurnitureBought = {furniture, furniture1};
		Order testOrder = new Order(4,1);
		testOrder.addParts(furniture);
		testOrder.addParts(furniture1);
		assertEquals("getFurnitureBought did not return the expected Furniture[]",true,Arrays.equals(expectedFurnitureBought,testOrder.getFurnitureBought()));
	}
	@Test
	/*
	 * Testing the getter method getNumFurnitureBoughjt
	 * returns false if the expected number of furniture bought is not correct
	 */
	public void test_getNumFurnitureBought()
	{
		Boolean[] parts = {true,true,true,true};
		Furniture furniture = new Furniture(parts,300,"0003","1234","swankydesk");
		Furniture furniture1 = new Furniture(parts,400,"0003","1234","swankydesk");
		int expectednumFurnitureBought = 2;
		Order testOrder = new Order(4,1);
		testOrder.addParts(furniture);
		testOrder.addParts(furniture1);
		assertEquals("getNumFurnitureBought did not return the expected number of furniture bought",expectednumFurnitureBought,testOrder.getNumFurnitureBought());
	}
	@Test
	/*
	 * 
	 */
	public void test_setCategory_Order()
	{
		Boolean[] parts = {true,true,true,true};
		Furniture furniture = new Furniture(parts,300,"0003","1234","Desk");
		Order testOrder = new Order(4,1);
		testOrder.addParts(furniture);
		//String cat = "Desk";
		testOrder.setCategory(FurnitureCategory.getCategory("Desk"));
		String expectedstring = "Desk";
		String realstring = testOrder.getCategory().name();
		assertEquals("getCategory did not return category as expected",expectedstring,realstring);
	}
	@Test
	/*
	 * 
	 */
	public void test_getCategory_Order()
	{
		Boolean[] parts = {true,true,true,true};
		Furniture furniture = new Furniture(parts,300,"0003","1234","Desk");
		Order testOrder = new Order(4,1);
		testOrder.addParts(furniture);
		//String cat = "Desk";
		testOrder.setCategory(FurnitureCategory.getCategory("Lamp"));
		String expectedstring = "Lamp";
		String realstring = testOrder.getCategory().name();
		assertEquals("getCategory did not return category as expected",expectedstring,realstring);
	}
	@Test
	/**
	 * 
	 */
	public void test_setType()
	{
		Boolean[] parts = {true,true,true,true};
		Furniture furniture = new Furniture(parts,300,"0003","1234","Standing");
		Order testOrder = new Order(4,1);
		testOrder.addParts(furniture);
		testOrder.setType("Swing Arm");
		String expectedType = "Swing Arm";
		assertEquals("setType did not set the type correctly",expectedType,testOrder.getType());
		
	}
	@Test
	/**
	 * 
	 */
	public void test_getType()
	{
		Boolean[] parts = {true,true,true,true};
		Furniture furniture = new Furniture(parts,300,"0003","1234","Standing");
		Order testOrder = new Order(4,1);
		testOrder.addParts(furniture);
		testOrder.setType("Swing Arm");
		String expectedType = "Swing Arm";
		assertEquals("getType did not set the type correctly",expectedType,testOrder.getType());
		
	}
	
	@Test
	//Testing Furniture Order for 2 desk lamps. The total price should be no more than 40 dollars.
	public void test_getCheapestOrder()
	{
		Inventory furnitureInventory = new Inventory("jdbc:mysql://localhost/inventory", SQLusername, SQLpassword);
		furnitureInventory.initializeConnection();
		FurnitureOrder request = new FurnitureOrder(FurnitureCategory.getCategory("Lamp"),"Desk",2);
		Order order = null;
		request.attemptOrder(furnitureInventory);
		order = request.getCheapestOrder();
		int expectedPrice = 40;
		furnitureInventory.close();
		assertEquals(" test_FurnitureOrder_find_lowest_price_2DeskLamps did not return the expected price",expectedPrice,order.getTotalCost());
		
	}
	
	
	@Test
	//Test to make sure attemptOrder returns false when it gets an order it cannot fill
	public void test_attemptOrder()
	{
		Inventory furnitureInventory = new Inventory("jdbc:mysql://localhost/inventory", SQLusername, SQLusername);
		furnitureInventory.initializeConnection();
		FurnitureOrder request = new FurnitureOrder(FurnitureCategory.getCategory("Filing"),"Small",5);
		Order order = null;
		boolean realvalue = request.attemptOrder(furnitureInventory);
		boolean expectedvalue = false;
		furnitureInventory.close();
		assertEquals("attemptOrder did not return the expected value",expectedvalue,realvalue);
	}
	@Test
	//test to ensure when an order can be filled, all the appropriate items are removed from the database
	public void test_sendOrderToDatabase()
	{
		Inventory furnitureInventory = new Inventory("jdbc:mysql://localhost/inventory", SQLusername, SQLpassword);
		furnitureInventory.initializeConnection();
		ArrayList<Desk> expectedvalue =  furnitureInventory.selectDesksByType("Standing");
		expectedvalue.remove(0);
		expectedvalue.remove(1);
		
		
		FurnitureOrder request = new FurnitureOrder(FurnitureCategory.getCategory("Desk"),"Standing",1);
		Order order = null;
		request.attemptOrder(furnitureInventory);
		order = request.getCheapestOrder();
		request.sendOrderToDatabase(furnitureInventory);
		ArrayList<Desk> realvalue = furnitureInventory.selectDesksByType("Standing");
		furnitureInventory.close();
		assertEquals("sendOrderToDatabase did not remove the items from the database",true,Arrays.equals(expectedvalue.toArray(Furniture[]::new),realvalue.toArray(Furniture[]::new),( a, b)->a.id == b.id ?1:0));
	}
	
	
	@Test
	/**
	 * Checks and makes sure Order format and content is correct.
	 * formatOutput is the string that is written to the file
	 * Looks for 1 Desk Lamp
	 */
	public void test_formatOutput()
	{
		FileIO test = new FileIO();
		test.setCat("Lamp");
		test.setType("Desk");
		test.setQuantity(1);
		test.setDate("12/12/21");
		test.setContact("Joe Test");
		test.setFacultyName("Software Engineering");
		String expectedOutput = "Furniture Order Form\n" + 
				"\n" + 
				"Faculty name: Software Engineering\n" + 
				"Contract: Joe Test\n" + 
				"Date 12/12/21\n" + 
				"\n" + 
				"Original Request: Desk Lamp, 1\n" + 
				"\n" + 
				"Items ordered\n" + 
				"ID: L564\n" +  
				"\n" + 
				"Total Price: $20\n" ;
		assertEquals("formatOutput did not return the expected String",expectedOutput,test.formatOutput());
	}
	@Test
	/*
	 * 
	 */
	public void test_getCategory_enum()
	{
		String expectedcategory = "Lamp";
		FurnitureCategory cat = FurnitureCategory.getCategory(expectedcategory);
		String realcategory = cat.toString();
		assertEquals("getCategory from the enum FurnitureCategory did not return the Cateogry as expected",realcategory,expectedcategory);
	}
	
	
	/*@Test
	public void test_main()
	{
		Main main = new Main();
		main.catSelect = 1; //select a chair
		main.type = "Mesh";//select mesh chair
		main.quantity = 2;
		
		String[] args = {"",""};
		main.main(args);
		main.catSelect = 1; //select a chair
		main.type = "Mesh";//select mesh chair
		main.quantity = 2;
		
		 
		
	}
	*/
    
    
	
	
	
	
	
	
}
