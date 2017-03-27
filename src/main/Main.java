package main;

import model.Board;
import model.GetSolutions;

import java.util.ArrayList;
import java.util.List;

public class Main {

    //Het enige dat niet werkt is het overslaan van letter die al zijn geweest.

    public static void main(String[] args) {
        List<String> alreadyBeenHere = new ArrayList<>();

        Board board = new Board(alreadyBeenHere);
        board.printBoard();
        System.out.println("\n" + "---- Solutions ----");


        GetSolutions getSolutions = new GetSolutions(alreadyBeenHere, board);
        getSolutions.total();


        System.out.println(getSolutions.getHits());
    }
}