package com.company.jproject.Square;

import com.company.jproject.ConsoleColors;
import com.company.jproject.Game.State;

public class VoidSquare extends Square {

    public VoidSquare() {
        super('.');
    }

    @Override
    public Square copy() {
        return new VoidSquare();
    }

    @Override
    public Square whenPlayerCollideWith(PlayableSquare player, State state) {
        player.setStandOnSquare(this);
        state.getPlayers().remove(player);
        return this;
    }

    @Override
    public String toString() {
        return "   ";
    }
}
