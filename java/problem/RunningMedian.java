package problem;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by gyaneshwar on 10/02/2017.
 */
public class RunningMedian {


    public static double[] getMedian(int[] array) {

        //this will be max heap
        PriorityQueue<Integer> lower = new PriorityQueue<Integer>(array.length,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1 * o1.compareTo(o2);
            }
        });

        //this will be min heap
        PriorityQueue<Integer> upper = new PriorityQueue<Integer>();
        double[] median = new double[array.length];

        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            addNumber(number, lower, upper);
            rebalance(lower, upper);
            median[i] = findMedian(lower, upper);
        }

        return median;
    }

    private static double findMedian(PriorityQueue<Integer> lower, PriorityQueue<Integer> upper) {
        PriorityQueue<Integer> biggerHeap = lower.size() > upper.size() ? lower : upper;
        PriorityQueue<Integer> smallerHeap = lower.size() > upper.size() ? upper : lower;

        if (biggerHeap.size() == smallerHeap.size()) {
            return (double) (biggerHeap.peek() + smallerHeap.peek()) / 2;
        } else {
            return (double) biggerHeap.peek();
        }

    }

    private static void rebalance(PriorityQueue<Integer> lower, PriorityQueue<Integer> upper) {

        PriorityQueue<Integer> biggerHeap = lower.size() > upper.size() ? lower : upper;
        PriorityQueue<Integer> smallerHeap = lower.size() > upper.size() ? upper : lower;
        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    private static void addNumber(int number, PriorityQueue<Integer> lower, PriorityQueue<Integer> upper) {

        if (lower.isEmpty() || lower.peek() > number) {
            lower.add(number);
        } else {
            upper.add(number);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        double[] arr = RunningMedian.getMedian(a);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


    }

}
