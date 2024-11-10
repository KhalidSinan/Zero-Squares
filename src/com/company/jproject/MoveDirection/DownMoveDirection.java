package com.company.jproject.MoveDirection;

import com.company.jproject.Utils.Location;
import com.company.jproject.Utils.SortVertical;
import com.company.jproject.Square.PlayableSquare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DownMoveDirection implements MoveDirection {
    @Override
    public Location getNeighbourLocation(Location location) {
        return new Location(location.getX() + 1, location.getY());
    }

    @Override
    public void sortDirection(ArrayList<PlayableSquare> players) {
        Comparator<PlayableSquare> reverseSortVertical = Collections.reverseOrder(new SortVertical());
        players.sort(reverseSortVertical);
    }
}
