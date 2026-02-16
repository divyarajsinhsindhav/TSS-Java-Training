package com.tss.structural.composite;

public class Main {
    public static void main(String[] args) {

        Node html = new ElementNode("html");
        Node body = new ElementNode("body");
        Node div = new ElementNode("div");
        Node p1 = new ElementNode("p");
        Node p2 = new ElementNode("p");
        Node img = new ElementNode("img");

        Node text1 = new TextNode("Hello Composite Pattern!");
        Node text2 = new TextNode("Inside div");
        try {
            p1.add(text1);
            p1.add(text2);
            p1.remove(text2);
            p2.add(text2);
            div.add(p1);

            div.add(img);

            div.add(p2);

            body.add(div);

            html.add(body);

            html.render("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
