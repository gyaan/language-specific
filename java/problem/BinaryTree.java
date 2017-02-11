package problem;

/**
 * Created by gyaneshwar on 06/02/2017.
 */
public class BinaryTree {

    private static class Node {
        Node leftChild;
        Node rightChild;
        int data;

        Node(int value) {
            this.data = value;
        }
    }


    public static boolean isBst(Node n, int min, int max) {
        if (n == null)
            return true;
        if (n.data < min || n.data > max)
            return false;
        return isBst(n.leftChild, min, n.data - 1) && isBst(n.rightChild, n.data + 1, max);
    }

    public static void main(String[] args) {
        Node n = new Node(5);
        BinaryTree.isBst(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


}
