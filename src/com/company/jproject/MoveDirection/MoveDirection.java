package com.company.jproject.MoveDirection;

import com.company.jproject.ConsoleColors;
import com.company.jproject.Utils.Location;
import com.company.jproject.Square.PlayableSquare;

import java.util.ArrayList;

public interface MoveDirection {

    Location getNeighbourLocation(Location location);

    void sortDirection(ArrayList<PlayableSquare> players);

    static MoveDirection getMoveDirectionByChar(char direction){
        return switch (direction) {
            case 'd' -> new RightMoveDirection();
            case 's' -> new DownMoveDirection();
            case 'a' -> new LeftMoveDirection();
            default -> new UpMoveDirection();
        };
    }

    static String getMoveDirectionName(char direction) {
        StringBuilder directionName = new StringBuilder();
        directionName.append(ConsoleColors.CYAN);
        directionName.append("======= ");
        switch (direction) {
            case 'w' -> directionName.append("Move UP");
            case 'd' -> directionName.append("Move Right");
            case 's' -> directionName.append("Move Down");
            case 'a' -> directionName.append("Move Left");
            default -> directionName.append(" ");
        };
        directionName.append(" =======");
        directionName.append(ConsoleColors.RESET).append("\n");
        return directionName.toString();
    }

    static char getCharByMoveDirection(MoveDirection direction){
        if(direction instanceof UpMoveDirection) return 'u';
        else if(direction instanceof RightMoveDirection) return 'r';
        else if(direction instanceof DownMoveDirection) return 'd';
        else return 'l';
    }

}
