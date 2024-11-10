package com.company.jproject;
import com.company.jproject.Game.Game;
import com.company.jproject.Game.Level;
import com.company.jproject.Game.State;

import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
//        Level level = new Level(6);
//        State state = new State(level.convertLevelToSquareBoard());
//        ArrayList<State> nextStates = state.nextStates();
//        System.out.println(state);
//        for (State currState: nextStates) {
//            System.out.println(currState);
//            System.out.println("=======");
//        }
//        Queue<State> toVisit = new LinkedList<>();
//        toVisit.add(state);
//        while(!toVisit.isEmpty()){
//            State currState = toVisit.poll();
//            for (State nextState : currState.nextStates()) {
//                if(nextState.isFinalState()){
//                    break;
//                }
//                toVisit.add(nextState);
//            }
//        }
//        game.info();
    }
}