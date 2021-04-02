package edu.ucalgary.ensf409;

//Contains information about an individual desk, including its ID, Type, Price, ManuID, and 
//whether it has legs, a top, and a drawer.
public class Desk {
    String id;
    String type;
    boolean hasLegs = false;
    boolean hasTop = false;
    boolean hasDrawer = false;
    int price;
    String manuID;

    public Desk(String ID, String Type, String Legs, String Top, String Drawer, int Price, String ManuID) {
        id = new String(ID);
        type = new String(Type);
        if (Legs.equals("Y")) {
            hasLegs = true;
        }
        if (Top.equals("Y")) {
            hasTop = true;
        }
        if (Drawer.equals("Y")) {
            hasDrawer = true;
        }
        price = Price;
        manuID = new String(ManuID);
    }
}
