package com.company.jproject.Game;

import com.company.jproject.ConsoleColors;
import com.company.jproject.MoveDirection.MoveDirection;
import com.company.jproject.Square.Square;
import com.company.jproject.Utils.LevelExitException;
import com.company.jproject.Utils.LevelReader;
import com.company.jproject.Utils.LevelResetException;
import java.util.ArrayList;
import java.util.Scanner;

public class Level {

    private final int levelNum;
    private final String[] level;
    private ArrayList<State> steps;
    private boolean isCompleted;
    public static final int allLevelsNum = 15;

    public Level(int levelNum){
        this.levelNum = levelNum;
        this.level = LevelReader.readLevel(levelNum);
        this.isCompleted = false;
    }

    public void start() throws LevelExitException {
        printLevelName();
        Square[][] levelBoard = convertLevelToSquareBoard();
        while(!isCompleted()){
            try {
                play(levelBoard);
            }catch (LevelResetException ex){
                System.out.println(ex.getMessage());
                levelBoard = convertLevelToSquareBoard();
            }
        }
    }

    private void play(Square[][] board) throws LevelResetException, LevelExitException {
        Scanner input = new Scanner(System.in);
        steps = new ArrayList<>();
        State currState = new State(board);
        System.out.println(currState);
        steps.add(currState);
        while(!currState.isFinalState()) {
            System.out.println("Enter Direction (wasd, r=reset, e=exit):");
            char command = input.next().charAt(0);
            if(command == 'r') throw new LevelResetException();
            if(command == 'e') throw new LevelExitException();
            System.out.println(MoveDirection.getMoveDirectionName(command));
            currState = currState.move(MoveDirection.getMoveDirectionByChar(command));
            System.out.println(currState);
            steps.add(currState);
        }
        setCompleted();
    }

    public Square[][] convertLevelToSquareBoard() {
        Square[][] squares = new Square[level.length][level[0].toCharArray().length];
        for (int i = 0; i < level.length; i++) {
            char[] row = level[i].toCharArray();
            for (int j = 0; j < row.length; j++) {
                squares[i][j] = Square.getSquareByChar(row[j]);
            }
        }
        return squares;
    }

    public void printLevelName() {
        System.out.println(ConsoleColors.RED + "======= Level "+ levelNum + " =======" + ConsoleColors.RESET + "\n");
    }

    public int getLevelNum() {
        return levelNum;
    }

    public String[] getLevel() {
        return level;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    private void setCompleted() {
        isCompleted = true;
    }

    public ArrayList<State> getSteps() {
        return steps;
    }

    @Override
    public String toString() {
        Square[][] board = convertLevelToSquareBoard();
        StringBuilder result = new StringBuilder();
        for (Square[] row: board) {
            for (Square square: row) {
            result.append(square.toString());
            }
            result.append('\n');
        }
        return result.toString();
    }
}
