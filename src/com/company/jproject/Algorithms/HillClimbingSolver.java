package com.company.jproject.Algorithms;

import com.company.jproject.Game.Level;
import com.company.jproject.Game.State;
import com.company.jproject.Utils.SolutionPath;

import java.util.ArrayList;

public class HillClimbingSolver extends HeuristicSolver{

    public HillClimbingSolver() {
        super("Hill Climbing");
    }

    @Override
    public Solution solve(Level level) {
        State initialState = getInitialStateFromLevel(level);
        Node currentNode = new Node(initialState);
        while(true){
            int currentHeuristic = heuristicFunction(currentNode.getState());
            Node nextNode = currentNode;
            int minHeuristic = currentHeuristic;
            for (State nextState : currentNode.getState().nextStates()) {
                int nextHeuristic = heuristicFunction(nextState);
                if(nextHeuristic < minHeuristic){
                    nextNode = new Node(nextState, currentNode);
                    minHeuristic = nextHeuristic;
                }
            }
            if(currentHeuristic == minHeuristic){
                break;
            }
            currentNode = nextNode;
        }
        ArrayList<Node> path = SolutionPath.getSolutionPath(currentNode);
        return new Solution(level.getLevelNum(), path);
    }


}
