package day01;

public class Solution06 {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i] + "";
            if (nums[i] != 0) flag = true;
        }
        if (!flag) {
            return "0";
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                String str1 = arr[j];
                String str2 = arr[j + 1];
                if (str1.length() > str2.length()) {
                    String str3 = str2;
                    for (int k = 0; k < str1.length() / str3.length(); k++) {
                        str2 += str3;
                    }
                    if (str2.length() > str1.length()) str1 += str1;
                } else if (str2.length() > str1.length()) {
                    String str3 = str1;
                    for (int k = 0; k < str2.length() / str3.length(); k++) {
                        str1 += str3;
                    }
                    if (str1.length() > str2.length()) str2 += str2;
                }
                if (str1.compareTo(str2) < 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return String.join("", arr);
    }
}
