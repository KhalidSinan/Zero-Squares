package com.company.jproject.Utils;

import com.company.jproject.Square.PlayableSquare;

import java.util.Comparator;

public class SortHorizontal implements Comparator<PlayableSquare> {

    public SortHorizontal() {}

    @Override
    public int compare(PlayableSquare square1, PlayableSquare square2) {
        return square1.getLocation().getY() - square2.getLocation().getY();
    }

    @Override
    public Comparator<PlayableSquare> reversed() {
        return Comparator.super.reversed();
    }
}
