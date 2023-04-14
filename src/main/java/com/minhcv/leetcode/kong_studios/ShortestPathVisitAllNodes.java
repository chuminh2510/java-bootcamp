package com.minhcv.leetcode.kong_studios;

import java.util.ArrayList;
import java.util.List;

public class ShortestPathVisitAllNodes {
    public static void main(String[] args) {
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(0, 1, 7));
        lines.add(new Line(0, 3, 6));
        lines.add(new Line(3, 1, 9));
        lines.add(new Line(3, 2, 8));
        lines.add(new Line(1, 2, 6));
        shortestPathBacktracking(4, 5, lines);
    }

    private static int minLength = Integer.MAX_VALUE;

    public static void shortestPathBacktracking(int n, int m, List<Line> lines) {
        for (int i = 0; i < n; i++) {
            List<Integer> visitedVertex = new ArrayList<>();
            visitedVertex.add(i);
            backtracking(n, m, lines, i, visitedVertex, 0);

        }
        System.out.println("Min length: " + minLength);
    }

    public static void backtracking(int n, int m, List<Line> lines, int currentVertex, List<Integer> visitedVertex, int length) {
        if (visitedVertex.size() == n) {
            if (length <= minLength) {
                minLength = length;
            }
            return;
        }
        for (int vertex = 0; vertex < n; vertex++) {
            if (visitedVertex.contains(vertex)) {
                continue;
            }
            boolean isExistLine = false;
            int tmpLength = length;
            for (int idx = 0; idx < lines.size(); idx++) {
                Line line = lines.get(idx);
                if ((line.vertex1 == currentVertex && line.vertex2 == vertex)
                        || line.vertex2 == currentVertex && line.vertex1 == vertex) {
                    tmpLength += line.length;
                    isExistLine = true;
                    break;
                }
            }
            if (!isExistLine) {
                continue;
            }
            visitedVertex.add(vertex);
            backtracking(n, m, lines, vertex, visitedVertex, tmpLength);
            visitedVertex.remove(visitedVertex.size() - 1);
        }

    }

    public static class Line {
        int vertex1;
        int vertex2;
        int length;

        public Line(int vertex1, int vertex2, int length) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.length = length;
        }
    }
}
