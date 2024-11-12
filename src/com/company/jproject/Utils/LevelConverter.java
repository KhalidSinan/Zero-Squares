package com.company.jproject.Utils;

import com.company.jproject.Square.Square;

public class LevelConverter {

    public static Square[][] convertLevelToSquareBoard(String[] level) {
        Square[][] squares = new Square[level.length][level[0].toCharArray().length];
        for (int i = 0; i < level.length; i++) {
            char[] row = level[i].toCharArray();
            for (int j = 0; j < row.length; j++) {
                squares[i][j] = Square.getSquareByChar(row[j]);
            }
        }
        return squares;
    }
}
