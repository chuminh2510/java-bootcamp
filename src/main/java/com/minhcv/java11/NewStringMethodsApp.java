package com.minhcv.java11;

import java.util.List;
import java.util.stream.Collectors;

public class NewStringMethodsApp {
    public static void main(String[] args) {
        String multipleLines = "Hello\n My name is Minh \n How are you today.";
        List<String> lines = multipleLines.lines().filter(line -> !line.isBlank()).map(String::strip).collect(Collectors.toList());
        lines.forEach(line -> System.out.println("Line: " + line));

        String repeatString = "Hello. ".repeat(5);
        System.out.println("Repeat: " + repeatString);
    }
}
