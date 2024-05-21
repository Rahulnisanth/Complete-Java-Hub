import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}


public class BSTDeletion
{
    static Node root;
    // Printing :
    public static void inorder(Node node)
    {
        if(node == null) {
            return;
        } else {
            inorder(node.left);
            System.out.println(node.data);
            inorder(node.right);
        }
    }
    // Insertion :
    public static Node insert(Node node, int key) {
        if (node == null) 
            return new Node(key);

        if (key < node.data) 
            node.left = insert(node.left, key);
        else 
            node.right = insert(node.right, key);

        return node;
    } 
    // Deletion:
    public static Node dele(Node node, int delValue) {
        if (node == null) {
            return node;
        }
        if (delValue < node.data) {
            node.left = dele(node.left, delValue);
        } else if (delValue > node.data) {
            node.right = dele(node.right, delValue);
        } else {
            // Case - 1 => Node with one or no children:
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            // Case - 2 => Node with two children:
            node.data = minValue(node.right);
            node.right = dele(node.right, node.data);
        }
        return node;
    }

    // Min-value function:
    public static int minValue(Node node) {
        int minVal = node.data;
        while (node.left != null) {
            minVal = node.left.data;
            node = node.left;
        }
        return minVal;
    }


    public static void main(String[] args) {
        int n, del;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        root = insert(null,sc.nextInt());          

        for(int i=0;i<n-1;++i)
            insert(root,sc.nextInt());

        del = sc.nextInt();
        root = dele(root, del);
        // Inorder printing :
        System.out.print("Inorder Traversal: ");
        inorder(root);
        
        sc.close();
    }
}
