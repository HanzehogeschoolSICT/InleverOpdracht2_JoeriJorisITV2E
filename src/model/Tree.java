package model;

public class Tree {
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

    public static void fillTree(String[][] nestedArray){

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
}