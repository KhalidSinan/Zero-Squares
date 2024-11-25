package com.company.jproject.Algorithms;

import com.company.jproject.Game.State;

public class Node implements Comparable<Node> {

    private final State state;
    private final Node parent;
    private int depth;

    public Node(State state){
        this.state = state;
        this.parent = null;
        this.depth = 0;
    }

    public Node(State state, Node parent){
        this.state = state;
        this.parent = parent;
        this.depth = parent.depth + 1;
    }

    public Node(State state, Node parent, int depth){
        this.state = state;
        this.parent = parent;
        this.depth = depth;
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

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) { this.depth = depth; }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.depth, other.depth);
    }
}
