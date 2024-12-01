package com.company.jproject.Algorithms;

import com.company.jproject.Game.Level;
import com.company.jproject.Game.State;

public class HillClimbingSolver extends HeuristicSolver{

    public HillClimbingSolver() {
        super("Hill Climbing");
    }

    @Override
    public Solution solve(Level level) {
        State initialState = getInitialStateFromLevel(level);
        return null;
    }

}
