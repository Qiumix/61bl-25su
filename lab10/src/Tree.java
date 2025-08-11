package src;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

import java.util.Iterator;

public class Tree {
    public static void main(String[] args) {
        Tree root, right;
        root = new Tree(9, new Tree(4), new Tree(2));
        right = new Tree(8, new Tree(7), null);
        root = new Tree(5, root, right);
        right = new Tree(1, new Tree(6), new Tree(0));
        root = new Tree(3, root, right);
        Iterator<Integer> pre = new Tree.pre(root).iterator();
        Iterator<Integer> post = new Tree.post(root).iterator();
        Iterator<Integer> in = new Tree.in(root).iterator();
        root.print(pre);
        root.print(in);
        root.print(post);
    }

    void print(Iterator<Integer> iter) {
        int t = 1;
        while (iter.hasNext()) {
            t *= iter.next();
            System.out.print(t + "\t");
        }
        System.out.println();
    }
    int value;
    Tree right;
    Tree left;
    Tree(int value, Tree left, Tree right) {
        this.value = value;
        this.right = right;
        this.left = left;
    }
    Tree(int value) {
        this.value = value;
        right = null;
        left = null;
    }

    static class in {
        Queue<Integer> all;
        in(Tree tree) {
            all = new Queue();
            build(tree);
        }
        void build(Tree cur) {
            if (cur == null) {
                return;
            }
            build(cur.left);
            all.enqueue(cur.value);
            build(cur.right);
        }
        public Iterator<Integer> iterator() {
            return all.iterator();
        }
    }
    static class post {
        Queue<Integer> all;
        post(Tree tree) {
            all = new Queue();
            build(tree);
        }
        void build(Tree cur) {
            if (cur == null) {
                return;
            }
            build(cur.left);
            build(cur.right);
            all.enqueue(cur.value);
        }
        public Iterator<Integer> iterator() {
            return all.iterator();
        }
    }
    static class pre {
        Queue<Integer> all;
        pre(Tree tree) {
            all = new Queue();
            build(tree);
        }
        void build(Tree cur) {
            if (cur == null) {
                return;
            }
            all.enqueue(cur.value);
            build(cur.left);
            build(cur.right);
        }
        public Iterator<Integer> iterator() {
            return all.iterator();
        }
    }
}