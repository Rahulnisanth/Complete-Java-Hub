import java.util.*;

class Node{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

public class BSTInteresting {
    static Node root;

    public static boolean isValid(Node node) {
        if(node == null) {
            return true;
        } if(node.left != null && node.left.data > node.data) {
            return false;
        } if(node.right != null && node.right.data < node.data) {
            return false;
        } else {
            return isValid(node.left) && isValid(node.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        root = new Node(sc.nextInt());
        root.left = new Node(sc.nextInt());
        root.right = new Node(sc.nextInt());
        root.left.left = new Node(sc.nextInt());
        root.left.right = new Node(sc.nextInt());
        root.right.left = new Node(sc.nextInt());
        root.right.right = new Node(sc.nextInt());
        
        if(isValid(root))
            System.out.println("Valid BST");
        else
            System.out.println("Invalid BST");
        
        sc.close();
    }
}

