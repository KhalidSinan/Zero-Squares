package com.company.jproject.Square;

import com.company.jproject.ConsoleColors;
import com.company.jproject.Game.State;

public class FragileWallSquare extends Square {
    public FragileWallSquare() {
        super('@');
    }

    @Override
    public Square copy() {
        return new FragileWallSquare();
    }

    @Override
    public Square whenPlayerCollideWith(PlayableSquare player, State state) {
            player.setStandOnSquare(new EmptySquare());
            return player;
    }

    @Override
    public String toString() {
        return ConsoleColors.BLACK_BACKGROUND +" "+getName()+" "+ ConsoleColors.RESET;
    }
}
