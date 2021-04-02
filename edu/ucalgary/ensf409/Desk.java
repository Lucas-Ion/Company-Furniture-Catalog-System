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
    String manuId;

    public Desk(String id, String type, String legs, String top, String drawer, int price, String manuId) {
        this.id = new String(id);
        this.type = new String(type);
        if (legs.equals("Y")) {
            hasLegs = true;
        }
        if (top.equals("Y")) {
            hasTop = true;
        }
        if (drawer.equals("Y")) {
            hasDrawer = true;
        }
        this.price = price;
        this.manuId = new String(manuId);
    }
}
