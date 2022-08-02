package day16;

public class Solution10 {
    public int lastRemaining(int n) {
        int first = 1; // ��ʾÿ������ʱ����Ԫ��
        int step = 1; // ��¼��Ԫ�ص���һ��Ԫ��
        int num = n; // ��ʾԪ�صĸ���
        boolean flag = false; // ������ʾ������
        while (num > 1) {
            if (!flag || (num & 1) == 1) {
                first += step;
            }
            step = step << 1;
            num = num >> 1;
            flag = !flag;
        }
        return first;
    }
}
