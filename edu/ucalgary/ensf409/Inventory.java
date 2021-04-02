/**
 * @author: Athul Rajagopal, Lucas Ion, Amrit Mahendrarajah, Colton Giesbrecht
 * @version: 1.2
 * @since: 1.0
 */

package edu.ucalgary.ensf409;
import java.sql.*;
import java.util.*;

public class Inventory {
    private Connection dbConnect;
    private ResultSet results;
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;

    public Inventory(String url, String user, String pass) {
        DBURL = url;
        USERNAME = user;
        PASSWORD = pass;
    }

    //connects to database with the user-inputted databaseURL, username, and password
    public void initializeConnection() {
        try {
            dbConnect = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Finds all chairs with a specific type, then stores these chairs and their related info in
    //an ArrayList of Chair objects. Returns this ArrayList.
    public ArrayList<Chair> selectChairsByType(String type) {
        ArrayList<Chair> chairs = new ArrayList<Chair>();
        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM chair WHERE Type = '" + type + "'");

            while (results.next()) {
                Chair ch = new Chair(results.getString("ID"), results.getString("Type"), results.getString("Legs"), results.getString("Arms"), results.getString("Seat"), results.getString("Cushion"), results.getInt("Price"), results.getString("ManuID"));
                chairs.add(ch);
            }
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chairs;
    }

    //Finds all desks with a specific type, then stores these desks and their related info in
    //an ArrayList of Desk objects. Returns this ArrayList.
    public ArrayList<Desk> selectDesksByType(String type) {
        ArrayList<Desk> desks = new ArrayList<Desk>();
        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM desk WHERE Type = '" + type + "'");

            while (results.next()) {
                Desk de = new Desk(results.getString("ID"), results.getString("Type"), results.getString("Legs"), results.getString("Top"), results.getString("Drawer"), results.getInt("Price"), results.getString("ManuID"));
                desks.add(de);
            }
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return desks;
    }

    //Finds all filings with a specific type, then stores these filings and their related info in
    //an ArrayList of Filing objects. Returns this ArrayList.
    public ArrayList<Filing> selectFilingsByType(String type) {
        ArrayList<Filing> filings = new ArrayList<Filing>();
        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM filing WHERE Type = '" + type + "'");

            while (results.next()) {
                Filing fi = new Filing(results.getString("ID"), results.getString("Type"), results.getString("Rails"), results.getString("Drawers"), results.getString("Cabinet"), results.getInt("Price"), results.getString("ManuID"));
                filings.add(fi);
            }
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filings;
    }

    //Finds all lamps with a specific type, then stores these lamps and their related info in
    //an ArrayList of Lamp objects. Returns this ArrayList.
    public ArrayList<Lamp> selectLampsByType(String type) {
        ArrayList<Lamp> lamps = new ArrayList<Lamp>();
        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM lamp WHERE Type = '" + type + "'");

            while (results.next()) {
                Lamp la = new Lamp(results.getString("ID"), results.getString("Type"), results.getString("Base"), results.getString("Bulb"), results.getInt("Price"), results.getString("ManuID"));
                lamps.add(la);
            }
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lamps;
    }

    //Inserts chair into database. Used for testing delete method.
    public void insertChair(String id, String type, String legs, String arms, String seat, String cushion, int price, String manuId) {
        try {
            String query = "INSERT INTO chair (ID, Type, Legs, Arms, Seat, Cushion, Price, ManuID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1, id);
            myStmt.setString(2, type);
            myStmt.setString(3, legs);
            myStmt.setString(4, arms);
            myStmt.setString(5, seat);
            myStmt.setString(6, cushion);
            myStmt.setInt(7, price);
            myStmt.setString(8, manuId);

            int rowCount = myStmt.executeUpdate();
            System.out.println("Rows affected: " + rowCount);

            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Deletes furniture with a specified type from inventory, if it exists. Can be used to update
    //database after an order form has been submitted.
    public void deleteFurniture(String inventoryType, String id) {
        try {
            String query = "DELETE FROM " + inventoryType + " WHERE ID = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1, id);

            int rowCount = myStmt.executeUpdate();
            System.out.println("Rows affected: " + rowCount);

            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //closes and releases all connections to the database
    public void close() {
        try {
            results.close();
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Inventory myJDBC = new Inventory("jdbc:mysql://localhost/inventory", "ensf409", "ensf409"); //note that username and password are for my computer's SQL
        myJDBC.initializeConnection();
        ArrayList<Chair> meshChairs = myJDBC.selectChairsByType("Mesh");
        for (Chair chair : meshChairs) {
            System.out.println(chair.id + "     " + chair.hasLegs + "     " + chair.price);
        }
        System.out.println();
        ArrayList<Desk> adjustableChairs = myJDBC.selectDesksByType("Adjustable");
        for (Desk desk : adjustableChairs) {
            System.out.println(desk.id + "     " + desk.hasLegs + "     " + desk.price);
        }
        System.out.println();
        ArrayList<Filing> smallFilings = myJDBC.selectFilingsByType("Small");
        for (Filing filing : smallFilings) {
            System.out.println(filing.id + "     " + filing.hasDrawers + "     " + filing.price);
        }
        System.out.println();
        ArrayList<Lamp> deskLamps = myJDBC.selectLampsByType("Desk");
        for (Lamp lamp : deskLamps) {
            System.out.println(lamp.id + "     " + lamp.hasBulb + "     " + lamp.manuId);
        }
        myJDBC.insertChair("C0000", "Ergonomic", "Y", "Y", "N", "N", 69, "002");
        myJDBC.deleteFurniture("chair", "C0000");
        myJDBC.close();
    }
}