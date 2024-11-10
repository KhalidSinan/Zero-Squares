package com.company.jproject.MoveDirection;

import com.company.jproject.Utils.Location;
import com.company.jproject.Utils.SortVertical;
import com.company.jproject.Square.PlayableSquare;

import java.util.ArrayList;

public class UpMoveDirection implements MoveDirection {
    @Override
    public Location getNeighbourLocation(Location location) {
        return new Location(location.getX() - 1, location.getY());
    }

    @Override
    public void sortDirection(ArrayList<PlayableSquare> players) {
        players.sort(new SortVertical());
    }
}
