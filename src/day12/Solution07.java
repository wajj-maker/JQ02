package day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Solution07 {
    private int[] nums;
    private int[] indexs;
    private int[] ans;
    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        this.nums = nums;
        indexs = new int[nums.length];
        ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexs[i] = i;
        }
        int[] temp = new int[nums.length];
        int[] tempIndexs = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp, tempIndexs);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(ans[i]);
        }
        return list;
    }
    public void mergeSort(int[] nums, int low, int high, int[] temp, int[] tempIndexs) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(nums, low, mid, temp, tempIndexs);
            mergeSort(nums, mid + 1, high, temp, tempIndexs);
            merge(nums, low, mid, high, temp, tempIndexs);
        }
    }
    public void merge(int[] nums, int low, int mid, int high, int[] temp, int[] tempIndexs) {
        int a = 0;
        int b = mid + 1;
        int index = high;
        while (a <= mid && b <= high) {
            if (nums[a] > nums[b]) {
                temp[index] = nums[a];
                ans[indexs[a]] += b - mid;
                tempIndexs[index] = indexs[a];
                index--;
                a++;
            } else {
                temp[index] = nums[b];
                tempIndexs[index] = indexs[b];
                index--;
                b++;
            }
        }
        while (a <= mid) {
            temp[index] = nums[a];
            ans[indexs[a]] += high - mid;
            tempIndexs[index] = indexs[a];
            index--;
            a++;
        }
        while (b <= high) {
            temp[index] = nums[b];
            tempIndexs[index] = indexs[b];
            index--;
            b++;
        }
        for (int i = low; i <= high; i++) {
            nums[i] = temp[i];
            indexs[i] = tempIndexs[i];
        }
    }


}
