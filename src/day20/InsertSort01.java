package day20;

import java.util.Arrays;

/**
 * ²åÈëÅÅĞòÁ·Ï°
 */
public class InsertSort01 {
    public static void main(String[] args) {
        int[] arr = new int[]{32, 23, 12, 11, 0, -23};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("ÁõÍş°®Ò¶æºâù");
        System.out.println("ÁõÍşÏ²»¶Ò¶æºâù");
    }

    public static void insertSort(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int j = i - 1;
            int value = arr[i];
            while (j >= 0 && arr[j] > value) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = value;
        }
    }
}
