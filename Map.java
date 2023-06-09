package org.text_based_game;
/*
The Map class reads in the designated text file and generates a map based on the data stored in that said file.
The data is then stored into a hashmap that is made up of room objects, and uses each respective room's ID number as the key
to access the data that is associated with each key.

Example of default map format:
	|6|
	|5|
 |3||2||4|
	|1|

2/9/23: Will have to update to receive a more in depth description of each room that will only be accessed by the
Room classes getInDepthDescription, which will be handled in the player class when they choose to inspect the room

@Abdoulie J NJie
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;


public class Map {
    // String used to represent file name
    public String roomsFilePath = "rooms.txt";
    public String itemsFilePath = "Items.txt";
    public String puzzlesFilePath = "Puzzles.txt";
    // hash map used to store and retrieve the elements read from file
    public HashMap<Integer, Room> hashMapRooms = new HashMap<Integer, Room>();
    public HashMap<Integer, Items> hashMapItems = new HashMap<Integer, Items>();
    public HashMap<Integer, Puzzles> hashMapPuzzles = new HashMap<Integer, Puzzles>();



    public Map() {
        readFiles();
    } // method used to read the room files


    // method used to read file
    public void readFiles() {
        // try catch statement that uses a buffered reader to read the text file, split data in the text file based on the commas found within it,
        // and stores the information in a hash map, or prints a IO Exception to indicate an issue with reading in the desired file.
        try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(roomsFilePath)); // buffer reader used to read the file
            while ((line = bufferedReader.readLine()) != null) { // while loop that reads until the end of the file

                String [] parts = line.split("~", 9); // String array used to each element in the given file individually
                if (parts.length >= 9) {
                    // temp room object used to hold information collected from current iteration of loop
                    Room r = new Room(Integer.parseInt(parts[0]), Boolean.parseBoolean(parts[1]), parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]),
                            Integer.parseInt(parts[5]), Integer.parseInt(parts[6]),parts[7],parts[8]);
                    hashMapRooms.put(r.getRoomID(), r); // used to add the values stored in the temp room to the hash map
                }

            }
            bufferedReader.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // try catch statement that uses a buffered reader to read the text file, split data in the text file based on the commas found within it,
        // and stores the information in a hash map, or prints a IO Exception to indicate an issue with reading in the desired file.
        try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(itemsFilePath)); // buffer reader used to read the file
            while ((line = bufferedReader.readLine()) != null) { // while loop that reads until the end of the file

                String [] parts = line.split("~", 3); // String array used to each element in the given file individually
                if (parts.length >= 3) {
                    // temp item object used to hold information collected from current iteration of loop
                    Items i = new Items(Integer.parseInt(parts[0]), parts[1], parts[2]);
                    hashMapItems.put(i.getItemRoomID(), i); // used to add the values stored in the temp items to the hash map
                }

            }
            bufferedReader.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // try catch statement that uses a buffered reader to read the text file, split data in the text file based on the commas found within it,
        // and stores the information in a hash map, or prints a IO Exception to indicate an issue with reading in the desired file.
        try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(puzzlesFilePath)); // buffer reader used to read the file
            while ((line = bufferedReader.readLine()) != null) { // while loop that reads until the end of the file

                String [] parts = line.split("~", 7); // String array used to each element in the given file individually
                if (parts.length >= 6){
                    // temp room object used to hold information collected from current iteration of loop
                    Puzzles p = new Puzzles(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3],parts[4], Integer.parseInt(parts[5]), Boolean.parseBoolean(parts[6]));
                    hashMapPuzzles.put(p.getPuzzleRoomID(), p); // used to add the values stored in the temp puzzle to the hash map
                }

            }
            bufferedReader.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}




