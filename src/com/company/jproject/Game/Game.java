package com.company.jproject.Game;

import com.company.jproject.Algorithms.Solution;
import com.company.jproject.Algorithms.Solver;
import com.company.jproject.Square.Square;
import com.company.jproject.Utils.LevelConverter;
import com.company.jproject.Utils.LevelExitException;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game {

    private final ArrayList<Level> levels;
    private boolean isCompleted;

    public Game(){
        this.levels = getAllLevels();
        this.isCompleted = false;
    }

    public Game(int startLevelNum) {
        this.levels = getAllLevels(startLevelNum);
        this.isCompleted = false;
    }

    public Game(int startLevelNum, int endLevelNum){
        this.levels = getAllLevels(startLevelNum, endLevelNum);
        this.isCompleted = false;
    }

    public void info() {
        System.out.println("Zero Squares Game by Khalid Sinan\n");
        System.out.println(new Level(1));
    }

    public void play() {
        for (Level level: levels) {
            try {
                level.start();
            } catch (LevelExitException e) {
                System.out.println(e.getMessage());
            }
        }
        setCompleted();
    }

    public ArrayList<Solution> solve(Solver solver){
        ArrayList<Solution> solutions = new ArrayList<>();
        for (Level level : levels) {
            Square[][] levelBoard = LevelConverter.convertLevelToSquareBoard(level.getLevel());
            State initialState = new State(levelBoard);
            Solution solution = solver.solve(initialState);
            solutions.add(solution);
        }
        return solutions;
    }


    public ArrayList<Level> getAllLevels() {
        ArrayList<Level> allLevels = new ArrayList<>();
        for(int levelNum = 1; levelNum <= Level.allLevelsNum ; levelNum++){
            allLevels.add(new Level(levelNum));
        }
        return allLevels;
    }

    public ArrayList<Level> getAllLevels(int startLevel){
        ArrayList<Level> allLevels = new ArrayList<>();
        for(int levelNum = startLevel; levelNum <= Level.allLevelsNum ; levelNum++){
            allLevels.add(new Level(levelNum));
        }
        return allLevels;
    }

    public ArrayList<Level> getAllLevels(int startLevel, int endLevel){
        endLevel = Math.min(endLevel, Level.allLevelsNum);
        ArrayList<Level> allLevels = new ArrayList<>();
        for(int levelNum = startLevel; levelNum <= endLevel ; levelNum++){
            allLevels.add(new Level(levelNum));
        }
        return allLevels;
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    private void setCompleted() {
        isCompleted = true;
    }
}
