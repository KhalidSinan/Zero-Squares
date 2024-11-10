package com.company.jproject.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LevelReader {

    public LevelReader() {}

    public static String[] readLevel(int levelNum)  {
        if(levelNum < 0 || levelNum > 30) return null;
        try {
            File file = new File("levels/" + levelNum + ".txt");
            BufferedReader buffReader = new BufferedReader(new FileReader(file));
            StringBuilder level = new StringBuilder();
            String line;
            while ((line = buffReader.readLine()) != null)
                level.append(line).append('\n');
            return level.toString().split("\n");
        } catch(IOException ex){
            System.out.println(ex.toString());
        }
        return null;
    }
}
