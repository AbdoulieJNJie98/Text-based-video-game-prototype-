package org.text_based_game;
/*
This player class is used to allow the player to traverse the map,
and contains two private room classes and one map class that allows
the player to know what room they're currently in, what the room they previously
were in, and a method named move that uses a switch case statement to manipulate
where the player can and cannot go when navigating through the map
@Abdoulie J NJie
 */

import java.util.ArrayList;


public class Player {
    private Room currentRoom;
    private Room previousRoom;
    private Map map;
    private Items items;
    int changeItemObject = 0;
    private Puzzles puzzle;

    private ArrayList<String> playerInventory = new ArrayList<>();
    private ArrayList<String> roomInventory = new ArrayList<>();


    public Player() {
        map = new Map();
        currentRoom = map.hashMapRooms.get(1);
        puzzle = map.hashMapPuzzles.get(5);
        items = map.hashMapItems.get(1);
        roomInventory.add(items.getItemName());
        changeItemObject = items.getItemRoomID();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Puzzles getPuzzle() {
        return puzzle;
    }

    public Items getItems() {
        return items;
    }


    public void help() {
        System.out.println("List of commands:\n" +
                "|north or n| |south or s| |west or w| |east or e| \n" +
                "The commands above are what are needed to move to different rooms in the game\n" +
                "|add| |drop| |inventory| |explore| |inspect|\n" +
                "The add command allows you to add items to your inventory\n" +
                "The drop command allows you to drop items from your inventory\n" +
                "The inventory command will display all the items in your current inventory\n" +
                "The explore command will display the room description and any items in the room\n" +
                "The inspect command will display the designated item's description, as long as it is in your inventory");
    }

    public void move(String playerInput) {
        if (playerInput.equals("north") || playerInput.equals("n")) {
            if (currentRoom.getNorthRoomID() != 0) {
                items.setRoomID(currentRoom.getRoomID());
                items = map.hashMapItems.get(currentRoom.getRoomID());
                roomInventory.remove(items.getItemName());
                items.setRoomID(currentRoom.getNorthRoomID());
                items = map.hashMapItems.get(currentRoom.getNorthRoomID());
                currentRoom.setRoomVisited(true);
                previousRoom = currentRoom;
                currentRoom = map.hashMapRooms.get(currentRoom.getNorthRoomID());
                if (!(playerInventory.contains(items.getItemName()))) {
                    items.setRoomID(currentRoom.getRoomID());
                    items = map.hashMapItems.get(items.getItemRoomID());
                    roomInventory.add(items.getItemName());
                }
                System.out.println("You have arrived to " + getCurrentRoom());
            } else {
                System.out.println("There is no room that way (current room " + currentRoom + " )");
            }
        } else if (playerInput.equals("south") || playerInput.equals("s")) {
            if (currentRoom.getSouthRoomID() != 0) {
                items.setRoomID(currentRoom.getRoomID());
                items = map.hashMapItems.get(currentRoom.getRoomID());
                roomInventory.remove(items.getItemName());
                items.setRoomID(currentRoom.getSouthRoomID());
                items = map.hashMapItems.get(currentRoom.getSouthRoomID());
                currentRoom.setRoomVisited(true);
                previousRoom = currentRoom;
                currentRoom = map.hashMapRooms.get(currentRoom.getSouthRoomID());
                if (!(playerInventory.contains(items.getItemName()))) {
                    items.setRoomID(currentRoom.getRoomID());
                    items = map.hashMapItems.get(items.getItemRoomID());
                    roomInventory.add(items.getItemName());

                }
                System.out.println("You have arrived to " + getCurrentRoom());

            } else {
                System.out.println("There is no room that way (current room " + currentRoom + " )");
            }
        } else if (playerInput.equals("east") || playerInput.equals("e")) {
            if (currentRoom.getEastRoomID() != 0) {
                items.setRoomID(currentRoom.getRoomID());
                items = map.hashMapItems.get(currentRoom.getRoomID());
                roomInventory.remove(items.getItemName());
                currentRoom.setRoomVisited(true);
                items.setRoomID(currentRoom.getEastRoomID());
                items = map.hashMapItems.get(currentRoom.getEastRoomID());
                roomInventory.remove(items.getItemName());
                previousRoom = currentRoom;
                currentRoom = map.hashMapRooms.get(currentRoom.getEastRoomID());
                if (!(playerInventory.contains(items.getItemName()))) {
                    items.setRoomID(currentRoom.getRoomID());
                    items = map.hashMapItems.get(items.getItemRoomID());
                    roomInventory.add(items.getItemName());
                }
                System.out.println("You have arrived to " + getCurrentRoom());
            } else {
                System.out.println("There is no room that way (current room " + currentRoom + " )");
            }
        } else if (playerInput.equals("west") || playerInput.equals("w")) {
            if (currentRoom.getWestRoomID() != 0) {
                items.setRoomID(currentRoom.getRoomID());
                items = map.hashMapItems.get(currentRoom.getRoomID());
                roomInventory.remove(items.getItemName());
                items.setRoomID(currentRoom.getWestRoomID());
                items = map.hashMapItems.get(currentRoom.getWestRoomID());
                currentRoom.setRoomVisited(true);
                previousRoom = currentRoom;
                currentRoom = map.hashMapRooms.get(currentRoom.getWestRoomID());
                if (!(playerInventory.contains(items.getItemName()))) {
                    items.setRoomID(currentRoom.getRoomID());
                    items = map.hashMapItems.get(items.getItemRoomID());
                    roomInventory.add(items.getItemName());
                }
                System.out.println("You have arrived to " + getCurrentRoom());
            } else {
                System.out.println("There is no room that way (current room " + currentRoom + " )");
            }
        }
    }

    public static void quitGame(String playerInput) {
        System.out.println("Thanks for playing!");

        System.exit(0);
    }


    public void checkIfRoomHasBeenVisited() {
        if (currentRoom.isRoomVisited()) {
            System.out.println("This room seems familiar");
        }
    }
    public void solvePuzzle(String playerInput) {
        puzzle.checkPlayersAnswer(playerInput);
    }

    public void changeItemObject(String playerInput){
        if(playerInput.contains(currentRoom.getItemName().toLowerCase())){
            items.setRoomID(currentRoom.getRoomID());
        }
        else{
            items.setRoomID(changeItemObject);
        }
        items = map.hashMapItems.get(items.getItemRoomID());
    }
    //method used to add items to player's inventory
    public void pickUpItem(String playerInput) {
        if (playerInput.equals("pickup " + items.getItemName()) && roomInventory.contains(items.getItemName()) &&
                (!items.getItemName().isEmpty()) && (!playerInventory.contains(items.getItemName()))) {
            playerInventory.add(items.getItemName());
            roomInventory.remove(items.getItemName());
            System.out.println(items.getItemName() + " has been added to inventory");
        } else
            System.out.println("The item you attempted to add to your inventory is either currently in your inventory,\n" +
                    " not in the room, or was spelled incorrectly");
    }

    // method used to drop item from player's inventory, and leave them in the room the player is currently in
    public void dropItem(String playerInput) {
        if (playerInput.equals("drop " + items.getItemName()) && playerInventory.contains(items.getItemName())) {
            playerInventory.remove(items.getItemName());
            changeItemObject = items.getItemRoomID();
            roomInventory.add(items.getItemName());
            System.out.println(items.getItemName() + " has been removed from inventory");
        } else {

            System.out.println("The item you attempt to drop is not in your inventory");
        }
    }

    //method used to inspect item and will return the item's description
    public void inspectItem(String playerInput) {
        if (playerInput.equals("inspect " + items.getItemName()) && playerInventory.contains(items.getItemName())) {
            System.out.println(items.getItemDescription());
        } else
            System.out.println("The item you attempt to inspect is not in your inventory");
    }


    // method used to view player's inventory

    public void getCurrentInventory(String playerInput) {
        if (playerInput.contains("inventory") && playerInventory.isEmpty()) {
            System.out.println("There is nothing currently in your inventory");
        } else
            System.out.println(playerInventory);
    }

    // method used to display any items in the room the player is currently in, and the room's description
    public void exploreRoom(String playerInput) {
        if (playerInput.equals("explore")) {
            //System.out.println("Current room Number: " + currentRoom.getRoomID() + " Current Item number: " + items.getItemRoomID());
            System.out.println(currentRoom.getRoomDescription() + "\nItems in this room: " + roomInventory);

        }

    }

}

