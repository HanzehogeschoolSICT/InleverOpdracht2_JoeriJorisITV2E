package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class GetSolutions {
    List alreadyBeenHere;
    ArrayList<String> hits = new ArrayList<>();
    Set<String> hitsSet;
    Board board;

    public GetSolutions(List alreadyBeenHere, Board mainBoard){
        this.alreadyBeenHere = alreadyBeenHere;
        this.board = mainBoard;
    }

    public void backtrackFunction(String startCombination, int xLastLetter, int yLastLetter) {
        Word result = checkInWordlist(startCombination);
        if (result == Word.WORD_START) {
            if (result == Word.WORD_COMPLETE) {
                hits.add(startCombination);
            }

            Integer[][] neighbours = board.getNeighbours(yLastLetter, xLastLetter);
            for (Integer[] singleNeighbour: neighbours) {
                if (singleNeighbour[0] != null) {
                    String nextChar = board.getLetter(singleNeighbour[0], singleNeighbour[1]);
//                    System.out.println(nextChar + " = " + xLastLetter + ", " + yLastLetter);

                    //recursive call
                    backtrackFunction(startCombination + nextChar, singleNeighbour[0], singleNeighbour[1]);
                }
            }
        }
    }


    private Word checkInWordlist(String var){
        Word word = Word.NO_WORD;

        try(BufferedReader br = new BufferedReader(new FileReader("src/WoordenLijst.txt"))){
            String line;
            while ((line = br.readLine())!=null){
                if (line.matches("^"+var+".*")){
                    word = Word.WORD_START;
                }
                if(line.matches(var)) {
                    word = Word.WORD_COMPLETE;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
//        String[] returnArray = {startBoolean, word};
        return word;
    }

    public void total(){
        String[][] boardArray = board.boardArray;

        for (int i = 0; i < boardArray.length; i++){
            for (int j = 0; j < boardArray.length; j++){
                alreadyBeenHere.clear();
                backtrackFunction(boardArray[i][j], i, j);
            }
        }

         hitsSet = new LinkedHashSet<>(hits);
    }

    public Set<String> getHits(){
        return hitsSet;
    }
}
