package com.company.jproject.Square;

import com.company.jproject.ConsoleColors;
import com.company.jproject.Utils.Location;
import com.company.jproject.Game.State;

public class GoalSquare extends Square {

    public GoalSquare(char goalName) {
        super(goalName);
    }

    @Override
    public Square copy() {
        return new GoalSquare(getName());
    }

    @Override
    public Square whenPlayerCollideWith(PlayableSquare player, State state) {
        player.setStandOnSquare(this);
        Location goalLoc = state.getGoals().get(player.getGoal());
        if(ifMatchedGoal(player.getLocation(), goalLoc)){
            player.setHasReachGoal(true);
            state.getGoals().remove(player.getGoal());
            state.getPlayers().remove(player);
            return new EmptySquare();
        }
        return player;
    }


    public boolean ifMatchedGoal(Location playerLoc, Location goalLoc){
        return Location.hasMatchedLocation(playerLoc, goalLoc);
    }

    @Override
    public String toString() {
        return ConsoleColors.getGoalConsoleColor(getName());
    }
}
