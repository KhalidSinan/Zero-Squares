package com.company.jproject.Algorithms;

import com.company.jproject.Game.Level;
import com.company.jproject.Game.State;
import com.company.jproject.Square.PlayableSquare;
import com.company.jproject.Square.Square;
import com.company.jproject.Utils.Location;

import java.util.*;

public abstract class HeuristicSolver extends Solver{

    public HeuristicSolver(String name) {
        super(name);
    }


    abstract public Solution solve(Level level);

    protected static int heuristic(State state){
        int heuristic = 0;
        ArrayList<PlayableSquare> players = state.getPlayers();
        Map<Character, Location> goals = state.getGoals();
        for (PlayableSquare player : players) {
            Location goalLoc = goals.get(player.getGoal());
            if(goalLoc == null) {
                continue;
            }
            Location playerLoc = player.getLocation();
            heuristic += Math.abs(goalLoc.getY() - playerLoc.getY());
            heuristic += Math.abs(goalLoc.getX() - playerLoc.getX());
        }
        return heuristic;
    }

    protected static int advHeuristic(State state){
        int heuristic = 0;
        ArrayList<PlayableSquare> players = state.getPlayers();
        Map<Character, Location> goals = state.getGoals();
        if(state.isFinalState()) return 0;
        if(players.size() < goals.size()) return heuristic += 1e4;
        for (PlayableSquare player : players) {
            Location goalLoc = goals.get(player.getGoal());
            if(goalLoc == null) {
                goalLoc = goals.get('W');
                if(goalLoc == null) return heuristic += 1e4;
            }
            Location playerLoc = player.getLocation();
            heuristic += Math.abs(goalLoc.getY() - playerLoc.getY());
            heuristic += Math.abs(goalLoc.getX() - playerLoc.getX());
        }
        return heuristic;
    }

    protected static int getTotalCost(Node node){
        return node.getDepth() + advHeuristic(node.getState());
    }
}
