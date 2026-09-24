package com.learning.sort.selectsort;

import java.util.Arrays;

/**
 * 基于大顶堆思路的堆排序
 *
 * @author yanbowen
 * @since 2026-09-22
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        int end = arr.length;
        // 完全二叉树有N个结点（叶子+非叶子），则真正有孩子结点的最大结点索引是N/2
        for (int i = (arr.length) / 2 - 1; i >= 0; i--) {
            // 构建大顶堆
            adjustHeap(arr, i, end);
        }
        for (int i = end - 1; i > 0; i--) {
            // 大顶堆顶部值沉到最下面
            swap(arr, 0, i);
            // 除最大值外剩下的数据重建堆
            adjustHeap(arr, 0, i);
        }
    }

    public static void adjustHeap(int[] arr, int start, int end) {
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
