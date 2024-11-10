package com.company.jproject.Square;

import com.company.jproject.Game.State;

import java.util.Objects;

public abstract class Square {
    private char name;

    public Square(char name){
        this.name = name;
    }

    public abstract Square copy();
    public abstract Square whenPlayerCollideWith(PlayableSquare player, State state);

    public static Square getSquareByChar(char type){
        if(type == '0') return new WallSquare();
        else if(type == '@') return new FragileWallSquare();
        else if(type == '.') return new VoidSquare();
        else if(type == 'W') return new EmptyGoalSquare();
        else if(Character.isLowerCase(type)) return new PlayableSquare(type);
        else if(Character.isUpperCase(type)) return new GoalSquare(type);
        else return new EmptySquare();
    }

    public char getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square square)) return false;
        return name == square.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public abstract String toString();

    public void setName(char name) {
        this.name = name;
    }
}
