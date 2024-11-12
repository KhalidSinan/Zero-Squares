package com.company.jproject.Algorithms;

import com.company.jproject.Game.State;

import java.util.*;

public class BFSSolver implements Solver{

    @Override
    public Solution solve(State initialState) {
        Queue<Node> queue = new LinkedList<>();
        ArrayList<State> visited = new ArrayList<>();
        queue.add(new Node(initialState));
        while(!queue.isEmpty()){
            Node currNode = queue.poll();
            if(visited.contains(currNode.getState())) continue;
            visited.add(currNode.getState());
            if(currNode.isFinal()){
                queue.clear();
                ArrayList<Node> path = SolutionPath.getSolutionPath(currNode);
                return new Solution(path, visited);
            }
            for (State nextState: currNode.getState().nextStates()) {
                if(!visited.contains(nextState)){
                    queue.add(new Node(nextState, currNode));
                }
            }
        }
        return null;
    }


}
