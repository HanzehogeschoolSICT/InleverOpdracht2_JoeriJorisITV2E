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

//    public void backtrackFunction(String startCombination, int x, int y) {

    public void backtrackFunction(String startCombination, int xLastLetter, int yLastLetter) {
        Integer[][] neighbours = board.getNeighbours(xLastLetter, yLastLetter);
//        System.out.println("startcombi: " + startCombination);
//        System.out.println("current: "+xLastLetter+" "+yLastLetter);
//        System.out.println(alreadyBeenHere);

        String[] result = checkInWordlist(startCombination);
            if (result[0].equals("true")) {
                if (!result[1].equals("")) {
                    hits.add(result[1]);
                } else {
//                    System.out.println("geen hit voor "+startCombination);
                }

        for (Integer[] singleNeighbour: neighbours) {
            if (singleNeighbour[0] != null) {
//                System.out.println(alreadyBeenHere);
                        String nextChar = board.getLetter(singleNeighbour[0], singleNeighbour[1]);

                        //recursive call
                        backtrackFunction(startCombination + nextChar, singleNeighbour[0], singleNeighbour[1]);
    //                } else {
    //                    System.out.println("Geen hit voor: " + startCombination);
                }
            }
        }
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
                alreadyBeenHere.clear();
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
