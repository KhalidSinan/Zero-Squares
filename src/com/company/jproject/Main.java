package com.company.jproject;
import com.company.jproject.Algorithms.BFSSolver;
import com.company.jproject.Algorithms.DFSSolver;
import com.company.jproject.Algorithms.Node;
import com.company.jproject.Algorithms.Solution;
import com.company.jproject.Game.Game;
import com.company.jproject.Game.Level;
import com.company.jproject.Game.State;
import com.company.jproject.MoveDirection.LeftMoveDirection;
import com.company.jproject.MoveDirection.RightMoveDirection;
import com.company.jproject.Utils.LevelConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main{
    public static void main(String[] args) {
        Game game = new Game(10,10);
        ArrayList<Solution> DFSSolutions = game.solve(new DFSSolver());
        ArrayList<Solution> BFSSolutions = game.solve(new BFSSolver());
        for (Solution solution: DFSSolutions) {
            System.out.println(solution);
        }
        System.out.println("======== BFS =========");
        for (Solution solution: BFSSolutions) {
            System.out.println(solution);
        }
//        Level level = new Level(5);
//        State state1 = new State(LevelConverter.convertLevelToSquareBoard(level.getLevel()));
//        ArrayList<State> visited = new ArrayList<>();
//        visited.add(state1);
//        State nextState1 = state1.move(new LeftMoveDirection());
//        State nextState2 = nextState1.move(new RightMoveDirection());
//        System.out.println(visited);
//        System.out.println(nextState2.equals(state1));
//        System.out.println(visited.contains(nextState2));
    }
}