package com.minhcv.leetcode.math;

import java.util.LinkedList;

public class Test2App {
    public static void main(String[] args) {
        try {
            badMethod();
            System.out.println("A");
        } catch (Exception ex) {
            System.out.println("B");
        } finally {
            System.out.println("C");
        }
        System.out.println("D");

        LinkedList<Integer> list = new LinkedList<>();
        list.get(0);
    }

    public static void badMethod() {

    }


}
