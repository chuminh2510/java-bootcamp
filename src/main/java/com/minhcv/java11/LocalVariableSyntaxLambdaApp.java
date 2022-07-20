package com.minhcv.java11;

import java.util.Arrays;
import java.util.List;

public class LocalVariableSyntaxLambdaApp {

    public static void main(String[] args) {
        List<String> lines = Arrays.asList("Line 1", "Line 2", "Line 3");
        var test = Arrays.asList("Top 1", "Top 2", "Top 3");
        System.out.println("Var = " + test.toString());
    }

}
