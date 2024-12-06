package com.company.jproject.Algorithms;

import com.company.jproject.Game.Level;
import com.company.jproject.Game.State;
import com.company.jproject.Utils.SolutionPath;

import java.util.ArrayList;

public class SimpleHillClimbingSolver extends HeuristicSolver {

    public SimpleHillClimbingSolver() {
        super("Simple Hill Climbing");
    }

    @Override
    public Solution solve(Level level) {
        State initialState = getInitialStateFromLevel(level);
        Node currentNode = new Node(initialState);
        while(true){
            int currentHeuristic = heuristic(currentNode.getState());
            Node nextNode = currentNode;
            for (State nextState : currentNode.getState().nextStates()) {
                int nextHeuristic = heuristic(nextState);
                if(nextHeuristic < currentHeuristic){
                   nextNode = new Node(nextState, currentNode);
                   break;
                }
            }
            if(nextNode == currentNode) break;
            currentNode = nextNode;
        }
        ArrayList<Node> path = SolutionPath.getSolutionPath(currentNode);
        return new Solution(level.getLevelNum(), path);
    }
}
