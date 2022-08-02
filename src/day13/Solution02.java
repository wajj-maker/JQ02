package day13;

public class Solution02 {
    public int minPatches(int[] nums, int n) {
        long temp = 0;
        long j = 0;
        int count = 0;
        int i = 0;
        while (temp < n) {
            j = temp + 1;
            if (i == nums.length || j < nums[i]) {
                temp += j;
                count++;
                continue;
            }
            temp += nums[i++];
        }
        return count;
    }

//    public int minPatches(int[] nums, int n) { // 1 5 10
//        int count = 0;
//        long temp = 0,j = 0;
//        for (int i=0;temp < n;) { // 1 2 4 5
//            j = temp + 1;
//            if (i == nums.length || j < nums[i]) {
//                temp += j;
//                count++;
//                continue;
//            }
//            temp += nums[i++];
//        }
//        return count;
//    }
}
