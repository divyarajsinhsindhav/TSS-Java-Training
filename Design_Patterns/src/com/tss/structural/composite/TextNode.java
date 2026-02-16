package com.tss.structural.composite;

// Leaf Node
public class TextNode implements Node {
    private String text;

    public TextNode(String text) {
        this.text = text;
    }

    @Override
    public void render(String indent) {
        System.out.println(indent + text);
    }
}
