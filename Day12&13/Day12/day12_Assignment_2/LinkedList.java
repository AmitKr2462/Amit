//Task 2: Linked List Middle Element Search
package day12_Assignment_2;

public class LinkedList {

	Node head; // head of the list

	// Node class
	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	// Function to find the middle of the linked list
	void printMiddle() {
		Node slow = head;
		Node fast = head;

		// Traverse the list
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// slow pointer is now at the middle
		System.out.println("The middle element is: " + slow.data);
	}

	// Function to add a new node at the end
	public void append(int new_data) {
		Node new_node = new Node(new_data);

		if (head == null) {
			head = new Node(new_data);
			return;
		}

		new_node.next = null;
		Node last = head;
		while (last.next != null) {
			last = last.next;
		}
		last.next = new_node;
		return;
	}

	// Function to print the linked list
	public void printList() {
		Node tnode = head;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
		System.out.println();
	}

	// Main method to test the above functions
	public static void main(String[] args) {
		LinkedList llist = new LinkedList();

		for (int i = 1; i <= 5; i++) {
			llist.append(i);
			llist.printList();
			llist.printMiddle();
		}
	}

}
