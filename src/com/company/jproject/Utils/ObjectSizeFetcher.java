package com.company.jproject.Utils;

import com.company.jproject.Square.PlayableSquare;
import com.company.jproject.Square.Square;

import java.lang.instrument.Instrumentation;

public class ObjectSizeFetcher {
    private static Instrumentation instrumentation;

    // This method is called before the main method of your application  
    public static void premain(String args, Instrumentation inst) {
        instrumentation = inst; // Save the reference to the instrumentation object  
    }

    // Method to get the size of an object  
    public static long getObjectSize(Object obj) {
        return instrumentation.getObjectSize(obj);
    }

}