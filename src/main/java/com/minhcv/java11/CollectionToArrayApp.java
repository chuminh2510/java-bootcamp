package com.minhcv.java11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionToArrayApp {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("My name is Minh");
        list.add("How are you today.");
        String[] arr = list.toArray(String[]::new);
        for (String s : arr) {
            System.out.println("Array: " + s);
        }

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Minh", 29));
        persons.add(new Person("Test", 30));

        arr = persons.stream().map(Person::getName).toArray(String[]::new);
        System.out.println("List: " + Arrays.toString(arr));

        Integer[] arr2 = persons.stream().map(Person::getAge).toArray(Integer[]::new);
        System.out.println("List: " + Arrays.toString(arr2));
    }

    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return this.name;
        }

        public int getAge() {
            return this.age;
        }
    }
}
