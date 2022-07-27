package com.minhcv.leetcode.sort;

public class BinaryInsertionSort {
    public static void main(String[] args) {
        int a[]
                = {37, 23, 0, 17, 12, 72, 31, 46, 100, 88, 54};
        int n = a.length, i;

        insertionSort(a, n);
        System.out.println("Sorted array:");
        for (i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }

    static int binarySearch(int[] arr, int value, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (value == arr[mid]) {
                return mid + 1;
            } else if (value > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    static void insertionSort(int[] arr, int n) {
        int i, location, j, k, selected;
        for (i = 1; i < n; i++) {
            j = i - 1;
            selected = arr[i];
            location = binarySearch(arr, selected, 0, j);
            while (j >= location) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = selected;
        }
    }
}
