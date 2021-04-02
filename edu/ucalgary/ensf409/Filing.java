package edu.ucalgary.ensf409;

//Contains information about an individual filing, including its ID, Type, Price, ManuID, and 
//whether it has rails, drawers, and a cabinet.
public class Filing {
    String id;
    String type;
    boolean hasRails = false;
    boolean hasDrawers = false;
    boolean hasCabinet = false;
    int price;
    String manuId;

    public Filing(String id, String type, String rails, String drawers, String cabinet, int price, String manuId) {
        this.id = new String(id);
        this.type = new String(type);
        if (rails.equals("Y")) {
            hasRails = true;
        }
        if (drawers.equals("Y")) {
            hasDrawers = true;
        }
        if (cabinet.equals("Y")) {
            hasCabinet = true;
        }
        this.price = price;
        this.manuId = new String(manuId);
    }
}
