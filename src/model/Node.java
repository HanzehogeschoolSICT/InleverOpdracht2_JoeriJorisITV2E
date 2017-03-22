package model;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String value;
    private final List<Node> children = new ArrayList<>();
    private final Node parent;

    public Node(Node parent) {
        this.parent = parent;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Node> getChildren() {
        return children;
    }

    public Node getParent() {
        return parent;
    }

}