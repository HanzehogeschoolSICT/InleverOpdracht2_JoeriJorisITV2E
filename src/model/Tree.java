package model;

public class Tree {
    public Node treeRootNode;
    Integer counter = 0;
    public Tree(){
        this.treeRootNode  = new Node(null);
        fillNPrint();
    }
    //hulp van: http://programtalk.com/java/java-tree-implementation/
    public static Node addChild(Node parent, String id) {
        Node node = new Node(parent);
        node.setValue(id);
        parent.getChildren().add(node);
        return node;
    }

    public void printTree(Node node, String appender) {
        System.out.println(appender + node.getValue());
        for (Node each : node.getChildren()) {
            printTree(each, appender + appender);
        }
    }

    public void fillNPrint(){
        treeRootNode.setValue("a");
        // add child to root node
        Node childNode= addChild(treeRootNode, "b");
        // add child to the child node created above
        addChild(childNode, "s");
        addChild(childNode, "w");


        // add child to root node
        Node child2 = addChild(treeRootNode, "c");
        // add child to the child node created above
        addChild(child2, "h");
        addChild(child2, "k");

        Node child3 = addChild(child2, "B");
        addChild(child3, "C");

        Node child4 = addChild(child3, "Q");
        addChild(child4, "O");

        System.out.println("rootNode "+treeRootNode);
//        printTree(treeRootNode, " ");
    }

//    public void createTreeFromBoard(String[][] nestedArray){
//        Node treeRootNode = new Node(null);
//        treeRootNode.setValue(nestedArray[0][0]);
//        Board board = new Board();
//        Integer[][] neighbours = board.getNeighbours(0,0);
//        for (Integer[] item:neighbours){
//            Node child = addChild(treeRootNode, nestedArray[item[0]][item[1]]);
//
//        }
//    }
}