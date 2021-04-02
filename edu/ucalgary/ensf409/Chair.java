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
    String manuID;

    public Chair(String ID, String Type, String Legs, String Arms, String Seat, String Cushion, int Price, String ManuID) {
        id = new String(ID);
        type = new String(Type);
        if (Legs.equals("Y")) {
            hasLegs = true;
        }
        if (Arms.equals("Y")) {
            hasArms = true;
        }
        if (Seat.equals("Y")) {
            hasSeat = true;
        }
        if (Cushion.equals("Y")) {
            hasCushion = true;
        }
        price = Price;
        manuID = new String(ManuID);
    }

    
}
