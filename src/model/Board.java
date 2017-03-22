package model;

import java.util.Random;
import model.Board;

public class Board {
    final static int ROWS = 7;
    final static int COLLUMNS = 7;

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
        String letters = "aaabcdeeefghiiijklmnooopqrstuuuvwxyz";
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
        model.Tree.fillTree(boardArray);
    }

//    public void getNeighbours(int i){
//        int row_limit = boardArray.length;
//        if(row_limit > 0){
//            int column_limit = boardArray[0].length;
//            for(int x = Math.max(0, i-1); x <= Math.min(i+1, row_limit); x++){
//                for(int y = Math.max(0, j-1); y <= Math.min(j+1, column_limit); y++){
//                    if(x != i || y != j){
//                        System.out.println(boardArray[x][y]);
//                    }
//                }
//            }
//        }
//    }
}