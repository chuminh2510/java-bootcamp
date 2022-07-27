package com.minhcv.leetcode.sort;

public class MergeSortApp {
    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        sort(arr, 0, arr.length - 1);
        for (int idx = 0; idx < arr.length; idx++) {
            System.out.println(arr[idx]);
        }
    }

    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int m = left + (right - left) / 2;
            sort(arr, left, m);
            sort(arr, m + 1, right);

            merge(arr, left, m, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        for (int i = 0; i < n1; i++) {
            arr1[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            arr2[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = arr1[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = arr2[j];
            j++;
            k++;
        }
    }
}
