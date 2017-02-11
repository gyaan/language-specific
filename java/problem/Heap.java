package problem;

import java.util.Arrays;

/**
 * Created by gyaneshwar on 07/02/2017.
 */
public class Heap {


    int size = 0;
    int capacity = 10;
    int[] arr = new int[capacity];

    private int getLeftChildIndex(int parentIndex) {
        return (2 * parentIndex) + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return (2 * parentIndex) + 2;
    }

    private int getParentIndex(int ChildIndex) {
        return (ChildIndex - 1) / 2;
    }


    private boolean hasLeftChild(int parentIndex) {
        return getLeftChildIndex(parentIndex) < size;
    }

    private boolean hasRightChild(int parentIndex) {
        return getRightChildIndex(parentIndex) < size;
    }

    private boolean hasParent(int childIndex) {
        return getParentIndex(childIndex) >= 0;
    }

    private int getLeftChild(int parentIndex) {
        return this.arr[getLeftChildIndex(parentIndex)];
    }

    private int getRightChild(int parentIndex) {
        return this.arr[getRightChildIndex(parentIndex)];
    }

    private int getParent(int childIndex) {
        return this.arr[getParentIndex(childIndex)];
    }


    public int peak() {
        if (size == 0)
            throw new IllegalStateException();

        return this.arr[0];
    }

    public void swap(int indexOne, int indexTwo) {
        int temp = arr[indexOne];
        arr[indexOne] = arr[indexTwo];
        arr[indexTwo] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            arr = Arrays.copyOf(arr, capacity * 2);
            capacity *= 2;
        }
    }


    public int pull() {
        if (size == 0)
            throw new IllegalStateException();
        int temp = arr[0];
        swap(0, size - 1);
        size--;
        heapifyDown();
        return temp;
    }

    public void add(int value) {
        //check for space
        ensureExtraCapacity();
        arr[size] = value;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && getParent(index) > arr[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && getRightChild(index) < getLeftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (arr[index] < arr[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }

            index = smallerChildIndex;
        }

    }

    public void printHeap() {

        for (int a : arr) {
            System.out.println(a);

        }
    }


    public static void main(String[] args) {

        Heap heap = new Heap();
        heap.add(10);
        heap.add(4);
        heap.add(104);
        heap.add(40);
        heap.pull();
        heap.add(45);
        heap.add(14);
        heap.add(43);
        heap.pull();
        heap.add(34);

        System.out.println(heap.peak());

//        heap.printHeap();


    }

}
