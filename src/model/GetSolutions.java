package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class GetSolutions {
    ArrayList<String> hits = new ArrayList<>();
    Board board;

    public GetSolutions(Board mainBoard){
        this.board = mainBoard;
    }

    public void backtrackFunction(String startCombination, int x, int y) {
        String[] result = checkInWordlist(startCombination);
        //result: ["true", "woord"]

//        for (String[] item1 : board.boardArray) {
//            for (String item : item1) {
                while (result[0] == "true") {
                    Integer[][] neighbours = board.getNeighbours(x, y);

                    if (result[1] != "") {
                        hits.add(result[1]);
                    }

                    for (Integer[] items : neighbours) {
                        if (items[0] != null) {
                            backtrackFunction(startCombination + board.getLetter(items[0], items[1]), items[0], items[1]);
                        }
                    }
                }
                if (result[0] == "false") {
                    System.out.println("Geen hits voor deze combi: " + startCombination);
                }

            System.out.println(hits);
        }


    private String[] checkInWordlist(String var){
        String startBoolean = "false";
        String word = "";
        try(BufferedReader br = new BufferedReader(new FileReader("src/WoordenLijst.txt"))){
            String line;
            while ((line = br.readLine())!=null){
                if (line.matches("^"+var+".*")){
                    startBoolean = "true";
                    System.out.println("half hit: "+line);
                }
                if(line.matches(var)) {
                    word = var;
                    System.out.println("full hit: "+line);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        String[] returnArray = {startBoolean, word};
        return returnArray;
    }

}