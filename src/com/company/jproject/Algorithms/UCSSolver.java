package com.company.jproject.Algorithms;

import com.company.jproject.Game.Level;
import com.company.jproject.Game.State;
import com.company.jproject.MoveDirection.*;
import com.company.jproject.Square.PlayableSquare;
import com.company.jproject.Utils.Location;
import com.company.jproject.Utils.SolutionPath;

import java.util.*;

public class UCSSolver extends Solver{


    public UCSSolver() {
        super("UCS");
    }

    static Map<Character, Integer> movesCost = new HashMap<>();

    static {
        movesCost.put('u', 1);
        movesCost.put('r', 2);
        movesCost.put('d', 3);
        movesCost.put('l', 4);
    }

    @Override
    public Solution solve(Level level) {
        State initialState = getInitialStateFromLevel(level);
        Queue<Node> queue = new PriorityQueue<>();
        Set<State> visited = new HashSet<>();
        queue.add(new Node(initialState));
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(visited.contains(current.getState())) continue;
            visited.add(current.getState());
            if(current.isFinal()){
                queue.clear();
                ArrayList<Node> path = SolutionPath.getSolutionPath(current);
                return new Solution(level.getLevelNum(), path, visited);
            }
            for (State nextState: current.getState().nextStates()) {
//                int moveCost = getStaticMoveCost(nextState);
                int moveCost = nextState.getTotalMoves();
                Node nextNode = new Node(nextState, current, current.getDepth() + moveCost);
                if(!visited.contains(nextState) || current.getDepth() + moveCost < nextNode.getDepth()){
                    nextNode.setDepth(current.getDepth() + moveCost);
                    queue.add(nextNode);
                }
            }
        }
        return null;
    }

    private int getStaticMoveCost(State state){
        MoveDirection lastMoveDirection = state.getLastMoveDirection();
        char direction = MoveDirection.getCharByMoveDirection(lastMoveDirection);
        return movesCost.get(direction);
    }

}
