//package org.text_based_game;
///*
//The Map class reads in the designated text file and generates a map based on the data stored in that said file.
//The data is then stored into a hashmap that is made up of room objects, and uses each respective room's ID number as the key
//to access the data that is associated with each key.
//
//Example of default map format:
//	|6|
//	|5|
// |3||2||4|
//	|1|
//
//2/9/23: Will have to update to receive a more in depth description of each room that will only be accessed by the
//Room classes getInDepthDescription, which will be handled in the player class when they choose to inspect the room
//
//@Abdoulie J NJie
// */
//
//
//import java.util.HashMap;
//import java.util.Scanner;
//
//
//public class testerMapClass {
//
//    public testerMapClass() {
//        readRoomFile();
//    } // method used to read the room files
//    // String used to represent file name
//    String filePath = "rooms.txt";
//    // hash map used to store and retrieve the elements read from file
//    HashMap<Integer, Room> hashMap = new HashMap<Integer, Room>();
//
//
//    // method used to read file
//    public void readRoomFile() {
//
//        Scanner readingMapFile = null;
//
//        // try catch statement that uses a buffered reader to read the text file, split data in the text file based on the commas found within it,
//        // and stores the information in a hash map, or prints a IO Exception to indicate an issue with reading in the desired file.
//        try {
//            readingMapFile = new Scanner(filePath);
//        } catch (Exception e) {
//            System.out.println("File not found - terminating program");
//            System.exit(0);
//            e.printStackTrace();
//        }
//        String roomID = readingMapFile.next("\\~");
//        boolean roomVisitedStatus = Boolean.parseBoolean(readingMapFile.next("\\~"));
//        ;
//        String roomName = readingMapFile.next("\\~");
//        String northRoomID = readingMapFile.next("\\~");
//        String southRoomID = readingMapFile.next("\\~");
//        String eastRoomID = readingMapFile.next("\\~");
//        String westRoomID = readingMapFile.next("\\~");
//        String roomDescription = readingMapFile.next("\\~");
//
//        readingMapFile.useDelimiter("\\~");
//        if (readingMapFile.hasNext("\\~")) {
//            // temp room object used to hold information collected from current iteration of loop
//            Room r = new Room(Integer.parseInt(roomID), roomVisitedStatus, roomName,
//                    Integer.parseInt(northRoomID), Integer.parseInt(southRoomID), Integer.parseInt(eastRoomID), Integer.parseInt(westRoomID), roomDescription, itemName);
//            hashMap.put(r.getRoomID(), r); // used to add the values stored in the temp room to the hash map
//        }
//    }
//}
//
//
//
//
