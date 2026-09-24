package com.learning.sort.divideandconquer;

/**
 * 归并排序
 * 适合场景：链表排序、外部排序、需要稳定排序的场景
 * 典型场景：（外部排序）
 * 数据库要对一张 100GB 的表按某字段排序，而机器内存只有 16GB
 * 日志文件几十上百 GB，需要排序后分析
 * 搜索引擎要对海量网页数据建立有序索引
 *
 * @author yanbowen
 * @since 2026-09-21
 */
public class MergeSort {
    public static int[] mergeSort(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            //左右归并
            merge(arr, low, mid, high);
        }
        return arr;
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int x = 0; x < temp.length; x++) {
            a[x + low] = temp[x];
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
