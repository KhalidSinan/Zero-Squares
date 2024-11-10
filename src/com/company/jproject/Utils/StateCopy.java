package com.company.jproject.Utils;

import com.company.jproject.Square.PlayableSquare;
import com.company.jproject.Square.Square;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StateCopy {

    public static Square[][] copyBoard(Square[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        Square[][] copyBoard = new Square[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                copyBoard[i][j] = Square.getSquareByChar(board[i][j].getName());
            }
        }
        return copyBoard;
    }

    public static ArrayList<PlayableSquare> copyPlayers(ArrayList<PlayableSquare> players){
        ArrayList<PlayableSquare> copyPlayers = new ArrayList<>();
        for (PlayableSquare player: players) {
            copyPlayers.add(new PlayableSquare(player));
        }
        return copyPlayers;
    }

    public static Map<Character, Location> copyGoal(Map<Character, Location> goals){
        Map<Character, Location> copyGoals = new HashMap<>();
        for (Map.Entry<Character, Location> goal : goals.entrySet()) {
            copyGoals.put(goal.getKey(), new Location(goal.getValue()));
        }
        return copyGoals;
    }
}
