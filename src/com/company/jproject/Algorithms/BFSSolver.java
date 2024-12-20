package com.company.jproject.Algorithms;

import com.company.jproject.Game.Level;
import com.company.jproject.Game.State;
import com.company.jproject.Utils.SolutionPath;

import java.util.*;

public class BFSSolver extends Solver{

    public BFSSolver() {
        super("BFS");
    }

    @Override
    public Solution solve(Level level) {
        State initialState = getInitialStateFromLevel(level);
        Queue<Node> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();
        queue.add(new Node(initialState));
        visited.add(initialState);
        while(!queue.isEmpty()){
            Node currNode = queue.poll();
//            if(visited.contains(currNode.getState())) continue;
            if(currNode.isFinal()){
                queue.clear();
                ArrayList<Node> path = SolutionPath.getSolutionPath(currNode);
                return new Solution(level.getLevelNum(), path, visited);
            }
            for (State nextState: currNode.getState().nextStates()) {
                if(!visited.contains(nextState)){
                    queue.add(new Node(nextState, currNode));
                    visited.add(currNode.getState());
                }
            }
        }
        return null;
    }


}
