import java.util.*;

class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

public class BSTDeletion
{
    static Node root;
    
    public static void display(Node node)
    {
        if (node == null) 
            return;
        display(node.left);
        System.out.print(node.data + " ");
        display(node.right);
        
    }
    
    public static Node dele(Node node, int key)
    {
        if(node == null) {
            return node;
        }
        if(key < node.data) {
            node.left = dele(node.left, key);
        }
        else if(key > node.data) {
            node.right = dele(node.right, key);
        } 
        else {
            if(node.left == null) {
                return node.right;
            }
            else if(node.right == null) {
                return node.left;
            } else {
                node.data = helper(node.right);
                node.right = dele(node.right, node.data);
            }
        }
        return node;
    }
    
    public static int helper(Node node) {
        int min = node.data;
        while(node.left != null) {
            min = node.left.data;
            node = node.left;
        }
        return min;
    }
 
    public static Node insert(Node node, int key)
    {
        if (node == null) 
            return new Node(key);

        if (key < node.data) 
            node.left = insert(node.left, key);
        else 
            node.right = insert(node.right, key);
 
        return node;
    }
    
    public static void main(String[] args)
    {
        int n,del;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        root = insert(null, sc.nextInt());
        for(int i = 0;i < n - 1; ++i)
            insert(root, sc.nextInt());
        del = sc.nextInt();
        
        root = dele(root, del);
        display(root);
        sc.close();
    }
}
