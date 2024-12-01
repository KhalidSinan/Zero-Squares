package com.company.jproject.Square;

import com.company.jproject.ConsoleColors;
import com.company.jproject.Utils.Location;
import com.company.jproject.MoveDirection.MoveDirection;
import com.company.jproject.Game.State;

import java.awt.*;
import java.util.Objects;

public class PlayableSquare extends Square{

    private Location location;
    private Square standOnSquare;
    private boolean hasReachGoal;

    public PlayableSquare(char player){
        super(player);
        this.standOnSquare = new EmptySquare();
        this.hasReachGoal = false;
    }

    public PlayableSquare(char player, Square standOnSquare, Location location, boolean hasReachGoal){
        super(player);
        this.location = new Location(location);
        this.standOnSquare = standOnSquare;
        this.hasReachGoal = hasReachGoal;
    }

    public PlayableSquare(PlayableSquare player){
        this(player.getName(), player.getStandOnSquare().copy(), player.location, player.hasReachGoal());
    }

    @Override
    public Square copy() {
        return new PlayableSquare(this);
    }

    public void move(MoveDirection direction) {
        Location newLocation = direction.getNeighbourLocation(this.getLocation());
        this.location.setX(newLocation.getX());
        this.location.setY(newLocation.getY());
    }

    @Override
    public Square whenPlayerCollideWith(PlayableSquare player, State state) {
        return null;
    }

    public Square getStandOnSquare(){
        return standOnSquare;
    }

    public void setStandOnSquare(Square standOnSquare){
        this.standOnSquare = standOnSquare;
    }

    public boolean canMoveTo(Square nextSquare){
        return !(nextSquare instanceof WallSquare || nextSquare instanceof PlayableSquare);
    }

    public char getGoal(){
        return Character.toUpperCase(this.getName());
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean hasReachGoal() {
        return hasReachGoal;
    }

    public void setHasReachGoal(boolean hasReachGoal) {
        this.hasReachGoal = hasReachGoal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayableSquare that)) return false;
        if (!super.equals(o)) return false;
        return hasReachGoal == that.hasReachGoal && Objects.equals(location, that.location) && Objects.equals(standOnSquare, that.standOnSquare);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), location, standOnSquare, hasReachGoal);
    }

    @Override
    public String toString() {
        return ConsoleColors.getPlayerConsoleColor(getName());
    }

}
