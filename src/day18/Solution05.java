package day18;

public class Solution05 {
    public String addStrings(String num1, String num2) {
        char[] arr1 = new char[Math.max(num1.length(), num2.length())];
        char[] arr2 = new char[Math.max(num1.length(), num2.length())];
        int index1 = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            arr1[index1++] = num1.charAt(i);
        }
        int index2 = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            arr2[index2++] = num2.charAt(i);
        }
        if (num2.length() < num1.length()) {
            for (int i = num2.length(); i < num1.length(); i++) {
                arr2[i] = '0';
            }
        } else {
            for (int i = num1.length(); i < num2.length(); i++) {
                arr1[i] = '0';
            }
        }
        int[] res = new int[Math.max(num1.length(), num2.length()) + 1];
        for (int i = 0; i < arr1.length; i++) {
            int temp = arr1[i] - '0' + arr2[i] - '0' + res[i];
            if (temp >= 10) {
                res[i + 1] = 1;
                temp -= 10;
            }
            res[i] = temp;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = res.length - 1; i >= 0; i--) {
            stringBuilder.append(res[i]);
        }
        if (stringBuilder.charAt(0) == '0') {
            return stringBuilder.toString().substring(1);
        } else {
            return stringBuilder.toString();
        }
    }
}
