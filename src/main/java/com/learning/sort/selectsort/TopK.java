package com.learning.sort.selectsort;

import java.util.Arrays;

/**
 * 求最大的前几个数和最小的前几个数
 * 1、TopK解法;（用小顶堆/大顶堆思想）
 * 2、Java里面的优先队列本身就自带排序功能 {@link java.util.PriorityQueue}
 * 3、其它方法：（可以添加到list中然后每次排序再判断）
 *
 * @author yanbowen
 * @since 2026-09-22
 */
public class TopK {
    public static void main(String[] args) {
        int[] arr = {50, 10, 90, 30, 70, 40, 80, 60, 20, 120, 1, 99, 28, 30, 11, 22, 86, 22, 25, 26, 30};
        int[] topMaxNumbersArr = queryTopMaxNumbers(arr, 5);
        System.out.println("topMaxNumbersArr ——> " + Arrays.toString(topMaxNumbersArr));
        int[] topMinNumbersArr = queryTopMinNumbers(arr, 5);
        System.out.println("topMinNumbersArr ——> " + Arrays.toString(topMinNumbersArr));
    }

    public static int[] queryTopMaxNumbers(int[] arr, int topNumbers) {
        int[] topMaxNumberArr = new int[topNumbers];
        for (int i = 0; i < topNumbers; i++) {
            topMaxNumberArr[i] = arr[i];
        }
        for (int i = (topMaxNumberArr.length) / 2 - 1; i >= 0; i--) {
            // 构建小顶堆（确保树根最小）
            adjustSmallHeap(topMaxNumberArr, i, topNumbers);
        }
        for (int i = topNumbers; i < arr.length; i++) {
            if (arr[i] > topMaxNumberArr[0]) {
                topMaxNumberArr[0] = arr[i];
                adjustSmallHeap(topMaxNumberArr, 0, topNumbers);
            }
        }
        return topMaxNumberArr;
    }

    public static void adjustSmallHeap(int[] arr, int start, int end) {
        int temp = arr[start];
        // 找完全二叉村的左右孩子结点
        int left = (start + 1) * 2 - 1;
        int right = (start + 1) * 2;
        int j = left;
        // j指向值较大的孩子结点
        if (left < end && right < end && arr[right] < arr[left]) {
            j = right;
        }
        if (j < end && temp > arr[j]) {
            swap(arr, start, j);
            // 递归遍历下一层孩子结点
            adjustSmallHeap(arr, j, end);
        }
    }

    public static int[] queryTopMinNumbers(int[] arr, int topNumbers) {
        int[] topMinNumberArr = new int[topNumbers];
        for (int i = 0; i < topNumbers; i++) {
            topMinNumberArr[i] = arr[i];
        }
        for (int i = (topMinNumberArr.length) / 2 - 1; i >= 0; i--) {
            // 构建大顶堆（确保树根最大）
            adjustBigHeap(topMinNumberArr, i, topNumbers);
        }
        for (int i = topNumbers; i < arr.length; i++) {
            if (arr[i] < topMinNumberArr[0]) {
                topMinNumberArr[0] = arr[i];
                adjustBigHeap(topMinNumberArr, 0, topNumbers);
            }
        }
        return topMinNumberArr;
    }

    public static void adjustBigHeap(int[] arr, int start, int end) {
        int temp = arr[start];
        // 找完全二叉村的左右孩子结点
        int left = (start + 1) * 2 - 1;
        int right = (start + 1) * 2;
        int j = left;
        // j指向值较大的孩子结点
        if (left < end && right < end && arr[left] < arr[right]) {
            j = right;
        }
        if (j < end && temp < arr[j]) {
            swap(arr, start, j);
            // 递归遍历下一层孩子结点
            adjustBigHeap(arr, j, end);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
