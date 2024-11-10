package com.company.jproject.Square;

import com.company.jproject.ConsoleColors;
import com.company.jproject.Game.State;

public class EmptyGoalSquare extends Square {

    public EmptyGoalSquare() {
        super('W');
    }

    @Override
    public Square copy() {
        return new EmptyGoalSquare();
    }

    @Override
    public Square whenPlayerCollideWith(PlayableSquare player, State state) {
            GoalSquare newGoal = new GoalSquare(player.getGoal());
            player.setStandOnSquare(newGoal);
            state.getGoals().remove(this.getName());
            state.getGoals().put(newGoal.getName(), player.getLocation());
            return player;
    }

    @Override
    public String toString() {
        return ConsoleColors.BLACK_BACKGROUND_BRIGHT + "   " + ConsoleColors.RESET;
    }


}
