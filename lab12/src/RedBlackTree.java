public class RedBlackTree<T extends Comparable<T>> {

    /* Root of the tree. */
    RBTreeNode<T> root;

    static class RBTreeNode<T> {

        final T item;
        boolean isBlack;
        RBTreeNode<T> left;
        RBTreeNode<T> right;

        /*
         * Creates a RBTreeNode with item ITEM and color depending on ISBLACK
         * value.
         */
        RBTreeNode(boolean isBlack, T item) {
            this(isBlack, item, null, null);
        }

        /*
         * Creates a RBTreeNode with item ITEM, color depending on ISBLACK
         * value, left child LEFT, and right child RIGHT.
         */
        RBTreeNode(boolean isBlack, T item, RBTreeNode<T> left,
                   RBTreeNode<T> right) {
            this.isBlack = isBlack;
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

    /* Creates an empty RedBlackTree. */
    public RedBlackTree() {
        root = null;
    }

    /* Creates a RedBlackTree from a given 2-3 TREE. */
    public RedBlackTree(TwoThreeTree<T> tree) {
        Node<T> ttTreeRoot = tree.root;
        root = buildRedBlackTree(ttTreeRoot);
    }

    /*
     * Builds a RedBlackTree that has isometry with given 2-3 tree rooted at
     * given node R, and returns the root node.
     */
    RBTreeNode<T> buildRedBlackTree(Node<T> r) {
        if (r == null) {
            return null;
        }

        if (r.getItemCount() == 1) {
            // TODO: Replace with code to create a 2-node equivalent
            RBTreeNode<T> temp = new RBTreeNode<>(true, r.getItemAt(0));
            temp.left = buildRedBlackTree(r.getChildAt(0));
            temp.right = buildRedBlackTree(r.getChildAt(1));
            return temp;
        } else {
            RBTreeNode<T> top = new RBTreeNode<>(true, r.getItemAt(1));
            RBTreeNode<T> bottom = new RBTreeNode<>(false, r.getItemAt(0));
            top.right = buildRedBlackTree(r.getChildAt(2));
            top.left = bottom;
            bottom.left = buildRedBlackTree(r.getChildAt(0));
            bottom.right = buildRedBlackTree(r.getChildAt(1));
            // TODO: Replace with code to create a 3-node equivalent
            return top;
        }
    }

    /**
     * Flips the color of node and its children. Assume that NODE has both left
     * and right children
     * 
     * @param node
     */
    void flipColors(RBTreeNode<T> node) {
        // TODO: YOUR CODE HERE
        if (node.right == null || node.left == null) {
            return;
        }
        node.isBlack = !node.isBlack;
        node.left.isBlack = !node.left.isBlack;
        node.right.isBlack = !node.right.isBlack;
    }

    /**
     * Rotates the given node to the right. Returns the new root node of
     * this subtree. For this implementation, make sure to swap the colors
     * of the new root and the old root!
     * 
     * @param node
     * @return
     */
    RBTreeNode<T> rotateRight(RBTreeNode<T> node) {
        // TODO: YOUR CODE HERE
        if (node.left == null) {
            return node;
        }
        RBTreeNode<T> left = node.left;
        RBTreeNode<T> LR = left.right;
        left.right = node;
        node.left = LR;
        boolean nodeColor = node.isBlack;
        node.isBlack = left.isBlack;
        left.isBlack = nodeColor;
        return left;
    }

    /**
     * Rotates the given node to the left. Returns the new root node of
     * this subtree. For this implementation, make sure to swap the colors
     * of the new root and the old root!
     * 
     * @param node
     * @return
     */
    RBTreeNode<T> rotateLeft(RBTreeNode<T> node) {
        // TODO: YOUR CODE HERE
        if (node.right == null) {
            return node;
        }
        RBTreeNode<T> right = node.right;
        RBTreeNode<T> RL = right.left;
        right.left = node;
        node.right = RL;
        boolean nodeColor = node.isBlack;
        node.isBlack = right.isBlack;
        right.isBlack = nodeColor;
        return right;
    }

    /**
     * Inserts the item into the Red Black Tree. Colors the root of the tree black.
     * 
     * @param item
     */
    public void insert(T item) {
        root = insert(root, item);
        root.isBlack = true;
    }

    /**
     * Inserts the given node into this Red Black Tree. Comments have been provided
     * to help break
     * down the problem. For each case, consider the scenario needed to perform
     * those operations.
     * Make sure to also review the other methods in this class!
     * 
     * @param node
     * @param item
     * @return
     */
    private RBTreeNode<T> insert(RBTreeNode<T> node, T item) {
        // TODO: Insert (return) new red leaf node.
        if (node == null) {
            return new RBTreeNode<>(false, item);
        }
        // TODO: Handle normal binary search tree insertion. The below line may help.
        int comp = item.compareTo(node.item);
        if (comp == 0) {
            return node;
        } else if (comp > 0) {
            node.right = insert(node.right, item);
        } else {
            node.left = insert(node.left, item);
        }
        // TODO: Rotate left operation (handle "middle of three" and "right-leaning red"
        // structures)
        boolean middleOfThree = isRed(node.left) && isRed(node.left.right);
        boolean rightLeaning = isRed(node.right) && !isRed(node.left);
        if (middleOfThree || rightLeaning) {
            node = rotateLeft(node);
        }
        // TODO: Rotate right operation (handle "smallest of three" structure)
        boolean smallestOfThree = isRed(node.left) && isRed(node.left.left);
        if (smallestOfThree) {
            node = rotateRight(node);
        }
        // TODO: Color flip (handle "largest of three" structure)
        boolean largestOfThree = isRed(node.right) && isRed(node.left) && node.isBlack;
        if (largestOfThree) {
            flipColors(node);
        }
        return node; // TODO: fix this return statement
    }

    /**
     * Helper method that returns whether the given node is red. Null nodes
     * (children or leaf
     * nodes) are automatically considered black.
     * 
     * @param node
     * @return
     */
    private boolean isRed(RBTreeNode<T> node) {
        return node != null && !node.isBlack;
    }

}