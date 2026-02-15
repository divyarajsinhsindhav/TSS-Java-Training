package com.tss.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class ElementNode implements Node {
    private String tagName;
    private List<Node> children = new ArrayList<>();

    public ElementNode(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public void add(Node node) {
        children.add(node);
    }

    @Override
    public void remove(Node node) {
        children.remove(node);
    }

    public List<Node> getChildren() {
        return children;
    }

    @Override
    public void render(String indent) {
        System.out.println(indent + "<" + tagName + ">");
        for (Node child : children) {
            child.render(indent + "  ");
        }
        System.out.println(indent + "</" + tagName + ">");
    }
}
