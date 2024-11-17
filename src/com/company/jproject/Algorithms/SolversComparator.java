package com.company.jproject.Algorithms;

import com.company.jproject.ConsoleColors;
import com.company.jproject.Utils.TablePrinter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolversComparator {

    private final ArrayList<SolverSolutions> solversSolutions;

    public SolversComparator(SolverSolutions solutions1, SolverSolutions solutions2) {
        this.solversSolutions = new ArrayList<>();
        solversSolutions.add(solutions1);
        solversSolutions.add(solutions2);
    }

    public SolversComparator(SolverSolutions...solversSolutions) {
        this.solversSolutions = new ArrayList<>();
        this.solversSolutions.addAll(Arrays.asList(solversSolutions));
    }

    // TODO: GET HEADERS (SOLVER - LEVELS PATH LENGTH AND VISITED LENGTH) - GET DATA - DISPLAY
    public void compareByPathLength(){
        ArrayList<String> headers = new ArrayList<>();
        headers.add("Solver");
        for (Solution solution : solversSolutions.get(0).getSolutions()) {
            headers.add("Level " + solution.getLevelNum());
        }
        String[][] data = new String[solversSolutions.size()][headers.size()];
        for(int i = 0;i< solversSolutions.size(); i++){
            SolverSolutions solverSolutions = solversSolutions.get(i);
            data[i][0] = solverSolutions.getSolver().getName();
            for (int j = 1; j < headers.size(); j++){
                data[i][j] = Integer.toString(solverSolutions.getSolutions().get(j-1).getPathLength());
            }

        }
        TablePrinter printer = new TablePrinter();

        System.out.println(ConsoleColors.RED + "========== Compare By Path Length ==========" + ConsoleColors.RESET);
        printer.printTable(headers.toArray(new String[0]), data);
    }
    public void compareByVisitedNodesNumber(){
        ArrayList<String> headers = new ArrayList<>();
        headers.add("Solver");
        for (Solution solution : solversSolutions.get(0).getSolutions()) {
            headers.add("Level " + solution.getLevelNum());
        }
        String[][] data = new String[solversSolutions.size()][headers.size()];
        for(int i = 0;i< solversSolutions.size(); i++){
            SolverSolutions solverSolutions = solversSolutions.get(i);
            data[i][0] = solverSolutions.getSolver().getName();
            for (int j = 1; j < headers.size(); j++){
                data[i][j] = Integer.toString(solverSolutions.getSolutions().get(j-1).getVisitedLength());
            }

        }
        TablePrinter printer = new TablePrinter();

        System.out.println(ConsoleColors.RED + "========== Compare By Path Length ==========" + ConsoleColors.RESET);
        printer.printTable(headers.toArray(new String[0]), data);
    }
}
