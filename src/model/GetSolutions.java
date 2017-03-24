package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class GetSolutions {
    ArrayList<String> hits = new ArrayList<>();
    Set<String> hitsSet;
    Board board;

    public GetSolutions(Board mainBoard){
        this.board = mainBoard;
    }

//    public void backtrackFunction(String startCombination, int x, int y) {

    public void backtrackFunction(String startCombination, int xLastLetter, int yLastLetter) {
        Integer[][] neighbours = board.getNeighbours(xLastLetter, yLastLetter);
        String[] result = checkInWordlist(startCombination);

        for (Integer[] singleNeighbour: neighbours) {
            if (singleNeighbour[0] != null) {
                if (result[0] == "true") {
                    if (result[1] != "") {
                        hits.add(result[1]);
                    }
                    String nextChar = board.getLetter(singleNeighbour[0], singleNeighbour[1]);

                    //recursive call
                    backtrackFunction(startCombination + nextChar, singleNeighbour[0], singleNeighbour[1]);
                } else {
//                    System.out.println("Geen hit voor: " + startCombination);
                }
            }
        }
//
//        //result: ["true", "woord"]
//
//                while (result[0] == "true") {
//                    Integer[][] neighbours = board.getNeighbours(x, y);
//
//                    if (result[1] != "") {
//                        hits.add(result[1]);
//                    }
//
//                    for (Integer[] items : neighbours) {
//                        if (items[0] != null) {
//                            backtrackFunction(startCombination + board.getLetter(items[0], items[1]), items[0], items[1]);
//                        }
//                    }
//                }
//                if (result[0] == "false") {
//                    System.out.println("Geen hits voor deze combi: " + startCombination);
//                }
//
//            System.out.println(hits);
//        }
    }


    private String[] checkInWordlist(String var){
        String startBoolean = "false";
        String word = "";
        //Laat dit in de constructor gebeuren? Nu gebeurt dit elke keer dat functie aangeroepen wordt
        try(BufferedReader br = new BufferedReader(new FileReader("src/WoordenLijst.txt"))){
            String line;
            while ((line = br.readLine())!=null){
                if (line.matches("^"+var+".*")){
                    startBoolean = "true";
//                    System.out.println("half hit: "+line);
                }
                if(line.matches(var)) {
                    word = var;
//                    System.out.println("hit" + line);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        String[] returnArray = {startBoolean, word};
        return returnArray;
    }

    public void total(){
        String[][] boardArray = board.boardArray;

        for (int i = 0; i < boardArray.length; i++){
            for (int j = 0; j < boardArray.length; j++){
                backtrackFunction(boardArray[i][j], i, j);
            }
        }

         hitsSet = new LinkedHashSet<>(hits);

//        for (String[] subArray:boardArray){
//            for (String subSubArray: subArray){
//                backtrackFunction(subSubArray);
//            }
//        }
    }

    public Set<String> getHits(){
        return hitsSet;
    }
}