package com.company.jproject.MoveDirection;

import com.company.jproject.Utils.Location;
import com.company.jproject.Utils.SortHorizontal;
import com.company.jproject.Square.PlayableSquare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RightMoveDirection implements MoveDirection {
    @Override
    public Location getNeighbourLocation(Location location) {
        return new Location(location.getX(), location.getY() + 1);
    }

    @Override
    public void sortDirection(ArrayList<PlayableSquare> players) {
        Comparator<PlayableSquare> reverseSortHorizontal = Collections.reverseOrder(new SortHorizontal());
        players.sort(reverseSortHorizontal);
    }
}
