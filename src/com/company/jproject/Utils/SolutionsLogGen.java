package com.company.jproject.Utils;
import com.company.jproject.Algorithms.Solution;
import com.company.jproject.Main;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SolutionsLogGen {

        public static Logger logger = Logger.getLogger(Main.class.getName());


        public void logSolverSolutions(SolverSolutions ...solversSolutions) {
            for (SolverSolutions solverSolutions: solversSolutions) {
                String solver = solverSolutions.getSolver().getName();
                createSolverDirectory(solver);
                for (Solution solution: solverSolutions.getSolutions()) {
                    try {
                        logSolution(solver, solution);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private void logSolution(String solver, Solution solution) throws IOException{
            FileHandler handler = new FileHandler("./logs/" + solver + "/level " + solution.getLevelNum() + ".log");
            handler.setFormatter(new LogFormatter());
            logger.addHandler(handler);
            logger.setLevel(Level.ALL);
            logger.log(Level.FINE, solver);
            logger.log(Level.FINE, "Solution Path = " + solution.getPathLength());
            logger.log(Level.FINE, "Number of Visited States = " + solution.getVisitedLength());
            logger.log(Level.FINE, "Time Taken = " + solution.getTime() + " ms");
            logger.log(Level.FINE, "Memory Usage =  " +  solution.getMemory() + " KB");
            handler.close();
        }
        
        private void createSolverDirectory(String solverName){
            File solverDirectory = new File("./logs/" + solverName);
            if(solverDirectory.exists()) return;
            solverDirectory.mkdir();
        }
    }

