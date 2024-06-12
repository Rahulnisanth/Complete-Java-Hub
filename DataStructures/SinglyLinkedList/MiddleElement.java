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
public class MiddleElement {

	static Node head, tail;
	// Adding elements :
	public void add(int data) {
		Node temp = new Node(data);
		temp.next = null;
		if(head == null) head = tail = temp;
		else {
				tail.next = temp;
				tail = temp;
		}
	}
	// Display :
	public void display_middle(Node node, int position) {
		Node temp = node;
        int track = -1;
		while (temp != null && ++track != position) {
			temp = temp.next;
		}
		System.out.print(temp.data);
	}
	
	public static void main(String[] args)
	{
		MiddleElement obj = new MiddleElement();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0;i < n; i++) {
			obj.add(sc.nextInt());
		}
		obj.display_middle(head, n / 2);
		sc.close();
	}
}
