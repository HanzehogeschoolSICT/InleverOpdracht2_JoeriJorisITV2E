package main;

import model.Board;
import model.GetSolutions;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<String> alreadyBeenHere = new ArrayList<>();

        Board board = new Board(alreadyBeenHere);
        board.printBoard();
        System.out.println("\n" + "---- Solutions ----");
//        String firstChar = board.getLetter(0, 0);
        //comment hier

        GetSolutions getSolutions = new GetSolutions(alreadyBeenHere, board);
        getSolutions.total();


        System.out.println(getSolutions.getHits());
    }
}