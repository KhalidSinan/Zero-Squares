package com.company.jproject.MoveDirection;

import com.company.jproject.Utils.Location;
import com.company.jproject.Utils.SortHorizontal;
import com.company.jproject.Square.PlayableSquare;

import java.util.ArrayList;

public class LeftMoveDirection implements MoveDirection {
    @Override
    public Location getNeighbourLocation(Location location) {
        return new Location(location.getX(), location.getY() - 1) ;
    }

    @Override
    public void sortDirection(ArrayList<PlayableSquare> players) {
        players.sort(new SortHorizontal());
    }
}
