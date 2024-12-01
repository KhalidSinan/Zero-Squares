package com.company.jproject;
import com.company.jproject.Algorithms.*;
import com.company.jproject.Game.Game;
import com.company.jproject.Utils.SolverSolutions;
import com.company.jproject.Utils.SolversComparator;

public class Main{

    public static void main(String[] args) {
        Game game = new Game();
        SolverSolutions UCSSolutions = game.solve(new AStarSolver());
        SolverSolutions BFSSolutions = game.solve(new BFSSolver());
        SolversComparator comparator = new SolversComparator(UCSSolutions, BFSSolutions);
        comparator.compareByPathLength();
    }
}