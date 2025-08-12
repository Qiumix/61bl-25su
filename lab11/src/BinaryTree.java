import java.util.ArrayList;

public class BinaryTree<T> {

    // Do not modify the TreeNode class.
    static class TreeNode<T> {
        T item;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T item) {
            this.item = item; left = right = null;
        }

        public TreeNode(T item, TreeNode<T> left, TreeNode<T> right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }

        public T getItem() {
            return item;
        }

        public TreeNode<T> getLeft() {
            return left;
        }

        public TreeNode<T> getRight() {
            return right;
        }
    }

    // protected gives subclasses the ability to access this instance variable,
    // but not other classes.
    TreeNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(TreeNode<T> t) {
        root = t;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    /** Optional constructor, see optional exercise in lab (or last week's theoretical lab). */
    public BinaryTree(ArrayList<T> pre, ArrayList<T> in) {
    }

    private TreeNode<T> buildHelper(ArrayList<T> pre, ArrayList<T> in, int preIndex, int inIndex) {
        return null;
    }

    /* Print the values in the tree in preorder. */
    public void printPreorder() {
        if (root == null) {
            System.out.println("(empty tree)");
        } else {
            printPreorderHelper(root);
            System.out.println();
        }
    }

    private void printPreorderHelper(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.item + " ");
        printPreorderHelper(node.left);
        printPreorderHelper(node.right);
    }

    /* Print the values in the tree in inorder: values in the left subtree
       first (in inorder), then the root value, then values in the first
       subtree (in inorder). */
    public void printInorder() {
        if (root == null) {
            System.out.println("(empty tree)");
        } else {
            printInorderHelper(root);
            System.out.println();
        }
    }

    /* Prints the nodes of the BinaryTree in inorder. Used for your testing. */
    private void printInorderHelper(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        printInorderHelper(node.left);
        System.out.print(node.item + " ");
        printInorderHelper(node.right);
    }

    /* Prints out the contents of a BinaryTree with a description in both
       preorder and inorder. */
    static void print(BinaryTree t, String description) {
        System.out.println(description + " in preorder");
        t.printPreorder();
        System.out.println(description + " in inorder");
        t.printInorder();
        System.out.println();
    }

    /* Fills this BinaryTree with values a, b, and c. DO NOT MODIFY. */
    public static BinaryTree<String> sampleTree1() {
        TreeNode<String> root = new TreeNode("a",
                new TreeNode("b"),
                new TreeNode("c"));
        return new BinaryTree<>(root);
    }

    /* Fills this BinaryTree with values a, b, and c, d, e, f. DO NOT MODIFY. */
    public static BinaryTree<String> sampleTree2() {
        TreeNode root = new TreeNode("a",
                new TreeNode("b",
                        new TreeNode("d",
                                new TreeNode("e"),
                                new TreeNode("f")),
                        null),
                new TreeNode("c"));
        return new BinaryTree<>(root);
    }

    /* Fills this BinaryTree with the values a, b, c, d, e, f. DO NOT MODIFY. */
    public static BinaryTree<String> sampleTree3() {
        TreeNode<String> root = new TreeNode("a",
                new TreeNode("b"),
                new TreeNode("c",
                        new TreeNode("d",
                                new TreeNode("e"),
                                new TreeNode("f")),
                        null));
        return new BinaryTree<>(root);
    }

    /* Fills this BinaryTree with the same leaf TreeNode. DO NOT MODIFY. */
    public static BinaryTree<String> sampleTree4() {
        TreeNode<String> leafNode = new TreeNode("c");
        TreeNode<String> root = new TreeNode("a", new TreeNode("b", leafNode, leafNode),
                new TreeNode("d", leafNode, leafNode));
        return new BinaryTree<>(root);
    }

    /* Creates two BinaryTrees and prints them out in inorder. */
    public static void main(String[] args) {
        BinaryTree<String> t = new BinaryTree<>();
        print(t, "the empty tree");
        t = BinaryTree.sampleTree1();
        print(t, "sample tree 1");
        t = BinaryTree.sampleTree2();
        print(t, "sample tree 2");
        t = BinaryTree.sampleTree3();
        print(t, "sample tree 3");
        t = BinaryTree.sampleTree4();
        print(t, "sample tree 4");
    }

    /* Returns the height of the tree. */
    public int height() {
        // TODO: YOUR CODE HERE
        if (root == null) {
            return 0;
        }
        return heightHelper(root);
    }

    private int heightHelper(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return Math.max(heightHelper(treeNode.left), heightHelper(treeNode.right)) + 1;
    }

    /* Returns true if the tree's left and right children are the same height
       and are themselves completely balanced. */
    public boolean isCompletelyBalanced() {
        // TODO: YOUR CODE HERE
        return isCompletelyBalanced(root);
    }

    public boolean isCompletelyBalanced(TreeNode treeNode) {
        if (treeNode == null || (treeNode.left == null && treeNode.right == null)) {
            return true;
        } else if (heightHelper(treeNode.left) == heightHelper(treeNode.right)) {
            return isCompletelyBalanced(treeNode.left) && isCompletelyBalanced(treeNode.right);
        } else {
            return false;
        }
    }

    /* Returns a BinaryTree representing the Fibonacci calculation for N. */
    public static BinaryTree<Integer> fibTree(int N) {
        BinaryTree<Integer> result = new BinaryTree<Integer>();
        result.root = fibTreeHelper(N);
        // TODO: YOUR CODE HERE
        return result;
    }

    private static TreeNode<Integer> fibTreeHelper(int N) {
        if (N == 1 || N == 0) {
            return new TreeNode<>(N);
        } else {
            TreeNode<Integer> left = fibTreeHelper(N - 1);
            TreeNode<Integer> right = fibTreeHelper(N - 2);
            return new TreeNode<>(left.item + right.item, left, right);
        }
    }
}