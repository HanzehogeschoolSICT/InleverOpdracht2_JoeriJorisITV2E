package main;

import model.Board;
import model.GetSolutions;


public class Main {
    public static void main(String[] args){
        Board board = new Board();
        board.printBoard();
        GetSolutions getSolutions = new GetSolutions(board);
        getSolutions.backtrackFunction(board.getBoardArray(0,0));



        board.printBoard();
//        Arrays.toString(board.getNeighbours(1,1));
//        Arrays.deepToString(board.getNeighbours(1,1));
//        System.out.println(board.getNeighbours(1,1));
        board.getNeighbours(0,0);

//        System.out.println("\n---GEVONDEN---");

//        getSolutions.readLines("za");
    }


}
