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
//            // ����β��, ��һֱ�����ۼ�������
//            return true;
//        }
//        for (int i = index; i < numLength; i++) {
//            if (num.charAt(index) == '0' && i > index) {
//                // �����һ����0�ҵ�ǰ�����Ȳ�Ϊ, ��ô��˵������0����0x, ���������, ֱ�ӷ���false����
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
//            for (int j = 0; j < i; j++) { // k, l �ֱ������������jΪ���ѵ�λ��
//                k = k * 10 + (num.charAt(j) - '0'); // �����һ������ֵ
//                long l = 0;
//                if (j > 0 && num.charAt(0) == '0') break; // �����һ������ͷ��0���Ҵ�ʱ���ȴ���1����ֱ�ӽ���ѭ��
//                if (i - j - 1 > 0 && num.charAt(j + 1) == '0') continue; // ����ڶ�������ͷ��0�ҳ��ȴ���1���������˴η���
//                for (int m = j + 1; m <= i; m++) l = l * 10 + (num.charAt(m) - '0'); // ����ڶ�������ֵ
//                if (backtrack(num, k, l, i + 1)) return true; // �������ۼ���������true
//            }
//        }
//        return false;
//    }
//
//    public boolean backtrack(String num, long i, long j, int idx) {
//        long n = 0;
//        for (int k = idx; k < num.length(); k++) {
//            n = n * 10 + (num.charAt(k) - '0'); // �����������ܵĺ�
//            if (i + j == n) {
//                if (k == num.length() - 1 || backtrack(num, j, n, k + 1)) return true;
//            }
//            if (num.charAt(idx) == '0' || n >= i + j) break; // �����һ��λ����Ϊ0���ʱ�ʹ�������֮�ͣ����˳�ѭ���������ټ����ۼӺ�
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
