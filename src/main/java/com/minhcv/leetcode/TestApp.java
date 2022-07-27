package com.minhcv.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class TestApp {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.hashCode();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int sum = list.stream().reduce(10, Integer::sum);
        System.out.println("Sum: " + sum);

        LinkedList<Integer> linkedList = new LinkedList<>();
        HashSet<Integer> set = list.stream().collect(Collectors.toCollection(HashSet::new));
        set.add(null);
        set.add(null);
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            System.out.println("Set value: " + it.next());
        }

        String lock = "";
        boolean flag = true;
        Thread thread = new Thread(() -> {

            synchronized (lock) {
                while (!flag) {
                    try {

                        System.out.println("thread 1 is about to wait");
                        lock.wait();
                        System.out.println("thread 1 woken up with flag set to " + flag);
                    } catch (InterruptedException ie) {
                        // swallow
                    }
                }
            }
        });

    }
}
