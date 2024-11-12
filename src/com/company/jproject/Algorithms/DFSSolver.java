package com.company.jproject.Algorithms;

import com.company.jproject.Game.State;

import java.util.*;

public class DFSSolver implements Solver{

    @Override
    public Solution solve(State initialState) {
        Stack<Node> stack = new Stack<>();
        ArrayList<State> visited = new ArrayList<>();
        stack.add(new Node(initialState));
        while(!stack.isEmpty()){
            Node currNode = stack.pop();
            if(visited.contains(currNode.getState())) continue;
            visited.add(currNode.getState());
            if(currNode.isFinal()){
                stack.clear();
                ArrayList<Node> path = SolutionPath.getSolutionPath(currNode);
                return new Solution(path, visited);
            }
            for (State nextState: currNode.getState().nextStates()) {
                if(!visited.contains(nextState)){
                    stack.add(new Node(nextState, currNode));
                }
            }
        }
        return null;
    }

}
