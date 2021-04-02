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
    String manuID;

    public Filing(String ID, String Type, String Rails, String Drawers, String Cabinet, int Price, String ManuID) {
        id = new String(ID);
        type = new String(Type);
        if (Rails.equals("Y")) {
            hasRails = true;
        }
        if (Drawers.equals("Y")) {
            hasDrawers = true;
        }
        if (Cabinet.equals("Y")) {
            hasCabinet = true;
        }
        price = Price;
        manuID = new String(ManuID);
    }
}
