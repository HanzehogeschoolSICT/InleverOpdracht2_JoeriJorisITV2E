package model;

import java.io.BufferedReader;
import java.io.FileReader;

public class GetSolutions {

    public GetSolutions(){

    }

    public void readLines(String var){
        try(BufferedReader br = new BufferedReader(new FileReader("src/WoordenLijst.txt"))){
            String line;
            while ((line = br.readLine())!=null){
                if (line.matches("^"+var+".*")){
                System.out.println(line);}
            }
            //TODO: Er moet nog gecheckt worden op variablen, en niet direct geprint worden; volledige hits pas printen

        } catch (Exception e){
            e.printStackTrace();
        }

    }

}