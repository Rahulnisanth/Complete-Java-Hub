import java.util.*;

// Node 
class Node {
	int data;
	Node next;
	Node(){
		this.next = null;
	}
	Node(int d)
	{
		data = d;
		next = null;
	}
}
// Linked - List :
public class LinkedList {

	static Node head, tail; //by default initialized to null
	static int listSize = 0;
	// Adding elements :
	public static void add(int data) {
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
	public static void insert(int value,int position)
	{
		Node newNode = new Node(value);
		newNode.next = null;
		if(position == 1) {
			newNode.next = head;
			head = newNode;
			listSize++;
		} else {
			Node temp = head;
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
	public static boolean delete(int val) {
		Node temp = head;
		Node prev = null;
		// case in first node :
		if(temp != null && temp.data == val) {
			head = temp.next;
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
	// Display :
	public static void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			add(sc.nextInt());
		}
		int k = sc.nextInt();
		if(delete(k)) 
			display();
		sc.close();
	}
}
