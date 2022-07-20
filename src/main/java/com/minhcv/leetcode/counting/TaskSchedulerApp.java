package com.minhcv.leetcode.counting;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/task-scheduler/
 */
public class TaskSchedulerApp {
    public static void main(String[] args) {
        Solution sol = new Solution();
        char[] chars = {'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'E'};
        System.out.println(sol.leastInterval(chars, 2));
    }

    static class Solution {
        public int leastInterval(char[] tasks, int n) {
            if (n == 0) {
                return tasks.length;
            }
            int times = 0;
            int[] charsCount = new int[26];
            for (int idx = 0; idx < tasks.length; idx++) {
                charsCount[tasks[idx] - 'A'] += 1;
            }
            List<Integer> sortedCounts = Arrays.stream(charsCount).boxed().filter(x -> x.compareTo(0) > 0).sorted((o1, o2) -> o2.compareTo(o1)).collect(Collectors.toList());
            while (sortedCounts.size() != 0) {
                for (int idx = 0, reducedN = n; idx <= n && idx <= reducedN; idx++) {
                    if (idx >= sortedCounts.size()) {
                        times++; // Idle
                        continue;
                    }
                    sortedCounts.set(idx, sortedCounts.get(idx) - 1);
                    times++; // Task
                    if (sortedCounts.get(idx) == 0) {
                        sortedCounts.remove(idx);
                        idx--;
                        reducedN--;
                        if (sortedCounts.size() == 0) {
                            break;
                        }
                    }
                }


                sortedCounts = sortedCounts.stream().sorted((o1, o2) -> o2.compareTo(o1)).collect(Collectors.toList());

            }
            return times;
        }
    }
}
