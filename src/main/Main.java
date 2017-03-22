package main;

import model.Board;
import model.GetSolutions;

public class Main {
    public static void main(String[] args){
        Board board = new Board();
        GetSolutions getSolutions = new GetSolutions();

        board.printBoard();

        System.out.println("\n---GEVONDEN---");

        getSolutions.readLines("za");
    }


}
