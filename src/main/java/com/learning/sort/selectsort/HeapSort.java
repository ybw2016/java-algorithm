package com.learning.sort.selectsort;

import java.util.Arrays;

/**
 * @author yanbowen
 * @since 2026-09-22
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        int end = arr.length;
        for (int i = (arr.length) / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, end);
        }
        for (int i = end - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }

    public static void adjustHeap(int[] arr, int start, int end) {
        int temp = arr[start];
        int left = (start + 1) * 2 - 1;
        int right = (start + 1) * 2;
        int j = left;
        if (left < end && right < end && arr[left] < arr[right]) {
            j = right;
        }
        if (j < end && temp < arr[j]) {
            swap(arr, start, j);
            adjustHeap(arr, j, end);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        // int[] arr = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
