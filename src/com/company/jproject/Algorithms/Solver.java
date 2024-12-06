package com.company.jproject.Algorithms;

import com.company.jproject.Game.Level;
import com.company.jproject.Game.State;
import com.company.jproject.Square.Square;
import com.company.jproject.Utils.LevelConverter;

public abstract class Solver {

    private final String name;

    public Solver(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected State getInitialStateFromLevel(Level level){
        Square[][] levelBoard = LevelConverter.convertLevelToSquareBoard(level.getLevel());
        return new State(levelBoard);
    }

    protected abstract Solution solve(Level level);

    public Solution startSolving(Level level){
        long startTime = System.nanoTime();
        long initialMemoryUsage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        Solution solution = solve(level);
        solution.setTime((System.nanoTime() - startTime) / 1_000_000);
        long finalMemoryUsage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long memoryUsage = Math.abs(finalMemoryUsage - initialMemoryUsage) / 1000;
        solution.setMemory(memoryUsage);
        return solution;
    }
}
