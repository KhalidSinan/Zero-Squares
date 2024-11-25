package com.company.jproject.Utils;

import com.company.jproject.Algorithms.Solution;
import com.company.jproject.Algorithms.Solver;

import java.util.ArrayList;

public class SolverSolutions {

    private final Solver solver;
    private ArrayList<Solution> solutions;

    public SolverSolutions(Solver solver) {
        this.solver = solver;
        this.solutions = new ArrayList<>();
    }

    public SolverSolutions(Solver solver, ArrayList<Solution> solutions) {
        this.solver = solver;
        this.solutions = solutions;
    }

    public void addSolution(Solution solution){
        solutions.add(solution);
    }

    public Solver getSolver() {
        return solver;
    }

    public ArrayList<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(ArrayList<Solution> solutions) {
        this.solutions = solutions;
    }
}
