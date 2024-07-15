import java.util.*;
class Node {
	int data;
	Node next;
	Node(int d) {
		data = d;
		next = null;
	}
}

public class FindLoop {
	Node head; 

	boolean detect_loop() {
		Node node = head;
		HashSet<Integer> set =new HashSet<>();
		while(node != null) {
			if(set.add(node.data) == false) 
				return true;
			node = node.next;
		}
		return false;
	}

	/* Inserts a new Node at front of the list. */
	public void add(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		FindLoop obj = new FindLoop();
		for (int i = 0; i < n; i++) {
			obj.add(sc.nextInt());
		}
		if(obj.detect_loop())
			System.out.println("LOOP");
		else
			System.out.println("NO LOOP");
		sc.close();
	}
}