package com.minhcv.java11;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NotPredicateMethodApp {
    public static void main(String[] args) {
        List<String> lines = "Hello \n My name is Minh \n \n How are you to day?".lines().map(String::strip).collect(Collectors.toList());
        lines = lines.stream().filter(Predicate.not(String::isBlank)).collect(Collectors.toList());
        lines = lines.stream().filter(String::isBlank).collect(Collectors.toList());
        System.out.println("End");
    }
}
