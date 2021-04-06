package edu.ucalgary.ensf409;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.*;

import org.junit.Test;

public class InventoryTest {
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
            	dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/inventory", "ensf409", "ensf409");
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
		Inventory invent = new Inventory("jdbc:mysql://localhost/inventory", "ensf409", "ensf409");
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
            	dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/inventory", "ensf409", "ensf409");
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
		Inventory invent = new Inventory("jdbc:mysql://localhost/inventory", "ensf409", "ensf409");
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
            	dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/inventory", "ensf409", "ensf409");
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
		Inventory invent = new Inventory("jdbc:mysql://localhost/inventory", "ensf409", "ensf409");
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
            	dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/inventory", "ensf409", "ensf409");
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
		Inventory invent = new Inventory("jdbc:mysql://localhost/inventory", "ensf409", "ensf409");
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
			Inventory invent = new Inventory("jdbc:mysql://localhost/inventory", "ensf409", "ensf409");
			invent.initializeConnection();
			invent.deleteFurniture("Chair", "C0000");
			invent.insertChair("C0000", "Ergonomic", "Y", "Y", "N", "N", 69,  "002");
			//invent.close();
			dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/inventory", "ensf409", "ensf409");
			Statement myStmt = dbConnect.createStatement();
			results = myStmt.executeQuery("SELECT  ID  FROM chair WHERE  ID = C0000");
			assertEquals("InsertChair did not insert the item into the database, as the ID of the retrieved entry does not match the ID of the inserted entry",results.getString("ID"),"C0000");
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	@Test
	//Testing Furniture Order for 2 desk lamps. The total price should be no more than 40 dollars.
	public void test_FurnitureOrder_find_lowest_price_2DeskLamps()
	{
		Inventory furnitureInventory = new Inventory("jdbc:mysql://localhost/inventory", "ensf409", "ensf409");
		furnitureInventory.initializeConnection();
		FurnitureOrder request = new FurnitureOrder(FurnitureCategory.getCategory("Lamp"),"Desk",2);
		Order order = null;
		request.attemptOrder(furnitureInventory);
		order = request.getCheapestOrder();
		int expectedPrice = 40;
		furnitureInventory.close();
		assertEquals(" test_FurnitureOrder_find_lowest_price_2DeskLamps did not return the expected price",expectedPrice,order.getTotalCost());
		
	}
	/*@Test
	//test to ensure when an order can be filled, all the appropriate items are removed from the database
	public void test_sendOrderToDatabase()
	{
		Inventory furnitureInventory = new Inventory("jdbc:mysql://localhost/inventory", "ensf409", "ensf409");
		furnitureInventory.initializeConnection();
		FurnitureOrder request = new FurnitureOrder(FurnitureCategory.getCategory("Desk"),"Standing",1);
		Order order = null;
		request.attemptOrder(furnitureInventory);
		order = request.getCheapestOrder();
		
		
	}
	*/
	@Test
	//Test to make sure attemptOrder returns false when it gets an order it cannot fill
	public void test_FurnitureOrder_cannot_fullfill_order()
	{
		Inventory furnitureInventory = new Inventory("jdbc:mysql://localhost/inventory", "ensf409", "ensf409");
		furnitureInventory.initializeConnection();
		FurnitureOrder request = new FurnitureOrder(FurnitureCategory.getCategory("Filing"),"Small",5);
		Order order = null;
		boolean realvalue = request.attemptOrder(furnitureInventory);
		boolean expectedvalue = false;
		furnitureInventory.close();
		assertEquals("test_FurnitureOrder_cannot_fullfill_order did not return the expected value",expectedvalue,realvalue);
	}
	@Test
	//test to ensure when an order can be filled, all the appropriate items are removed from the database
	public void test_sendOrderToDatabase()
	{
		Inventory furnitureInventory = new Inventory("jdbc:mysql://localhost/inventory", "ensf409", "ensf409");
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
	
	
	
	
	
}
