package main;

import model.Board;
import model.GetSolutions;


public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.printBoard();
        System.out.println("\n" + "---- Solutions ----");
//        String firstChar = board.getLetter(0, 0);

        GetSolutions getSolutions = new GetSolutions(board);
        getSolutions.total();


        System.out.println(getSolutions.getHits());
    }
}