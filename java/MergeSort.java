import java.util.Arrays;

/**
 * Created by gyaneshwar on 30/08/16.
 */
public class MergeSort {

    int[] targetArray;
    public MergeSort(int[] targetArray) {
        this.targetArray = targetArray;
    }

    /**
     *
     */
    public void SortArray() {
        int m = this.targetArray.length - 1;
        this.mergeSort(0, m);
    }

    /**
     * @param l
     * @param r
     */
    private void mergeSort(int l, int r) {
        if (l < r) {
            int m = l+(r-l) / 2;
            this.mergeSort(l, m);
            this.mergeSort(m + 1, r);
            this.mergeArray(l, m, r);
        }
    }

    /**
     * @param l
     * @param m
     * @param r
     */
    private void mergeArray(int l, int m, int r) {

        int limit1 = (m - l + 1);
        int[] lArray = new int[limit1];

        int limit2 = (r - m);
        int[] rArray = new int[limit2];

        for (int i = 0; i < limit1; i++) {
            lArray[i] = this.targetArray[l + i];
        }
        for (int j = 0; j < limit2; j++) {
            rArray[j] = this.targetArray[m + j + 1];
        }

        int i = 0,j = 0,k = 0;

        while (i < limit1 && j < limit2) {
            if (lArray[i] <= rArray[j]) {
                this.targetArray[l + k] = lArray[i];
                i++;
            } else {
                this.targetArray[l + k] = rArray[j];
                j++;
            }
            k++;
        }
        while (i < limit1) {
            this.targetArray[l + k] = lArray[i];
            i++;
            k++;
        }

        while (j < limit2 - 1) {
            this.targetArray[l + k] = rArray[j];
            j++;
            k++;
        }
    }

    /**
     *
     */
    public void showArray() {
        System.out.println(Arrays.toString(this.targetArray));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] testArray = {3, 42, 5, 44, 13, 90, 20};
        MergeSort mergeSort = new MergeSort(testArray);
        mergeSort.SortArray();
        mergeSort.showArray();
    }
}

