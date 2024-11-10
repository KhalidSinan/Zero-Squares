package com.company.jproject.Square;

import com.company.jproject.ConsoleColors;
import com.company.jproject.Game.State;

public class EmptySquare extends Square {

    public EmptySquare() {
        super('-');
    }

    @Override
    public Square copy() {
        return new EmptySquare();
    }

    @Override
    public Square whenPlayerCollideWith(PlayableSquare player, State state) {
            player.setStandOnSquare(this);
            return player;
    }

    @Override
    public String toString() {
        return ConsoleColors.WHITE_BACKGROUND_BRIGHT + "   " + ConsoleColors.RESET;
    }
}
