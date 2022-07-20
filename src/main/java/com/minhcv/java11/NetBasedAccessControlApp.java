package com.minhcv.java11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NetBasedAccessControlApp {
    public static void main(String[] args) {
        boolean isNested = MainClass.class.isNestmateOf(MainClass.FirstNestedClass.class);
        System.out.println("Nested Main class - Nested class: " + isNested);

        boolean isHost = MainClass.SecondNestedClass.class.getNestHost().equals(MainClass.class);
        System.out.println("Host Main class - Nested class: " + isHost); // False -> return {@NetBasedAccessControlApp}
        Stream<Class<?>> stream = Arrays.stream(MainClass.FirstNestedClass.class.getNestMembers());
        Stream<String> stream2 = stream.map(Class::getSimpleName);
        List<String> classNames = stream2.collect(Collectors.toList());
        System.out.println("Nested classes: " + classNames);

    }

    static class MainClass {
        static class FirstNestedClass {

        }

        class SecondNestedClass {

        }
    }
}
