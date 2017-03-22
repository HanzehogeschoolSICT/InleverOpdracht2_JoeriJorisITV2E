package model;

import java.util.ArrayList;
import java.util.List;

public class Node
{
    private List<Node> children = null;
    private String character;

    public Node(String value)
    {
        this.children = new ArrayList<>();
        this.character = value;
    }

    public void addChild(Node child) {
        children.add(child);
    }
}