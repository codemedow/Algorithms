
// Check of Binary Tree is a Binary Search Tree
public class BinaryTree {

    //Root of the Binary Tree
    public Node root;

    /* Driver program to test above functions */
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        if (tree.checkBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }


    boolean checkBST() {

        return checkBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean checkBSTHelper(Node root, int min, int max) {
        //No tree
        if (root == null) return true;
        if (root.data < min || root.data > max) {
            return false;
        }
        return checkBSTHelper(root.left, min, root.data - 1) && checkBSTHelper(root.right, root.data + 1, max);
    }


}