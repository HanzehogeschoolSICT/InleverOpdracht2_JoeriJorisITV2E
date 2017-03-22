package model;

import java.util.Random;

public class Board {
    final static int ROWS = 3;
    final static int COLLUMNS = 3;
    String[][] boardArray;
    public Board(){
        this.boardArray = new String[ROWS][COLLUMNS];
        fillArray();
    }

    public void fillArray(){
        for(int i = 0; i< ROWS; i++){
            for(int j = 0; j< COLLUMNS; j++){
                boardArray[i][j] = makeRandomChar();
            }
        }
    }

    private String makeRandomChar(){
        Random random = new Random();
        String letters = "abcdefghijklmnopqrstuvwxyz";
        char letter = letters.charAt(random.nextInt(letters.length()));
        return Character.toString(letter);
    }

    public void printBoard(){
        for (String[] item: boardArray){
            for (String item1: item){
                System.out.print(item1 +  " ");
            }
            System.out.println("");
        }
    }

}