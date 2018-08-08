package tree;


public class MyTree {
    private static Node root;

    static class Node {
        int key;
        int value;
        Node l;
        Node r;
        Node p;

        private Node(int key, int value, Node p) {
            this.key = key;
            this.value = value;
            this.p = p;
        }
    }

    public Node search(Node t, int key) {

        if (t == null || t.key == key)
            return t;
        if (key < t.key)
            return search(t.l, key);
        else
            return search(t.r, key);
    }

    void search(int key) {
        search(root, key);

    }

    private Node insert(Node t, Node p, int key, int value) {
        if (t == null) {
            t = new Node(key, value, p);
        } else {
            if (key < t.key)
                t.l = insert(t.l, t, key, value);
            else
                t.r = insert(t.r, t, key, value);
        }
        return t;
    }

    void insert(int key, int value) {
        root = insert(root, null, key, value);
    }

    private void replace(Node a, Node b) {
        if (a.p == null)
            root = b;
        else if (a == a.p.l)
            a.p.l = b;
        else
            a.p.r = b;
        if (b != null)
            b.p = a.p;
    }

    public String toString() {
        String s = "[";
        return s + getString(root) + "]";
    }

    public static String getString(Node root) {
        return root == null ? "" : getString(root.l) + " " + root.value + " " + getString(root.r);
    }

    private void remove(Node t, int key) {
        if (t == null)
            return;
        if (key < t.key)
            remove(t.l, key);
        else if (key > t.key)
            remove(t.r, key);
        else if (t.l != null && t.r != null) {
            Node m = t.r;
            while (m.l != null)
                m = m.l;
            t.key = m.key;
            t.value = m.value;
            replace(m, m.r);
        } else if (t.l != null) {
            replace(t, t.l);
        } else if (t.r != null) {
            replace(t, t.r);
        } else {
            replace(t, null);
        }
    }

    void remove(int key) {
        remove(root, key);
    }

    void print(Node t) {
        if (t != null) {
            print(t.l);
            System.out.print(t.key + ":" + t.value + " ");
            print(t.r);
        }
    }

    void print() {
        print(root);
        System.out.println();
    }
}