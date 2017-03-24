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

    public void backtrackFunction(String startCombination) {
        String[] result = checkInWordlist(startCombination);
        //result: ["true", "woord"]

        while (result[0] == "true"){
            Integer[][] neighbours = board.getNeighbours(0,0);
            if (result[1] != "") {
                hits.add(result[1]);
            }

            for (Integer[] item:neighbours) {
                backtrackFunction(startCombination + board.getLetter(item[0] , item[1]));
            }
        }
        if (result[0] == "false"){
            System.out.println("DIT IS EEN TEST");
        }
    }
    //als er geen optie meer is; stop mefgt zoeken
    //voor elke letter combinatie van het bord
    //kijk of er woorden beginnen met die letter
    //if true:
    //geef terug:en of er een hit is van een volledig woord
    //zoek door als er nog geen volledige hit is
    //en dan moet die dat dus ook van het child ding doen met die combinatie


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