import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

public class BSTInsertion
{
    static Node root;

    public static void display(Node node)
    {
        if(node == null) {
            return;
        } else {
            display(node.left);
            display(node.right);
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

        for(int i = 0;i < n; ++i)
            insert(root,sc.nextInt());

        display(root);
        
        sc.close();
    }

}
