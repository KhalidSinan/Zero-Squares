package com.company.jproject.Utils;

import com.company.jproject.Square.PlayableSquare;
import com.company.jproject.Square.Square;

public class LevelConverter {

    public static Square[][] convertLevelToSquareBoard(String[] level) {
        Square[][] squares = new Square[level.length][level[0].toCharArray().length];
        for (int i = 0; i < level.length; i++) {
            char[] row = level[i].toCharArray();
            int ignored = 0;
            for (int j = 0; j < row.length; j++) {
                if(row[j] == ','){
                    Square standOnSquare = Square.getSquareByChar(row[j+1]);
                    ((PlayableSquare) squares[i][j - 1 - ignored]).setStandOnSquare(standOnSquare);
                    j++;
                    ignored+=2;
                }
                else squares[i][j - ignored] = Square.getSquareByChar(row[j]);
            }
        }
        return squares;
    }
}
