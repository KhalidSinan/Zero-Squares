package com.company.jproject.Algorithms;

import com.company.jproject.Game.Level;
import com.company.jproject.Game.State;
import com.company.jproject.Utils.SolutionPath;

import java.sql.Array;
import java.util.ArrayList;

public class RDFSSolver extends Solver{

    public RDFSSolver() {
        super("Recursion DFS");
    }

    @Override
    public Solution solve(Level level) {
        State initialState = getInitialStateFromLevel(level);
        Node initialNode = new Node(initialState);
        ArrayList<State> visited = new ArrayList<>();
        Node goalNode = solveHelper(initialNode, visited);
        ArrayList<Node> path = SolutionPath.getSolutionPath(goalNode);
        return new Solution(level.getLevelNum(), path, visited);
    }

    private Node solveHelper(Node node, ArrayList<State> visited){
        if(node.getState().isFinalState()){
            return node;
        }
        if(visited.contains(node.getState())) return null;
        visited.add(node.getState());
        for (State nextState : node.getState().nextStates()) {
            Node nextNode = solveHelper(new Node(nextState, node),visited);
            if(nextNode != null){
                return nextNode;
            }
        }
        return null;
    }
}
