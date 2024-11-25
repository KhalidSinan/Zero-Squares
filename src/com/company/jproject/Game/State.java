package com.company.jproject.Game;

import com.company.jproject.MoveDirection.*;
import com.company.jproject.Square.EmptyGoalSquare;
import com.company.jproject.Square.GoalSquare;
import com.company.jproject.Square.PlayableSquare;
import com.company.jproject.Square.Square;
import com.company.jproject.Utils.Location;
import com.company.jproject.Utils.StateCopy;

import java.util.*;
import java.util.List;

public class State {

    private Square[][] board;
    private ArrayList<PlayableSquare> players;
    private Map<Character, Location> goals;
    private boolean isFinalState;
    private MoveDirection previousMove;

    public State(Square[][] board) {
        this.board = board;
        this.players = getAllPlayers();
        this.goals = getAllGoals();
        this.isFinalState = false;
        this.previousMove = null;
    }

    public State(Square[][] board, ArrayList<PlayableSquare> players, Map<Character, Location> goals){
        this.board = board;
        this.players = players;
        this.goals = goals;
        this.isFinalState = isFinalState();
    }

    public State(State state){
       this(
               StateCopy.copyBoard(state.board),
               StateCopy.copyPlayers(state.players),
               StateCopy.copyGoal(state.goals)
       );
    }

    public ArrayList<State> nextStates(){
        ArrayList<State> nextStates = new ArrayList<>();
        List<MoveDirection> moveDirections = List.of(
                new UpMoveDirection(), new RightMoveDirection(),
                new LeftMoveDirection() , new DownMoveDirection()
        );
        for (MoveDirection direction: moveDirections) {
            State newState = this.move(direction);
            if(!newState.equals(this))
                nextStates.add(newState);
        }
        return nextStates;
    }

    public State move(MoveDirection direction) {
        State newState = new State(this);
        newState.setPreviousMove(direction);
        Queue<PlayableSquare> playersToMove = newState.getInOrderMovablePlayers(direction);
        while(!playersToMove.isEmpty()) {
            PlayableSquare player = playersToMove.poll();
            newState.moveOnePlayer(direction, player);
        }
        return newState;
    }

    private void moveOnePlayer(MoveDirection direction, PlayableSquare player){
        Location playerLoc = player.getLocation();
        while (!player.hasReachGoal() && checkPlayerMove(direction, player)) {
            board[playerLoc.getX()][playerLoc.getY()] = player.getStandOnSquare();
            player.move(direction);
            Square movedSquare = board[playerLoc.getX()][playerLoc.getY()];
            board[playerLoc.getX()][playerLoc.getY()] = movedSquare.whenPlayerCollideWith(player, this);
        }
    }

    private Queue<PlayableSquare> getInOrderMovablePlayers(MoveDirection direction){
        ArrayList<PlayableSquare> movablePlayers = getMovablePlayers(direction);
        direction.sortDirection(movablePlayers);
        return new LinkedList<>(movablePlayers);
    }

    public ArrayList<PlayableSquare> getMovablePlayers(MoveDirection direction) {
        ArrayList<PlayableSquare> movablePlayers = new ArrayList<>();
        Map<PlayableSquare, Boolean> checkAllPlayerMove = checkAllPlayersMove(direction);
        for (Map.Entry<PlayableSquare, Boolean> check : checkAllPlayerMove.entrySet()) {
            if(check.getValue()){
                movablePlayers.add(check.getKey());
            }
        }
        return movablePlayers;
    }

    public Map<PlayableSquare, Boolean> checkAllPlayersMove(MoveDirection direction){
        Map<PlayableSquare, Boolean> checkAllPlayersMove = new HashMap<>();
        for (PlayableSquare player: players) {
            checkAllPlayersMove.put(player, checkPlayerMove(direction, player));
        }
        return checkAllPlayersMove;
    }

    public boolean checkPlayerMove(MoveDirection direction, PlayableSquare player) {
        Location neighLocation = direction.getNeighbourLocation(player.getLocation());
        if(!inBoardLocation(neighLocation)) return false;
        Square neighSquare = board[neighLocation.getX()][neighLocation.getY()];
        return player.canMoveTo(neighSquare);
    }

    public boolean inBoardLocation(Location location){
        return location.getX() >= 0 && location.getX() < board.length &&
                location.getY() >= 0 && location.getY() < board[0].length;
    }

    public ArrayList<PlayableSquare> getAllPlayers() {
        ArrayList<PlayableSquare> players = new ArrayList<>();
        for (int i = 0 ; i<board.length ; i++) {
            for (int j = 0; j<board[i].length ; j++) {
                if(board[i][j] instanceof PlayableSquare){
                    ((PlayableSquare) board[i][j]).setLocation(new Location(i, j));
                    players.add((PlayableSquare) board[i][j]);
                }
            }
        }
        return players;
    }

    public Map<Character, Location> getAllGoals() {
        Map<Character, Location> goals = new HashMap<>();
        for (int i = 0 ; i<board.length ; i++) {
            for (int j = 0; j<board[i].length ; j++) {
                if(board[i][j] instanceof GoalSquare || board[i][j] instanceof EmptyGoalSquare){
                    goals.put(board[i][j].getName(), new Location(i ,j));
                }
            }
        }
        return goals;
    }

    public Map<Character, Location> getGoals() {
        return goals;
    }

    public void setGoals(Map<Character, Location> goals) {
        this.goals = goals;
    }

    public ArrayList<PlayableSquare> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<PlayableSquare> players) {
        this.players = players;
    }

    public Square[][] getBoard() {
        return board;
    }

    public void setBoard(Square[][] board) {
        this.board = board;
    }

    public MoveDirection getPreviousMove() {
        return previousMove;
    }

    public void setPreviousMove(MoveDirection previousMove) {
        this.previousMove = previousMove;
    }

    public boolean isFinalState() {
        return goals.isEmpty();
    }

    public void setFinalState(boolean finalState) {
        isFinalState = finalState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State state)) return false;
        return isFinalState == state.isFinalState && Arrays.deepEquals(board, state.board) && players.equals(state.players) && goals.equals(state.goals);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Square[] squares : board) {
            for (Square square : squares) {
                result.append(square.toString());
            }
            result.append('\n');
        }
        return result.toString();
    }
}
