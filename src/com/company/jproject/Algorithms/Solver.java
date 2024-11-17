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

    public abstract Solution solve(Level level);
}
