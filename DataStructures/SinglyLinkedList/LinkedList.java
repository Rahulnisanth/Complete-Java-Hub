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
		add(10);
		add(20);
		add(30);
		add(40);
		int position = sc.nextInt(); //position to insert
		int value = sc.nextInt(); //value to insert
		if(position < 1 || position >= listSize) {
			System.out.println("Invalid position at " + position);
		} else {
			insert(value, position);
			display();
		}
		sc.close();
	}
}
