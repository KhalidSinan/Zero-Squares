package com.company.jproject.Square;

import com.company.jproject.ConsoleColors;
import com.company.jproject.Game.State;

public class WallSquare extends Square {

    public WallSquare() {
        super('0');
    }

    @Override
    public Square copy() {
        return new WallSquare();
    }

    @Override
    public Square whenPlayerCollideWith(PlayableSquare player, State state) {
            return null;
    }

    @Override
    public String toString() {
        return ConsoleColors.BLACK_BACKGROUND + "   " + ConsoleColors.RESET;
    }
}
