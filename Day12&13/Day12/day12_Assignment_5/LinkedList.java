
//Task 5: Removing Duplicates from a Sorted Linked List
package day12_Assignment_5;

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

	// Function to remove duplicates from the sorted linked list
	void removeDuplicates() {
		Node current = head;

		while (current != null && current.next != null) {
			if (current.data == current.next.data) {
				// Skip the next node as it is a duplicate
				current.next = current.next.next;
			} else {
				// Move to the next node
				current = current.next;
			}
		}
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

		llist.append(1);
		llist.append(1);
		llist.append(2);
		llist.append(3);
		llist.append(3);
		llist.append(4);
		llist.append(4);
		llist.append(5);

		System.out.println("Original Linked List:");
		llist.printList();

		llist.removeDuplicates();

		System.out.println("Linked List after removing duplicates:");
		llist.printList();
	}

}

/*
 * Explanation: Node Class: Defines a node in the linked list with a data field
 * and a next pointer. append() Method: Adds a new node to the end of the linked
 * list. printList() Method: Prints the elements of the linked list.
 * removeDuplicates() Method: Initializes a current pointer at the head of the
 * list. Iterates through the list until the end. If current.data is equal to
 * current.next.data, it bypasses the next node by setting current.next to
 * current.next.next. If not, it moves the current pointer to the next node.
 * main() Method: Tests the linked list by adding elements (with duplicates),
 * printing the original list, removing duplicates, and printing the modified
 * list. This approach ensures that duplicates are removed efficiently with a
 * single traversal of the list, maintaining O(n) time complexity and O(1) space
 * complexity.
 */








