package com.learning.sort.insertsort;

import java.util.Arrays;

/**
 * @author yanbowen
 * @since 2026-09-21
 */
public class ShellSort {
    public static void shellSort(int[] arr) {
        int n = arr.length;
        // 增量序列：n/2, n/4, ..., 1（常用的二分增量）
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 对每个分组做直接插入排序（大范围移动）
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
        // 输出: [4, 13, 27, 38, 49, 49, 55, 65, 76, 97]
    }
}
