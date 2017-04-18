package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class GetSolutions {
    static List alreadyBeenHere;
    ArrayList<String> hits = new ArrayList<>();
    Set<String> hitsSet;
    Board board;

    public GetSolutions(List alreadyBeenHere, Board mainBoard){
        this.alreadyBeenHere = alreadyBeenHere;
        this.board = mainBoard;
    }

    public void backtrackFunction(String startCombination, int xLastLetter, int yLastLetter) {
        alreadyBeenHere.add(board.getLetter(xLastLetter, yLastLetter));
        Word result = checkInWordlist(startCombination);
        if (result == Word.WORD_COMPLETE) {
            hits.add(startCombination);
            searchFurther(startCombination, xLastLetter, yLastLetter);
        }
        if (result == Word.WORD_START) {
            searchFurther(startCombination, xLastLetter, yLastLetter);
        }
    }

    private void searchFurther(String startCombination, int xLastLetter, int yLastLetter){
        Integer[][] neighbours = board.getNeighbours(xLastLetter, yLastLetter);
        for (Integer[] singleNeighbour: neighbours) {
            if (singleNeighbour[0] != null) {
                String nextChar = board.getLetter(singleNeighbour[0], singleNeighbour[1]);
                if(!alreadyBeenHere.contains(nextChar)){
                    backtrackFunction(startCombination + nextChar, singleNeighbour[0], singleNeighbour[1]);
                }
//                    System.out.println(nextChar + " = " + xLastLetter + ", " + yLastLetter);

                //recursive call
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
//        System.out.println(word);
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
