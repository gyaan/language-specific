import java.util.Arrays;

/**
 * Created by gyaneshwar on 31/08/16.
 */
public class HeapSort {

    int[] heap;
    int heapSize;

    public HeapSort(int[] heap) {
        this.heap = heap;
        this.heapSize = heap.length;
    }

    public void heapify(int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && this.heap[l] > this.heap[largest]) {
            largest = l;
        }
        if (r < n && this.heap[r] > this.heap[largest]) {
            largest = r;
        }
        if (i != largest) {
            int t = this.heap[i];
            this.heap[i] = this.heap[largest];
            this.heap[largest] = t;
            this.heapify(n,largest);
        }
    }

    private void sortArray() {

        for (int i = this.heapSize / 2 - 1; i >= 0; i--) {
             heapify(this.heapSize,i);
        }

        for(int i =this.heapSize-1; i>=0;i--){
            int t = this.heap[0];
            this.heap[0] = this.heap[i];
            this.heap[i] = t;
            heapify(i,0);
        }
    }

    public void printSortedArray() {
        System.out.println(Arrays.toString(this.heap));
    }

    public static void main(String[] args) {

        int [] heap = {2,1,5,6,3,90,13};
        HeapSort heapSort = new HeapSort(heap);
        heapSort.sortArray();
        heapSort.printSortedArray();
    }

}
