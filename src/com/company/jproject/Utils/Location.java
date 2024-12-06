package com.company.jproject.Utils;

import java.util.Objects;

public class Location {
    private int x;
    private int y;

    public Location() {
        this.x = 0;
        this.y = 0;
    }

    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Location(Location location){
        this(location.getX(), location.getY());
    }

    public static boolean hasMatchedLocation(Location firstLoc, Location secondLoc) {
        if(firstLoc == null || secondLoc == null) return false;
        return firstLoc.x == secondLoc.x && firstLoc.y == secondLoc.y;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location)) return false;
        return x == location.x && y == location.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
