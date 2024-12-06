package com.company.jproject.Algorithms;

import com.company.jproject.Game.Level;
import com.company.jproject.Game.State;
import com.company.jproject.Utils.SolutionPath;

import java.util.*;

public class DFSSolver extends Solver{

    public DFSSolver() {
        super("DFS");
    }

    @Override
    public Solution solve(Level level) {
        State initialState = getInitialStateFromLevel(level);
        Stack<Node> stack = new Stack<>();
        Set<State> visited = new HashSet<>();
        stack.add(new Node(initialState));
        while(!stack.isEmpty()){
            Node currNode = stack.pop();
            if(visited.contains(currNode.getState())) continue;
            visited.add(currNode.getState());
            if(currNode.isFinal()){
                stack.clear();
                ArrayList<Node> path = SolutionPath.getSolutionPath(currNode);
                return new Solution(level.getLevelNum() ,path, visited);
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
