package com.company.jproject.Algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class SolutionPath {

    public static ArrayList<Node> getSolutionPath(Node node){
        ArrayList<Node> path = new ArrayList<>();
        while(!node.isRoot()){
            path.add(node);
            node = node.getParent();
        }
        path.add(node);
        Collections.reverse(path);
        return path;
    }
}
