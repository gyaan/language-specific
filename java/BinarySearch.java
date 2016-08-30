/**
 * Created by gyaneshwar on 28/08/16.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = {12, 30, 40, 100, 470};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.BinarySearch(arr, 0, 4, 40));
        System.out.println(binarySearch.RecursiveBinarySearch(arr, 0, 4, 40));
    }

    /**
     * iterative binary search
     *
     * @param arr : array of integers
     * @param l : left index
     * @param r : right index
     * @param key : search key
     * @return
     */
    public int BinarySearch(int arr[], int l, int r, int key) {

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                l = mid + 1;
            } else if (arr[mid] > key) {
                r = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Recursive binary search function
     *
     * @param arr : array of integer values
     * @param l :left index
     * @param r :right index
     * @param key :search key
     * @return index of searched element
     */
    public int RecursiveBinarySearch(int arr[], int l, int r, int key) {
        int mid = l + (r - l) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] > key) {
            return this.RecursiveBinarySearch(arr, l, mid - 1, key);
        } else if (arr[mid] < key) {
            return this.RecursiveBinarySearch(arr, mid + 1, r, key);
        }
        return -1; //no element found
    }
}
