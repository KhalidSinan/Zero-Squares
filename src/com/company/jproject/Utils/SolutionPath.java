package com.company.jproject.Utils;

import com.company.jproject.Algorithms.Node;

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
