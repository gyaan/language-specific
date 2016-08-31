import java.util.Arrays;

/**
 * Created by gyaneshwar on 28/08/16.
 */
public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {32, 4, 3, 12, 89, 14, 7};
        int[] a = bubbleSort.bubbleSort(arr);
        System.out.println(Arrays.toString(a));
    }

    public int[] bubbleSort(int arr[]) {
        int length = arr.length;
        for (int i = length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
        return arr;
    }
}
