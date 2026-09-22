package com.learning.sort.changesort;

import java.util.Arrays;

/**
 * https://blog.51cto.com/u_15671528/5524399
 *
 * @author yanbowen
 * @since 2026-09-20
 */
public class QuickSortIndex {
    public static void main(String[] args) {
        int[] arr = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int pivotIndex = partition(arr, leftIndex, rightIndex);
            quickSort(arr, leftIndex, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, rightIndex);
        }
    }

    public static int partition(int[] arr, int leftIndex, int rightIndex) {
        int pivot = arr[leftIndex];
        int left = leftIndex;
        int right = rightIndex;
        while (left < right) {
            while (left < right && arr[right] >= pivot) right--;
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) left++;
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }
}
