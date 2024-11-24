package com.company.jproject;
import com.company.jproject.Algorithms.*;
import com.company.jproject.Game.Game;
import com.company.jproject.Game.Level;
import com.company.jproject.Game.State;
import com.company.jproject.Square.Square;
import com.company.jproject.Utils.LevelConverter;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main{

    static ArrayList<State> visited = new ArrayList<>();
    static ArrayList<Node> path = new ArrayList<>();

    public static void dfsRecSolver(State initialState){
        Node initialNode = new Node(initialState);
        dfsRec(initialNode);
    }

    public static Node dfsRec(Node node){
        if(node.getState().isFinalState()){
            path.add(node);
            return node;
        }
        if(visited.contains(node.getState())) return null;
        visited.add(node.getState());
        path.add(node);
        for (State nextState : node.getState().nextStates()) {
           Node nextNode = dfsRec(new Node(nextState, node));
           if(nextNode != null){
               return nextNode;
           }
        }
        path.remove(node);
        return null;
    }
    public static void main(String[] args) {
        Game game = new Game(4,4);
        Level level4 = new Level(4);
        Square[][] board = LevelConverter.convertLevelToSquareBoard(level4.getLevel());
        dfsRecSolver(new State(board));
        for (Node node: path) {
            System.out.println(node.getState());
        }
//        SolverSolutions DFSSolutions = game.solve(new DFSSolver());
//        SolverSolutions BFSSolutions = game.solve(new BFSSolver());
//        SolversComparator comparator = new SolversComparator(DFSSolutions, BFSSolutions);
//        comparator.compareByPathLength();
//        System.out.println("===========");
//        comparator.compareByVisitedNodesNumber();

    }
}