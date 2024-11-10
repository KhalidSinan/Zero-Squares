package com.company.jproject.Utils;

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
