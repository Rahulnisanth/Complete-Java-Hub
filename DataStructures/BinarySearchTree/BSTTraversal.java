import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}


public class BSTTraversal
{
    static Node root;

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

    public static void preorder(Node node)
    {
        if(node == null) {
            return;
        } else {
            System.out.println(node.data);
            inorder(node.left);
            inorder(node.right);
        }
    }

    public static void postorder(Node node)
    {
        if(node == null) {
            return;
        } else {
            inorder(node.left);
            inorder(node.right);
            System.out.println(node.data);
        }
    } 

    public static Node insert(Node node, int key) {
        if (node == null) 
            return new Node(key);

        if (key < node.data) 
            node.left = insert(node.left, key);
        else 
            node.right = insert(node.right, key);

        return node;
    }   

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        root = insert(null,sc.nextInt());          
        for(int i=0;i<n-1;++i)
            insert(root,sc.nextInt());
        // Inorder :
        System.out.print("Inorder Traversal: ");
        inorder(root);
        System.out.println();
        // Preorder :
        System.out.print("Preorder Traversal: ");
        preorder(root);
        System.out.println();
        // Postorder :
        System.out.print("Postorder Traversal: ");
        postorder(root);
        System.out.println();
        sc.close();
    }
}
