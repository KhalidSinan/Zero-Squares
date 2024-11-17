package com.company.jproject;
import com.company.jproject.Algorithms.*;
import com.company.jproject.Game.Game;
import com.company.jproject.Game.Level;
import com.company.jproject.Utils.TablePrinter;

public class Main{
    public static void main(String[] args) {

        Game game = new Game(1,10);
        SolverSolutions DFSSolutions = game.solve(new DFSSolver());
        SolverSolutions BFSSolutions = game.solve(new BFSSolver());
        SolversComparator comparator = new SolversComparator(DFSSolutions, BFSSolutions);
        comparator.compareByVisitedNodesNumber();
//        for (Solution solution: DFSSolutions.getSolutions()) {
//            System.out.println("==============");
//            System.out.println(solution.getPathLength());
//            System.out.println(solution.getVisitedLength());
//        }
//        System.out.println("======== BFS =========");
//        for (Solution solution: BFSSolutions.getSolutions()) {
//            System.out.println("==============");
//            System.out.println(solution.getPathLength());
//            System.out.println(solution.getVisitedLength());
//        }
//        Level level = new Level(5);
//        System.out.println(level);
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