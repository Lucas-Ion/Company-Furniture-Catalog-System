package edu.ucalgary.ensf409;

//Contains information about an individual chair, including its ID, Type, Price, ManuID, and 
//whether it has legs, arms, a seat, and a cushion.
public class Chair {
    String id;
    String type;
    boolean hasLegs = false;
    boolean hasArms = false;
    boolean hasSeat = false;
    boolean hasCushion = false;
    int price;
    String manuId;

    public Chair(String id, String type, String legs, String arms, String seat, String cushion, int price, String manuId) {
        this.id = new String(id);
        this.type = new String(type);
        if (legs.equals("Y")) {
            hasLegs = true;
        }
        if (arms.equals("Y")) {
            hasArms = true;
        }
        if (seat.equals("Y")) {
            hasSeat = true;
        }
        if (cushion.equals("Y")) {
            hasCushion = true;
        }
        this.price = price;
        manuId = new String(manuId);
    }

    
}
