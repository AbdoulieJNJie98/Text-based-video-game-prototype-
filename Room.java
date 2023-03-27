package org.text_based_game;

import java.util.ArrayList;

/*
Room class holds all the information needed to define a rooms object.
For instance, values such as the roomID number, room visited status, and the other room ID number based on their directions
are set and retrieved here.
@Abdoulie J NJie
 */
public class Room {

    private int  roomID = 0;
    private boolean roomVisited = false;
    private String roomName = "";
    private int northRoomID = 0;
    private int southRoomID = 0;
    private int westRoomID = 0;

    private int eastRoomID = 0;
    private String roomDescription = "";



    private String itemName = "";
    private  ArrayList  roomInventory ;

    public Room() {

    }

    public Room(int roomID, boolean roomVisitedStatus, String roomName,
                int northRoomID, int southRoomID, int eastRoomID, int westRoomID, String roomDescription, String itemName) {
        this.roomID = roomID;
        this.roomVisited = roomVisitedStatus;
        this.roomName = roomName;
        this.northRoomID = northRoomID;
        this.southRoomID = southRoomID;
        this.westRoomID = westRoomID;
        this.eastRoomID = eastRoomID;
        this.roomDescription = roomDescription;
        this.itemName = itemName;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public boolean isRoomVisited() {

        return roomVisited;
    }

    public void setRoomVisited(boolean roomVisitedStatus) {
        this.roomVisited  = roomVisitedStatus;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomDescription = roomName;
    }

    public int getNorthRoomID() {
        return northRoomID;
    }

    public void setNorthRoomID(int northRoomID) {
        this.northRoomID = northRoomID;
    }

    public int getSouthRoomID() {
        return southRoomID;
    }

    public void setSouthRoomID(int southRoomID) {
        this.southRoomID = southRoomID;
    }

    public int getWestRoomID() {
        return westRoomID;
    }

    public void setWestRoomID(int westRoomID) {
        this.westRoomID = westRoomID;
    }

    public int getEastRoomID() {
        return eastRoomID;
    }

    public void setEastRoomID(int eastRoomID) {
        this.eastRoomID = eastRoomID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void addItem(ArrayList roomInventory){
        roomInventory.add(itemName);
    }


    @Override
    public String toString() {
        return  roomName;
    }
}