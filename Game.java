package org.text_based_game;

import java.util.Scanner;

/*
The Game class is a class that starts the game itself, and accepts the player's input with the use of a
switch statement that is inside a while loop that verifies the player's input so that they may navigate through the map of the game
@Abdoulie J NJie
 */
public class Game {
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame(); // call to the start game method that will initialize a run of the game
    }

    private void startGame() {
        Player player = new Player();

        String playerInput = "";

        System.out.println("Please enter any of the following keys to traverse the world:\n" +
                " |north or n|\n |south or s| \n |west or w|\n |east or e| \n" +
                "{Type in the command help to get a list of the commands used for the game!}\n"+
                "{Type in exit or press the x key to exit the game}");

        System.out.println("Welcome to Somnium!");
        System.out.println("Current Location:" + player.getCurrentRoom());


        Boolean playing = true; // boolean used to dictate when the game will continue or end.

        while (playing) { // while loop that continues the game as long the boolean variable "playing" is true
            if ((player.getCurrentRoom().getRoomID() == player.getPuzzle().getPuzzleRoomID())) {
                System.out.println(player.getPuzzle().getPuzzleDescription());
            }
            else{
                player.getPuzzle().setPuzzleAttempts(3);
            }
            while ((player.getCurrentRoom().getRoomID() == player.getPuzzle().getPuzzleRoomID()) && player.getPuzzle().getPuzzleAttempts() > -0) {
                playerInput = input.nextLine().toLowerCase(); // statement used to switch player's input into lower case characters
                player.solvePuzzle(playerInput);
            }
            playerInput = input.nextLine().toLowerCase(); // statement used to switch player's input into lower case characters
           player.changeItemObject(playerInput);

            if (playerInput.equals("help")) {
                player.help();
            } else if (playerInput.equals("north") || playerInput.equals("n")
                    || playerInput.equals("south") || playerInput.equals("s")
                    || playerInput.equals("east") || playerInput.equals("e")
                    || playerInput.equals("west") || playerInput.equals("w")) {
                player.move(playerInput);
                player.checkIfRoomHasBeenVisited();
            }
            else if (playerInput.equals("exit")|| playerInput.equals("x")) {
                player.quitGame(playerInput);
            } else if(playerInput.equals("pickup " + player.getItems().getItemName())){
                player.pickUpItem(playerInput);
            }
            else if(playerInput.equals("drop " + player.getItems().getItemName())){
                player.dropItem(playerInput);
            }
            else if(playerInput.equals("inspect " + player.getItems().getItemName())){
                player.inspectItem(playerInput);
            }
            else if(playerInput.equals("explore")){
                player.exploreRoom(playerInput);
            }
            else if (playerInput.equals("inventory")){
                player.getCurrentInventory(playerInput);
            }
            else if((!playerInput.equals(player.getPuzzle().getPuzzleAnswer()))){
                System.out.println("The command you entered is invalid, please try again\n"+
                        "{Remember, you can type help to get a list of the commands!}");
            }
            }
        }
    }

