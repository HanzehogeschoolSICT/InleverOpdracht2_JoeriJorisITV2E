package main;

import model.Board;
import model.GetSolutions;
import model.Node;
import model.Tree;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Board board = new Board();
        GetSolutions getSolutions = new GetSolutions();

//        tree.printTree(tree.treeRootNode, " ");

        board.printBoard();
//        Arrays.toString(board.getNeighbours(1,1));
//        Arrays.deepToString(board.getNeighbours(1,1));
//        System.out.println(board.getNeighbours(1,1));
        board.getNeighbours(0,0);

//        System.out.println("\n---GEVONDEN---");

//        getSolutions.readLines("za");
    }


}
