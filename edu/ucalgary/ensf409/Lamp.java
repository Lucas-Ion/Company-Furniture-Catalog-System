package edu.ucalgary.ensf409;

//Contains information about an individual filing, including its ID, Type, Price, ManuID, and 
//whether it has a base and a bulb.
public class Lamp {
    String id;
    String type;
    boolean hasBase = false;
    boolean hasBulb = false;
    int price;
    int manuID;

    public Lamp(String ID, String Type, String Base, String Bulb, int Price, int ManuID) {
        id = new String(ID);
        type = new String(Type);
        if (Base.equals("Y")) {
            hasBase = true;
        }
        if (Bulb.equals("Y")) {
            hasBulb = true;
        }
        price = Price;
        manuID = ManuID;
    }
}
