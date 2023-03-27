package org.text_based_game;
/*
 Items class will use a hash map that reads in a text file of items that will be associated
 with their respective rooms, it will also hard code what it is read from the file into the game
 so that the player may interact with each item

 @Abdoulie J NJie
 */


import java.util.ArrayList;

public class Items {


    private int itemRoomID = 0;
    private String itemName = "";
    private String itemDescription = "";
    private ArrayList<String> arrayListOfItemNames = new ArrayList<>();
    private Map map;

    public Items() {
    map = new Map();
    }

    public Items(int itemRoomID, String itemName, String itemDescription) {
        this.itemRoomID = itemRoomID;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    public int getItemRoomID() {
        return itemRoomID;
    }

    public void setRoomID(int itemRoomID) {
        this.itemRoomID = itemRoomID;
    }

    public String getItemName() {
        setItemName(itemName.toLowerCase());
        return itemName;
    }

    public void setItemName(String itemName) {

        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }



}


