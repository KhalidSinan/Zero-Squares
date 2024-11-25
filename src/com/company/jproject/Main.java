package com.company.jproject;
import com.company.jproject.Algorithms.*;
import com.company.jproject.Game.Game;
import com.company.jproject.Game.State;
import com.company.jproject.MoveDirection.MoveDirection;
import com.company.jproject.MoveDirection.UpMoveDirection;
import com.company.jproject.Utils.SolverSolutions;
import com.company.jproject.Utils.SolversComparator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main{

    public static void main(String[] args) {
        Game game = new Game(7, 10);
        SolverSolutions RDFSSolutions = game.solve(new RDFSSolver());
        SolverSolutions UCSSolutions = game.solve(new UCSSolver());
        SolverSolutions BFSSolutions = game.solve(new BFSSolver());
        SolversComparator comparator = new SolversComparator(UCSSolutions, BFSSolutions, RDFSSolutions);
        comparator.compareByPathLength();
//        Level level4 = new Level(4);
//        Square[][] board = LevelConverter.convertLevelToSquareBoard(level4.getLevel());
//        dfsRecSolver(new State(board));
//        for (Node node: path) {
//            System.out.println(node.getState());
//        }
//        SolverSolutions DFSSolutions = game.solve(new DFSSolver());
//        SolverSolutions BFSSolutions = game.solve(new BFSSolver());
//        SolversComparator comparator = new SolversComparator(DFSSolutions, BFSSolutions);
//        comparator.compareByPathLength();
//        System.out.println("===========");
//        comparator.compareByVisitedNodesNumber();

    }
}