/**
 * Created by gyaneshwar on 28/08/16.
 */
public class SelectionSort {

    public static void main(String[] args) {
        int a[] = {2, 3, 5, 1, 56, 13, 23};
        SelectionSort selectionSort = new SelectionSort();
        int[] sortedArray = selectionSort.selectionSort(a);
        selectionSort.printArray(sortedArray);
    }

    public int[] selectionSort(int arr[]) {

        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {

            //find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //keep the element in the sorted array
            int t = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = t;

        }
        return arr;
    }

    public void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "->");
        }
    }
}
