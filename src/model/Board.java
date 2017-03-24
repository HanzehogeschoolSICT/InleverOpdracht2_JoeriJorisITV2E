package model;

import java.util.Arrays;
import java.util.Random;
import model.Board;

public class Board {
    final static int ROWS = 3;
    final static int COLLUMNS = 3;

    String[][] boardArray;

    public Board() {
        this.boardArray = new String[ROWS][COLLUMNS];
        fillArray();
    }

    public void fillArray() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLLUMNS; j++) {
                boardArray[i][j] = makeRandomChar();
            }
        }
    }

    private String makeRandomChar() {
        Random random = new Random();
        String letters = "aaabcdeeefghiiijklmnooopqrstuuuvwxyz";
        char letter = letters.charAt(random.nextInt(letters.length()));
        return Character.toString(letter);
    }

    public void printBoard() {
        for (String[] item : boardArray) {
            for (String item1 : item) {
                if (item1 != null) {
                    System.out.print(item1 + " ");
                }
            }
            System.out.println("");
        }
//        getNeighbours(0,0);
    }

    public Integer[][] getNeighbours(int xIndex, int yIndex) {
        //skelet: http://stackoverflow.com/questions/652106/finding-neighbours-in-a-two-dimensional-array
        Integer[][] neighbours = new Integer[8][2];
        int count = 0;
        int rows = boardArray.length -1;

        if (rows > 0) {
            int columns = boardArray[0].length -1;
            for (int x = Math.max(0, yIndex - 1); x <= Math.min(yIndex + 1, rows); x++) {
                for (int y = Math.max(0, xIndex - 1); y <= Math.min(xIndex + 1, columns); y++) {
                    if (x != yIndex || y != xIndex) {
                        neighbours[count][0] = x;
                        neighbours[count][1] = y;

                        count++;
                    }
                }
            }
            System.out.println("\n");
        }
        for (Integer[] item: neighbours){
            if (item[0]!= null) {
                System.out.println(boardArray[item[0]][item[1]]);
            }
        }
        return neighbours;
    }

    public String getLetter(int x, int y){
        return boardArray[x][y];
    }


    public String getBoardArray(int x, int y){
        return boardArray[x][y];
    }
}