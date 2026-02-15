package com.tss.structural.composite;

import java.util.List;

public interface Node {
    default void add(Node node){
        throw new UnsupportedOperationException();
    };
    default void remove(Node node) {
        throw new UnsupportedOperationException();
    };
    default List<Node> getChildren() {
        throw new UnsupportedOperationException();
    };
    void render(String indent);
}
