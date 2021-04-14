package edu.ucalgary.ensf409;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
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
	private  PrintStream standardOut = System.out;
	private  ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	
	@Test 
	/**
	 * testing the selectChairssByType method of Inventory class
	 * Accessing the database directly and populating an ArrayList<Chairs> expectedchairs
	 * Comparing this to the ArrayList<Chairs> returned by selectChairsByType.
	 * Test fails if they do not match
	 */
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
	/**
	 * testing the selectDesksByType method of Inventory class
	 * Accessing the database directly and populating an ArrayList<Desk> expecteddesk
	 * Comparing this to the ArrayList<Desk> returned by selectDesksByType.
	 * Test fails if they do not match
	 */
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
	/**
	 * testing the selectFilingsByType method of Inventory class
	 * Accessing the database directly and populating an ArrayList<Filings> expectedfilings
	 * Comparing this to the ArrayList<Filings> returned by selectFilingsByType
	 * Test fails if they do not match
	 */
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
	/**
	 * testing the selectLampsByType method of Inventory class
	 * Accessing the database directly and populating an ArrayList<Lamp> expectedLamp
	 * Comparing this to the ArrayList<Lamp> returned by selectLampsByType.
	 * Test fails if they do not match
	 */
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
	/**
	 * Testing the method insertChair of Inventory Class  by acessing the database direclty  and attemtping to retrieve the inserted Chair.
	 * The test fails if the id of the retrieved Chair does not match the  id of the Chair inserted using insertChair
	 */
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
	/**
	 * Testing the method findManuIDs of the Inventory class 
	 * Tested by populating an ArrayList<String> of all the uniqeManuID's by connecting to the database directly and then comparing that with the ArrayList<String> returned by findManuID's
	 * The test fails if these two ArrayList<String> do not match
	 */
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
	/**
	 * Testing the method findManufacturers of the Inventory class
	 * First populating a ArrayList<String> of all the unique manuID's and then using those manuID's to populate an ArrayList<String> of manufacturers
	 * Comparing this ArrayList<String> to the ArrayList<String> returned by findManufacturers. The test fails if they do not match
	 */
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
	 * Checking to ensure that the price is  added to totalCost, numOfComponents array is updated accordingly, and that the added furniture is added to furnitureBought
	 */
	public void test_addParts()
	{
		Boolean[] parts = {true,true,true,true};
		Furniture furniture = new Furniture(parts,150,"001","D1234","Traditional");
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
		assertEquals("addParts did not correctly add the part to the Order",true,finalverdict);
	}
	@Test
	/*
	 * Testing isOrderFullfilled method of Order class
	 * Should return true, as there are enough parts to make 1 desk
	 */
	public void test_isOrderFullfilled_true()
	{
		//2 desks in the furnitureBought array, with numComponents[] having value of {1,1,1,1}
				//therefore between the two desks there are enough parts to make 1 desk
				//should return true if OrderFullfilled is working as expected
		Boolean[] parts = {true,true,false,true};
		Boolean[] parts1 = {false,false,true,false};

		Furniture furniture = new Furniture(parts,150,"001","D1234","Standing");
		Furniture furniture1 = new Furniture(parts1, 200,"002","D4321","Standing");
		Order testOrder = new Order(4,1);
		testOrder.addParts(furniture);
		testOrder.addParts(furniture1);
		boolean expected = true;
		assertEquals("isOrderFullfilled_true did not return boolean as expected ",expected,testOrder.isOrderFulfilled());
	}
	@Test
	/**
	 * Testing isOrderFullfilled method of Order class
	 * Should return false, as there aren't enough parts to make 1 desk
	 */
	public void test_isOrderFullfilled_false()
	{
		//only 1 desk in the furnitureBought array, with numComponents[] having value of {1,1,0,1}
		//therefore there aren't enough parts to make 1 desk. 
		//should return false if OrderFullfilled is working as expected
		Boolean[] parts = {true,true,false,true};
		Furniture furniture = new Furniture(parts,150,"001","D1234","Standing");
		Order testOrder = new Order(4,1);
		testOrder.addParts(furniture);
		boolean expected = false;
		assertEquals("isOrderFullfilled_false did not return boolean as expected ",expected,testOrder.isOrderFulfilled());
	}
	@Test
	/**
	 * Testing the getter method for getNumOfComponents in Order class
	 */
	public void test_getNumOfComponents()
	{
		Boolean[] parts = {true,true,false,true};
		Furniture furniture = new Furniture(parts,150,"003","D4521","Traditional");
		Order testOrder = new Order(4,1);
		testOrder.addParts(furniture);
		int[] numOfComponentsExpected = {1,1,0,1};
		assertEquals("getNumOfComponents did not return the expected int[]",true,Arrays.equals(numOfComponentsExpected, testOrder.getNumOfComponents()));
	}
	@Test
	/*
	 *  Testing the getter method for getTotalCost in Order class
	 */
	public void test_getTotalCost()
	{
		Boolean[] parts = {true,true,true,true};
		Furniture furniture = new Furniture(parts,150,"001","D5678","Standing");
		Furniture furniture1 = new Furniture(parts,200,"002","D7891","Standing");
		Order testOrder = new Order(4,1);
		testOrder.addParts(furniture);
		testOrder.addParts(furniture1);
		int expectedTotalCost = 350;
		assertEquals("getTotalCost did not return the expected totalCost",expectedTotalCost,testOrder.getTotalCost());
	}
	@Test 
	/*
	 *  Testing the getter method  getNumOfFurniture in Order class
	 */
	public void test_getNumOfFurniture()
	{
		Order testOrder = new Order(4,2);
		int expectedNumOfFurniture = 2;
		assertEquals("getNumOfFurniture did not return the expected number of furniture",expectedNumOfFurniture,testOrder.getNumOfFurniture());
	}
	@Test
	/*
	 * Testing the getter method  getFurnitureBought of Order class
	 */
	public void test_getFurnitureBought()
	{
		Boolean[] parts = {true,true,true,true};
		Furniture furniture = new Furniture(parts,300,"002","C1234","Mesh");
		Furniture furniture1 = new Furniture(parts,400,"003","C4321","Mesh");
		Furniture[] expectedFurnitureBought = {furniture, furniture1};
		Order testOrder = new Order(4,1);
		testOrder.addParts(furniture);
		testOrder.addParts(furniture1);
		assertEquals("getFurnitureBought did not return the expected Furniture[]",true,Arrays.equals(expectedFurnitureBought,testOrder.getFurnitureBought()));
	}
	@Test
	/*
	 * Testing the getter method getNumFurnitureBought of Order class
	 */
	public void test_getNumFurnitureBought()
	{
		Boolean[] parts = {true,true,true,true};
		Furniture furniture = new Furniture(parts,300,"002","C1234","Mesh");
		Furniture furniture1 = new Furniture(parts,400,"001","C4321","Mesh");
		int expectednumFurnitureBought = 2;
		Order testOrder = new Order(4,1);
		testOrder.addParts(furniture);
		testOrder.addParts(furniture1);
		assertEquals("getNumFurnitureBought did not return the expected number of furniture bought",expectednumFurnitureBought,testOrder.getNumFurnitureBought());
	}
	@Test
	/*
	 * Testing the setCategory method of Order class
	 */
	public void test_setCategory_Order()
	{
		Order testOrder = new Order(4,1);
		testOrder.setCategory(FurnitureCategory.getCategory("Desk"));
		String expectedstring = "Desk";
		String realstring = testOrder.getCategory().name();
		assertEquals("setCategory_Order did not return category as expected",expectedstring,realstring);
	}
	@Test
	/*
	 * Testing the getCategory method of Order class
	 */
	public void test_getCategory_Order()
	{
		Order testOrder = new Order(4,1);
		testOrder.setCategory(FurnitureCategory.getCategory("Lamp"));
		String expectedstring = "Lamp";
		String realstring = testOrder.getCategory().name();
		assertEquals("getCategory_Order did not return category as expected",expectedstring,realstring);
	}
	@Test
	/**
	 *  Testing the setter method setType of Order class
	 */
	public void test_setType()
	{
		Order testOrder = new Order(2,2);
		testOrder.setType("Kneeling");
		String expectedType = "Kneeling";
		assertEquals("setType did not set the type correctly",expectedType,testOrder.getType());
		
	}
	@Test
	/**
	 * Testing the getter method getType of Order class
	 */
	public void test_getType()
	{
		Order testOrder = new Order(4,1);
		testOrder.setType("Swing Arm");
		String expectedType = "Swing Arm";
		assertEquals("getType did not return the type correctly",expectedType,testOrder.getType());
		
	}
	
	@Test
	/**
	 * Testing method getCheapestOrder of FurnitureOrder class.. Checking if it actually returns the cheapest order. 
	 * Chose to order 1 traditional desk because there is only 1 possible order that gives the cheapest price, assuming a full database. This order  is D8675 and D0890 with a total price of a $100
	 * In this way we can compare the actual output to the expected output to ensure the method works.
	 */
	//*********One of the tests that needs Original database as posted on D2L**********
	public void test_getCheapestOrder()
	{
		Inventory furnitureInventory = new Inventory("jdbc:mysql://localhost/inventory", SQLusername, SQLpassword);
		furnitureInventory.initializeConnection();
		FurnitureOrder request = new FurnitureOrder(FurnitureCategory.getCategory("Desk"),"Traditional",1);
		Order order = null;
		request.attemptOrder(furnitureInventory);
		order = request.getCheapestOrder();
		//creating an Order object that matches the   expected Order object that getCheapestOrder would return 
		Order expectedOrder = new Order(3,1);
		Boolean[] expectedItem1hasComponents = {true,true,false};
		Furniture expectedItem1 = new Furniture(expectedItem1hasComponents,75,"001","D8675","Traditional");
		Boolean[] expectedItem2hasComponents = {false,false,true};
		Furniture expectedItem2 = new Furniture(expectedItem2hasComponents,25,"002","D0890","Traditional"); 
		expectedOrder.addParts(expectedItem1);
		expectedOrder.addParts(expectedItem2);
		FurnitureCategory cat = FurnitureCategory.getCategory("Desk");
		expectedOrder.setCategory(cat);
		expectedOrder.setType("Traditional");
		furnitureInventory.close();
		Furniture[] furn = expectedOrder.getFurnitureBought();
		for(int i = 0; i < furn.length; i++)
		{
			System.out.println( "ID:  " + furn[i].id);
		}
		boolean finalverdict = false;
		//Check all the attributes to make sure the contents of expectedOrder and order are the same. Could not use expectedOrder.equals(order) because the method will compare if the references in ArrayList<Furniture> are the same, which returns false
		if(expectedOrder.getTotalCost() == order.getTotalCost() && Arrays.equals(expectedOrder.getFurnitureBought(),order.getFurnitureBought(),(a,b)->a.id == b.id ?1:0) && Arrays.equals(expectedOrder.getNumOfComponents(),order.getNumOfComponents()) && 
		expectedOrder.getNumOfFurniture() == order.getNumOfFurniture() && expectedOrder.getCategory().equals(order.getCategory()) && expectedOrder.getType().equals(order.getType()) )
		{
				finalverdict = true;
		}
		assertEquals("getCheapestOrder did not return the expected Order",true,finalverdict);
		
	}
	
	
	@Test
	/*
	 * Test of method attemptOrder of FurnitureOrder class
	 * Test to ensure it returns false when an Order cannot be fullfilled. 
	 * Gave the method an impossible order of 5 small filing cabinets, which is not possible given the data in the database. 
	 * Expect that it returns false. Therefore, if it returns true, the test has failed.  
	 */
	//*********One of the tests that needs Original database as posted on D2L**********
	public void test_attemptOrder()
	{
		Inventory furnitureInventory = new Inventory("jdbc:mysql://localhost/inventory", SQLusername, SQLpassword);
		furnitureInventory.initializeConnection();
		FurnitureOrder request = new FurnitureOrder(FurnitureCategory.getCategory("Filing"),"Small",5);
		Order order = null;
		boolean realvalue = request.attemptOrder(furnitureInventory);
		boolean expectedvalue = false;
		furnitureInventory.close();
		assertEquals("attemptOrder did not return the expected value",expectedvalue,realvalue);
	}
	@Test
	/**
	 * Test of method sendOrderToDatabase of FurnitureOrder class 
	 * Testing to make sure that the desired  items are removed from the database. 
	 * Chose an Order with only 1 combination that gives the cheapest price, so that we can predict the output. Therefore, this allows us to predict which items will be removed. 
	 * One of the orders which fulfills this requirement is 1 standing desk, for which the cheapest price is  300 hundred dollars, made up of items D1927 and D2341, assuming a full database that matches 
	 * the original inventory.sql found on D2L.
	 */
	//*********One of the tests that needs Original database as posted on D2L**********
	public void test_sendOrderToDatabase()
	{
		//Use the selectDesksByType method from  Inventory class  to find all the standing desks
		//remove the first two entries from the ArrayList<Desk> expectedvalue, to simulate what selectDesksByType will return once sendOrderToDatabase has run
		Inventory furnitureInventory = new Inventory("jdbc:mysql://localhost/inventory", SQLusername, SQLpassword);
		furnitureInventory.initializeConnection();
		ArrayList<Desk> expectedvalue =  furnitureInventory.selectDesksByType("Standing");
		expectedvalue.remove(0);
		expectedvalue.remove(1);
		
		//make the Order for 1 Standing  desk, and then call sendOrderToDatabase once the cheapest order has been found
		//this should  remove D1927 and D2341 from the database
		//as a result, when selectDesksByType("Standing") is called on the updated database, the first two entries should be removed. 
		FurnitureOrder request = new FurnitureOrder(FurnitureCategory.getCategory("Desk"),"Standing",1);
		Order order = null;
		request.attemptOrder(furnitureInventory);
		order = request.getCheapestOrder();
		request.sendOrderToDatabase(furnitureInventory);
		ArrayList<Desk> realvalue = furnitureInventory.selectDesksByType("Standing");
		furnitureInventory.close();
		//compare the ArrayLists<Desk> realvalue and expected value. If they match, the test passes. If they dont match, the test fails .
		assertEquals("sendOrderToDatabase did not remove the items from the database",true,Arrays.equals(expectedvalue.toArray(Furniture[]::new),realvalue.toArray(Furniture[]::new),( a, b)->a.id == b.id ?1:0));
	}
	
	
	@Test
	/**
	 * testing method formatOutput of FileIO class
	 * 
	 * formatOutput is the string that is written to the file
	 * Needs an Order where we can predict the output for comparison
	 * Ordering 1 Desk Lamp fits this criterion, assuming a full database.
	 * Note that the user input is simulated using the setters in the FileIO class. When the program is run outside of a testing framework, the setters are fed the userinput from Scanners.
	 */
	//*********One of the tests that needs Original database as posted on D2L**********
	public void test_formatOutput_1()
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
				"Contact: Joe Test\n" + 
				"Date: 12/12/21\n" + 
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
	/**
	 * Testing FormatOutput in a similar fashion to FormatOutput2 except that instead of ordering 1 item of type Lamp, we will order 2  Large Filing cabinets
	 */
	public void test_FormatOutput_2()
	{
		FileIO test = new FileIO();
		test.setCat("Filing");
		test.setType("Large");
		test.setQuantity(2);
		test.setDate("06/12/21");
		test.setContact("Michael Test");
		test.setFacultyName("Electrical Engineering");
		String expectedOutput = "Furniture Order Form\n" + 
				"\n" + 
				"Faculty name: Electrical Engineering\n" + 
				"Contact: Michael Test\n" + 
				"Date: 06/12/21\n" + 
				"\n" + 
				"Original Request: Large Filing, 2\n" + 
				"\n" + 
				"Items ordered\n" + 
				"ID: F010\n" +
				"ID: F011\n" +
				"ID: F012\n" +
				"ID: F015\n" +
				"\n" + 
				"Total Price: $600\n" ;
		assertEquals("FormatOutput_2 did not return the expected String",expectedOutput,test.formatOutput());
	}
	@Before
	public void setUp() {
	    System.setOut(new PrintStream(outputStream));
	}
	@After//restoring output stream to original state once all  tests terminate
	public void tearDown() {
	    System.setOut(standardOut);
	}
	@Test
	/**
	 *  Test to see if FormatOutput informs the user that an Order cannot be fulfilled in the expected format when the selected category is  desk
	 */
	public void test_FormatOutput_3()
	{
		
		
		
		File file = new File("original.txt");
		File file2 = new File("new.txt");
		
		
		FileIO test = new FileIO();
		test.setCat("Desk");
		test.setType("Adjustable");
		test.setQuantity(6);
		test.setDate("06/03/21");
		test.setContact("Michael Test");
		test.setFacultyName("Electrical Engineering");
		test.formatOutput();
		StringBuilder expectedOutput = new StringBuilder();
		//String expectedOutput = 
		expectedOutput.append("Order not possible\n") ;
		expectedOutput.append("User Request: " + "Adjustable" + " " + "Desk" + ", " + "6" + "\n"); 
			expectedOutput.append("Order cannot be fulfilled based on current inventory. Suggested manufacturers are Office Furnishings, Furniture Goods, and Fine Office Supplies.\n");
			expectedOutput.append("\n");
			
		assertEquals("test_FormatOutput_3 did not print the expected message to System.out", expectedOutput.toString().trim(), outputStream.toString().trim());
		
	}
	@Test
	/**
	 * Testing to make sure format Output prints "Not a category" to the console when an invalid category is entered
	 */
	public void test_FormatOutput_4()
	{
		FileIO test = new FileIO();
		test.setCat("Car");
		test.setType("Adjustable");
		test.setQuantity(6);
		test.setDate("06/03/21");
		test.setContact("Michael Test");
		test.setFacultyName("Electrical Engineering");
		test.formatOutput();
		String expectedOutput = "Not a category";
		assertEquals("test_FormatOutput_4 did not print the expected message to System.out",expectedOutput,outputStream.toString().trim());
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
