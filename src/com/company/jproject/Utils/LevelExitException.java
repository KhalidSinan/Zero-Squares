package com.company.jproject.Utils;

import com.company.jproject.ConsoleColors;

public class LevelExitException extends Exception{

    final static String exitMessage = ConsoleColors.YELLOW + "======= Exited =======" + ConsoleColors.RESET + "\n";

    public LevelExitException() {
        super(exitMessage);
    }
}
