package interview.preparation.company.design;

public class BSTArray {
    private Integer[] tree;
    private int size;

    public BSTArray(int capacity) {
        tree = new Integer[capacity];
        size = 0;
    }

    public void insert(int value) {
        insertAt(0, value);
    }

    private void insertAt(int index, int value) {

        if (index >= tree.length) {
            throw new RuntimeException("Array size exceeded");
        }

        if (tree[index] == null) {
            tree[index] = value;
            size++;
            return;
        }

        if (value < tree[index]) {
            insertAt(2 * index + 1, value);
        } else {
            insertAt(2 * index + 2, value);
        }
    }

    public void print() {
        for (int i = 0; i < tree.length; i++) {
            System.out.println(i + " -> " + tree[i]);
        }
    }

    public class Main {
        public static void main(String[] args) {

            BSTArray bst = new BSTArray(31);

            int[] arr = {5, 3, 7, 2, 4, 6, 8};

            for (int v : arr) {
                bst.insert(v);
            }

            bst.print();
        }
    }
}
