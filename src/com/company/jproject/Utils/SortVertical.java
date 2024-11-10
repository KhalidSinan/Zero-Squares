package com.company.jproject.Utils;

import com.company.jproject.Square.PlayableSquare;

import java.util.Comparator;

public class SortVertical implements Comparator<PlayableSquare> {

    public SortVertical(){}

    @Override
    public int compare(PlayableSquare square1, PlayableSquare square2) {
        return square1.getLocation().getX() - square2.getLocation().getX();
    }

    @Override
    public Comparator<PlayableSquare> reversed() {
        return Comparator.super.reversed();
    }
}
