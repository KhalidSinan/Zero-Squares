package com.company.jproject.Algorithms;

import com.company.jproject.Game.State;

import java.util.ArrayList;
import java.util.Map;

public class Solution {

    private final ArrayList<Node> path;
    private final ArrayList<State> visited;
    private final int pathLength;
    private final int visitedLength;

    public Solution(ArrayList<Node> path, ArrayList<State> visited){
        this.path = path;
        this.visited = visited;
        this.pathLength = path.size();
        this.visitedLength = visited.size();
    }

    public ArrayList<Node> getPath() {
        return path;
    }

    public ArrayList<State> getVisited() {
        return visited;
    }

    public int getPathLength() {
        return pathLength;
    }

    public int getVisitedLength() {
        return visitedLength;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Node node : path) {
            result.append(node.getState().toString()).append("=========\n");
        }
        result.append("Number of Nodes in Path: ").append(pathLength).append('\n');
        result.append("Number of Visited Nodes: ").append(visitedLength).append('\n');
        return result.toString();
    }
}
