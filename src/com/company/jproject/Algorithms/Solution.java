package com.company.jproject.Algorithms;

import com.company.jproject.Game.State;

import java.util.ArrayList;

public class Solution {

    private final int levelNum;
    private final ArrayList<Node> path;
    private final ArrayList<State> visited;
    private final int pathLength;
    private final int visitedLength;

    public Solution(int levelNum, ArrayList<Node> path, ArrayList<State> visited){
        this.levelNum = levelNum;
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

    public int getLevelNum() {
        return levelNum;
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
