package com.company.jproject.Game;

import com.company.jproject.ConsoleColors;
import com.company.jproject.MoveDirection.MoveDirection;
import com.company.jproject.Square.Square;
import com.company.jproject.Utils.LevelConverter;
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
    public static final int allLevelsNum = 30;

    public Level(int levelNum){
        this.levelNum = levelNum;
        this.level = LevelReader.readLevel(levelNum);
        this.isCompleted = false;
    }

    public void start() throws LevelExitException {
        printLevelName();
        Square[][] levelBoard = LevelConverter.convertLevelToSquareBoard(level);
        while(!isCompleted()){
            try {
                play(levelBoard);
            }catch (LevelResetException ex){
                System.out.println(ex.getMessage());
                levelBoard = LevelConverter.convertLevelToSquareBoard(level);
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
        Square[][] board = LevelConverter.convertLevelToSquareBoard(level);
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
