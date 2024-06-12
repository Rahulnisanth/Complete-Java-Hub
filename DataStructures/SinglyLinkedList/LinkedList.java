import java.util.*;

// Node 
class Node {
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}
// Linked - List :
public class LinkedList {

	static Node head, tail;
	static int listSize = 0;
	// Adding elements :
	public void add(int data) {
		Node temp = new Node(data);
		temp.next = null;
		if(head == null) head = tail = temp;
		else {
			tail.next = temp;
			tail = temp;
		}
		listSize++;
	}
	// Inserting at specific position :
	public void insert(Node node, int value, int position)
	{
		Node newNode = new Node(value);
		newNode.next = null;
		if(position == 1) {
			newNode.next = node;
			node = newNode;
			listSize++;
		} else {
			Node temp = node;
			while(--position > 1) {
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;
			listSize++;
		}
        return;
	}
	// Deletion :
	public boolean delete(Node node, int val) {
		Node temp = node;
		Node prev = null;
		// case in first node :
		if(temp != null && temp.data == val) {
			node = temp.next;
			return true;
		}
		// Case in middle & end :
		while(temp != null && temp.data != val) {
			prev = temp;
			temp = temp.next;
		} if(temp == null) {
			System.out.println(val + " Not in list");
			return false;
		} 
		prev.next = temp.next;
		return true;
	}
	// Reversal :
	public void reverse(Node node) {
		Node prev = null;
		Node current = node;
		Node post = null;
		while(current != null) {
			post = current.next;  
			current.next = prev;  
			prev = current;       
			current = post;
		}
		display(prev);
	}
	// Display :
	public void display(Node node) {
		Node temp = node;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		LinkedList sll = new LinkedList();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0;i < n; i++) {
			sll.add(sc.nextInt());
		}
		// int k = sc.nextInt();
		// if(sll.delete(head, k)) 
		sll.reverse(head);
		// sll.display(head);
		sc.close();
	}
}
