package com.company.jproject;
import com.company.jproject.Algorithms.*;
import com.company.jproject.Game.Game;
import com.company.jproject.Utils.*;

public class Main{


    public static void main(String[] args) {
        Game game = new Game(true, 10, 20, 30);
        SolverSolutions BFS = game.solve(new BFSSolver());
        SolverSolutions DFS = game.solve(new DFSSolver());
        SolverSolutions RDFS = game.solve(new RDFSSolver());
        SolverSolutions UCS = game.solve(new UCSSolver());
        SolverSolutions AStar = game.solve(new AStarSolver());
        SolverSolutions SteepestHillClimbing = game.solve(new SteepestHillClimbingSolver());
        SolverSolutions SimpleHillClimbing = game.solve(new SimpleHillClimbingSolver());
        SolutionsLogGen logger = new SolutionsLogGen();
        logger.logSolverSolutions(AStar);
        SolversComparator comparator = new SolversComparator(BFS, DFS, RDFS, UCS, AStar, SteepestHillClimbing, SimpleHillClimbing);
        comparator.compareByPathLength();
        comparator.compareByVisitedNodesNumber();
        comparator.compareByExecutionTime();
        comparator.compareByMemoryUsage();
    }
}