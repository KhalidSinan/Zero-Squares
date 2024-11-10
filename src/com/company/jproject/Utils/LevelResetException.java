package com.company.jproject.Utils;

import com.company.jproject.ConsoleColors;

public class LevelResetException extends Exception{

    static final String resetMessage = ConsoleColors.YELLOW + "======= Reset Level =======" + ConsoleColors.RESET + "\n";

    public LevelResetException(){
        super(resetMessage);
    }
}
