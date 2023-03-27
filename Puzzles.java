package org.text_based_game;
/*
  Puzzle class will use a hash map to read in a text file of puzzles that will be associated with
  their respective room ID, this class will stop the player from leaving the room unless they have
   solved the puzzle, or have ran out attempts. The puzzle will not be accessible once solved
   and will refresh attempts when the player leaves the room
  that the player may not enter a certain room without first solving the puzzle

  @Abdoulie J NJie
 */

import java.util.Scanner;

public class Puzzles {

    private int puzzleRoomID = 0;
    private String puzzleDescription = "";

    private String puzzleAnswer = "";
    private String puzzleAnsweredCorrectlyMsg = "";
    private String puzzleNotAnsweredCorrectlyMsg = "";
    private int puzzleAttempts = 0;
    private Boolean puzzleSolvedStatus = false;

    Puzzles() {

    }

    public Puzzles(int puzzleRoomID, String puzzleDescription, String puzzleAnswer, String puzzleAnsweredCorrectlyMsg,
                   String puzzleNotAnsweredCorrectlyMsg, int puzzleAttempts,
                   Boolean puzzleSolvedStatus) {
        this.puzzleRoomID = puzzleRoomID;
        this.puzzleDescription = puzzleDescription;
        this.puzzleAnswer = puzzleAnswer;
        this.puzzleAnsweredCorrectlyMsg = puzzleAnsweredCorrectlyMsg;
        this.puzzleNotAnsweredCorrectlyMsg = puzzleNotAnsweredCorrectlyMsg;
        this.puzzleAttempts = puzzleAttempts;
        this.puzzleSolvedStatus = puzzleSolvedStatus;
    }

    public int getPuzzleRoomID() {
        return puzzleRoomID;
    }

    public void setPuzzleRoomID(int roomID) {
        this.puzzleRoomID = roomID;
    }

    public String getPuzzleAnswer() {
        return puzzleAnswer;
    }

    public void setPuzzleAnswer(String puzzleAnswer) {
        this.puzzleAnswer = puzzleAnswer;
    }

    public String getPuzzleDescription() {
        return puzzleDescription;
    }

    public void setPuzzleDescription(String puzzleDescription) {
        this.puzzleDescription = puzzleDescription;
    }

    public String getPuzzleAnsweredCorrectlyMsg() {
        return puzzleAnsweredCorrectlyMsg;
    }

    public void setPuzzleAnsweredCorrectlyMsg(String puzzleAnsweredCorrectlyMsg) {
        this.puzzleAnsweredCorrectlyMsg = puzzleAnsweredCorrectlyMsg;
    }

    public String getPuzzleNotAnsweredCorrectlyMsg() {
        return puzzleNotAnsweredCorrectlyMsg;
    }

    public void setPuzzleNotAnsweredCorrectlyMsg(String puzzleNotAnsweredCorrectlyMsg) {
        this.puzzleNotAnsweredCorrectlyMsg = puzzleNotAnsweredCorrectlyMsg;
    }

    public int getPuzzleAttempts() {
        return puzzleAttempts;
    }

    public void setPuzzleAttempts(int puzzleAttempts) {
        this.puzzleAttempts = puzzleAttempts;
    }

    public Boolean getPuzzleSolvedStatus() {
        return puzzleSolvedStatus;
    }

    public void setPuzzleSolvedStatus(Boolean puzzleSolvedStatus) {
        this.puzzleSolvedStatus = puzzleSolvedStatus;
    }


    // method used to check user input for puzzle
    public void checkPlayersAnswer(String playerInput) {
        if (!(playerInput.equals(puzzleAnswer))) {
            puzzleAttempts--;
            System.out.println(puzzleNotAnsweredCorrectlyMsg + "Number of attempts left: " + puzzleAttempts);

            if (puzzleAttempts == 0 && !puzzleSolvedStatus) {
                System.out.println("The number of allowed attempts for the puzzle has been reached,\n" +
                        " and will reset when you re-enter this room.");
            }

        } else {
            System.out.println(puzzleAnsweredCorrectlyMsg);
            puzzleSolvedStatus = true;
            puzzleRoomID = 0;
        }

    }

}
