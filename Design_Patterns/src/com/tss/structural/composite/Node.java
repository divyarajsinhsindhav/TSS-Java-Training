package com.tss.structural.composite;

import java.util.List;

public interface Node {
    default void add(Node node){
        throw new UnsupportedOperationException("You can not add node to leaf node");
    };
    default void remove(Node node) {
        throw new UnsupportedOperationException("You can not remove node from leaf node");
    };
    default List<Node> getChildren() {
        throw new UnsupportedOperationException("You can not get children from leaf node");
    };
    void render(String indent);
}
