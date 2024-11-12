package com.company.jproject.Algorithms;

import com.company.jproject.Game.State;

public class Node {
    private final State state;
    private Node parent;

    public Node(State state){
        this.state = state;
        this.parent = null;
    }

    public Node(State state, Node parent){
        this.state = state;
        this.parent = parent;
    }

    public boolean isRoot() {
        return parent == null;
    }

    public boolean isFinal() {
        return state.isFinalState();
    }

    public State getState() {
        return state;
    }

    public Node getParent() {
        return parent;
    }
}
