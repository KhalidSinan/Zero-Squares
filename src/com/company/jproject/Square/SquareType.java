package com.company.jproject.Square;

import com.company.jproject.Game.State;

public enum SquareType {
    Wall('0'), Empty('-'), Player('r'), Goal('R'), EmptyGoal('W'), FragileWall('@'), Void('.');

    public final char defaultName;
    SquareType(char name){
        this.defaultName = name;
    }

    public static SquareType getTypeByChar(char name){
        if(name == SquareType.Wall.defaultName) return SquareType.Wall;
        else if(name == SquareType.EmptyGoal.defaultName) return SquareType.EmptyGoal;
        else if(name == SquareType.FragileWall.defaultName) return SquareType.FragileWall;
        else if(name == SquareType.Void.defaultName) return SquareType.Void;
        else if(Character.isLowerCase(name)) return SquareType.Player;
        else if(Character.isUpperCase(name)) return SquareType.Goal;
        else return SquareType.Empty;
    }

    public void whenPlayerCollide(PlayableSquare player, State state){

    }
}
