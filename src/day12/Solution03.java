package day12;

import java.util.ArrayList;
import java.util.List;

public class Solution03 {
//    public boolean isAdditiveNumber(String num) {
//        return dfs(0, num, new ArrayList<>(num.length()));
//    }
//
//    private boolean dfs(int index, String num, List<Long> pre) {
//        int preLength = pre.size();
//        int numLength = num.length();
//        if (preLength >= 3 && pre.get(preLength - 1) != pre.get(preLength - 2) + pre.get(preLength - 3)) {
//            return false;
//        }
//        if (index == numLength && preLength >= 3) {
//            // 到结尾了, 且一直满足累加数规则
//            return true;
//        }
//        for (int i = index; i < numLength; i++) {
//            if (num.charAt(index) == '0' && i > index) {
//                // 如果第一个是0且当前数长度不为, 那么则说明不是0而是0x, 不合理的数, 直接返回false即可
//                break;
//            }
//            pre.add(substringTransferToLong(num, index, i));
//            if (dfs(i + 1, num, pre)) {
//                return true;
//            }
//            pre.remove(pre.size() - 1);
//        }
//        return false;
//    }
//
//    private long substringTransferToLong(String num, int start, int end) {
//        long result = 0;
//        for (int i = start; i <= end; i++) {
//            result += (num.charAt(i) - '0');
//            if (i != end) {
//                result *= 10;
//            }
//        }
//        return result;
//    }

//    public boolean isAdditiveNumber(String num) {
//        for (int i = 1; i < num.length(); i++) {
//            long k = 0;
//            for (int j = 0; j < i; j++) { // k, l 分别代表两加数，j为分裂的位置
//                k = k * 10 + (num.charAt(j) - '0'); // 计算第一个数的值
//                long l = 0;
//                if (j > 0 && num.charAt(0) == '0') break; // 如果第一个数开头是0并且此时长度大于1，则直接结束循环
//                if (i - j - 1 > 0 && num.charAt(j + 1) == '0') continue; // 如果第二个数开头是0且长度大于1，则跳过此次分裂
//                for (int m = j + 1; m <= i; m++) l = l * 10 + (num.charAt(m) - '0'); // 计算第二个数的值
//                if (backtrack(num, k, l, i + 1)) return true; // 如果组成累加数，返回true
//            }
//        }
//        return false;
//    }
//
//    public boolean backtrack(String num, long i, long j, int idx) {
//        long n = 0;
//        for (int k = idx; k < num.length(); k++) {
//            n = n * 10 + (num.charAt(k) - '0'); // 计算两数可能的和
//            if (i + j == n) {
//                if (k == num.length() - 1 || backtrack(num, j, n, k + 1)) return true;
//            }
//            if (num.charAt(idx) == '0' || n >= i + j) break; // 如果第一个位置上为0或此时和大于两数之和，则退出循环，不用再继续累加和
//        }
//        return false;
//    }

    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i < num.length(); i++) {
            long k = 0;
            for (int j = 0; j < i; j++) {
                k = k * 10 + (num.charAt(j) - '0');
                if (j > 0 && num.charAt(0) == '0') break;
                if (i - j > 1 && num.charAt(j + 1) == '0') continue;
                long l = 0;
                for (int m = j + 1; m < i + 1; m++) {
                    l = l * 10 + (num.charAt(m) - '0');
                }
                if (isOk(num, k, l, i + 1)) return true;
            }
        }
        return false;
    }

    public boolean isOk(String num, long k, long l, int index) {
        long n = 0;
        for (int i = index; i < num.length(); i++) {
            n = n * 10 + (num.charAt(i) - '0');
            if (k + l == n && i == num.length() - 1) return true;
            if (k + l == n && isOk(num, l, n, i + 1)) return true;
            if (n >= k + l || (num.charAt(index) == '0')) break;
        }
        return false;
    }
}
