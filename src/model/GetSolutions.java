package model;

import java.io.BufferedReader;
import java.io.FileReader;

public class GetSolutions {

    public GetSolutions(){
    }

    private void backtrackFunction(){
        //BASECASE: als er geen optie meer is; stop met zoeken
        //voor elke letter combinatie van het bord
            //kijk of er woorden beginnen met die letter
                //if true:
                    //geef terug:en of er een hit is van een volledig woord
                    //zoek door als er nog geen volledige hit is
                //en dan moet die dat dus ook van het child ding doen met die combinatie

    }

    private void checkInWordlist(String var){
        try(BufferedReader br = new BufferedReader(new FileReader("src/WoordenLijst.txt"))){
            String line;
            while ((line = br.readLine())!=null){
                if (line.matches("^"+var+".*")){
                    System.out.println("half hit: "+line);
                } else if(line.matches(var)) {
                    System.out.println("full hit: "+line);
                }
            }
            //TODO: Er moet nog gecheckt worden op variablen, en niet direct geprint worden; volledige hits pas printen

        } catch (Exception e){
            e.printStackTrace();
        }

    }

}