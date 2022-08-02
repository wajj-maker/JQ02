package day12;

import java.util.Arrays;

public class MergeSort01 {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 123, 1, -1, 200, -12};
        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr, int low, int high, int[] temp) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid, temp);
            mergeSort(arr, mid + 1, high, temp);
            merge(arr, low, mid, high, temp);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high, int[] temp) {
        int a = low;
        int b = mid + 1;
        int index = 0;
        while (a <= mid && b <= high) {
            if (arr[a] <= arr[b]) {
                temp[index++] = arr[a++];
            } else {
                temp[index++] = arr[b++];
            }
        }
        while (a <= mid) {
            temp[index++] = arr[a++];
        }
        while (b <= mid) {
            temp[index++] = arr[b++];
        }
        for (int i = 0; i < index; i++) {
            arr[low+i] = temp[i];
        }
    }
}
