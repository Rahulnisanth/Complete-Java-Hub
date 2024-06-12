package DLL;
import java.util.*;

class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DLL {
    static Node head;
    static int list_size = 0;

    public void insert(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        return;
    }

    public void insert_between(int value, int position) {
        Node new_node = new Node(value);
        Node fast = head;
        Node slow = null;
        while(--position != 0) {
            slow = fast;
            fast = fast.next;
        }
        new_node.next = fast;
        fast.prev = new_node;
        slow.next = new_node;
        new_node.prev = slow;
        return;
    }

    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data +  " ");
            temp = temp.next;
        }
        return;
    }

    public void delete(int delVal) {
        Node temp = head;
        Node prev = null;
        while(--delVal != 0) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
        temp.next.prev = temp.prev;
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLL obj = new DLL();
        // Adding elements :
        for(int i = 0;i < 3; i++) {
            obj.insert(sc.nextInt());
        }
        // Inserting at position 2 :
        int k = sc.nextInt();
        obj.insert_between(k, 2);
        // Deleting the specific position :
        obj.delete(3);
        obj.display();
        sc.close();
    }
}
