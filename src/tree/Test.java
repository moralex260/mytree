package tree;

public class Test {
    public static void main(String[] args) {
        MyTree tree = new MyTree();

        tree.insert(3, 1);
        tree.insert(2, 2);
        tree.insert(4, 5);
        System.out.println(tree);
        tree.print();
        tree.remove(2);
        tree.remove(3);
        tree.print();
        tree.remove(4);
        tree.insert(0, 30);
        tree.insert(1, 10);
        tree.insert(5, 50);
        System.out.println(tree);

    }
}
