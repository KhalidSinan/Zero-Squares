package com.company.jproject.Algorithms;

import com.company.jproject.Game.State;
import com.company.jproject.Utils.ObjectSizeFetcher;

import java.util.ArrayList;
import java.util.Set;

public class Solution {

    private final int levelNum;
    private final ArrayList<Node> path;
    private final Set<State> visited;
    private final int pathLength;
    private final int visitedLength;
    private long time;
    private long memory;

    public Solution(int levelNum, ArrayList<Node> path){
        this.levelNum = levelNum;
        this.path = path;
        this.pathLength = path.size();
        this.visited = null;
        this.visitedLength = 0;
        this.memory = ObjectSizeFetcher.getObjectSize(this);
    }

    public Solution(int levelNum, ArrayList<Node> path, Set<State> visited){
        this.levelNum = levelNum;
        this.path = path;
        this.visited = visited;
        this.pathLength = path.size();
        this.visitedLength = visited.size();
        this.memory = ObjectSizeFetcher.getObjectSize(this);
    }

    public ArrayList<Node> getPath() {
        return path;
    }

    public Set<State> getVisited() {
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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getMemory() {
        return memory;
    }

    public void setMemory(long memory) {
        this.memory = memory;
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
