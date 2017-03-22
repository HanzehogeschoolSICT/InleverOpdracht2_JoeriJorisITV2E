package model;

import java.util.Random;

public class Board {
    int rows = 3;
    int collumns = 3;
    String[][] boardArray = new String[rows][collumns];
    public Board(){
        fillArray();
    }

    public void fillArray(){
        for(int i=0; i<rows; i++){
            for(int j=0; j<collumns;j++){
//                boardArray[i][j] = c;
                makeRandomChar();
//                System.out.println(Arrays.toString(boardArray));
            }
        }

    }

    public void makeRandomChar(){
        Random random = new Random();
        int randomInt = (int)(random.nextInt()*26);
        char base = (randomInt<26 ? 'A':'a');
        System.out.println(base);
//        return (char) (base+random % 26);
    }
}