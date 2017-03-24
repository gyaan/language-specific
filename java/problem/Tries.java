package problem;

import java.util.Scanner;

/**
 * Created by gyaneshwar on 11/02/2017.
 */
public class Tries {

    private static class Node {
        private int NUMBER_OF_CHARACTERS = 26;
        Node[] children = new Node[NUMBER_OF_CHARACTERS];
        int size = 0;

        private int getCharIndex(char c) {
            return c - 'a';
        }

        private Node getNode(char c) {
            return children[getCharIndex(c)];
        }

        private void setNode(char c, Node node) {
            children[getCharIndex(c)] = node;
        }

        public void add(String s) {
            add(s, 0);
        }

        private void add(String s, int index) {
            size++;
            if (index == s.length()) return;
            char current = s.charAt(index);
            Node child = getNode(current);
            if (child == null) {
                child = new Node();
                setNode(current, child);
            }
            child.add(s, index + 1);
        }

        public int findCount(String s, int index) {
            if (index == s.length()) {
                return size;
            }
            Node child = getNode(s.charAt(index));
            if (child == null)
                return 0;
            return child.findCount(s, index + 1);
        }

    }


    //search word in the trie
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node node = new Node();
        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();
            if (op.equals("add")) {
                node.add(contact);
            }
            if (op.equals("find")) {
                System.out.println(node.findCount(contact, 0));
            }
        }
    }

}
