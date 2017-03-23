package model;

public class Tree {
    Integer counter = 0;
    //hulp van: http://programtalk.com/java/java-tree-implementation/
    public static Node addChild(Node parent, String id) {
        Node node = new Node(parent);
        node.setValue(id);
        parent.getChildren().add(node);
        return node;
    }

    public static void printTree(Node node, String appender) {
        System.out.println(appender + node.getValue());
        for (Node each : node.getChildren()) {
            printTree(each, appender + appender);
        }
    }

    public void fillNPrint(){
        Node treeRootNode = new Node(null);
        treeRootNode.setValue("root");
        // add child to root node
        Node childNode= addChild(treeRootNode, "child-1");
        // add child to the child node created above
        addChild(childNode, "child-11");
        addChild(childNode, "child-12");

        // add child to root node
        Node child2 = addChild(treeRootNode, "child-2");
        // add child to the child node created above
        addChild(child2, "child-21");

        printTree(treeRootNode, " ");
    }

    public void createTreeFromBoard(String[][] nestedArray){
        Node treeRootNode = new Node(null);
        treeRootNode.setValue(nestedArray[0][0]);
        Board board = new Board();
        Integer[][] neighbours = board.getNeighbours(0,0);
        for (Integer[] item:neighbours){
            Node child = addChild(treeRootNode, nestedArray[item[0]][item[1]]);

        }
    }
}