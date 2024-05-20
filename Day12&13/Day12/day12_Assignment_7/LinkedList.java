
//Task 7: Merging Two Sorted Linked Lists
package day12_Assignment_7;

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

	// Function to merge two sorted linked lists
	public static Node mergeTwoLists(Node l1, Node l2) {
		// Dummy node to serve as the start of the merged list
		Node dummy = new Node(0);
		Node current = dummy;

		// Traverse both lists and compare nodes
		while (l1 != null && l2 != null) {
			if (l1.data <= l2.data) {
				current.next = l1;
				l1 = l1.next;
			} else {
				current.next = l2;
				l2 = l2.next;
			}
			current = current.next;
		}

		// Append remaining nodes of l1 or l2
		if (l1 != null) {
			current.next = l1;
		} else {
			current.next = l2;
		}

		// The merged list starts from the next node of dummy
		return dummy.next;
	}

	// Function to print the linked list
	public void printList(Node node) {
		Node current = node;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	// Main method to test the above functions
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.head = new Node(1);
		list1.head.next = new Node(3);
		list1.head.next.next = new Node(5);

		LinkedList list2 = new LinkedList();
		list2.head = new Node(2);
		list2.head.next = new Node(4);
		list2.head.next.next = new Node(6);

		System.out.println("List 1:");
		list1.printList(list1.head);

		System.out.println("List 2:");
		list2.printList(list2.head);

		Node mergedHead = mergeTwoLists(list1.head, list2.head);

		System.out.println("Merged List:");
		LinkedList mergedList = new LinkedList();
		mergedList.printList(mergedHead);
	}

}
