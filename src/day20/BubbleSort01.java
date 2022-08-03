package day20;

public class BubbleSort01 {
    public static void main(String[] args) {

    }

    public static void bubbleSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j + 1] > arr[j]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }  // 那个优化起不到明显效果
        }
    }
}
