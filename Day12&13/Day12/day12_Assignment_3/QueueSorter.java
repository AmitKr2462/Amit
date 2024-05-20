 
/*Task 3: Queue Sorting with Limited Space*/
package day12_Assignment_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueSorter {

	public static void sortQueue(Queue<Integer> queue) {
		Stack<Integer> stack = new Stack<>();

		// New sorted queue to hold the sorted elements
		Queue<Integer> sortedQueue = new LinkedList<>();

		while (!queue.isEmpty()) {
			int minValue = Integer.MAX_VALUE;
			int minIndex = -1;
			int size = queue.size();

			// Find the minimum element and its index
			for (int i = 0; i < size; i++) {
				int current = queue.poll();
				if (current < minValue) {
					minValue = current;
					minIndex = i;
				}
				queue.add(current);
			}

			// Move elements to the stack except the minimum element
			for (int i = 0; i < size; i++) {
				int current = queue.poll();
				if (i != minIndex) {
					stack.push(current);
				}
			}

			// Add the minimum element to the sorted queue
			sortedQueue.add(minValue);

			// Move elements back from the stack to the queue
			while (!stack.isEmpty()) {
				queue.add(stack.pop());
			}
		}

		// Move elements from the sorted queue back to the original queue
		while (!sortedQueue.isEmpty()) {
			queue.add(sortedQueue.poll());
		}
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(5);
		queue.add(1);
		queue.add(3);
		queue.add(2);
		queue.add(4);

		System.out.println("Original Queue: " + queue);
		sortQueue(queue);
		System.out.println("Sorted Queue: " + queue);
	}

}

/*Explanation:
Finding the Minimum Element:

We iterate through the queue to find the minimum element and keep its index.
We use queue.poll() to remove each element and queue.add() to re-add it, ensuring the queue's state remains unchanged.
Transferring Elements:

We transfer all elements except the minimum element to the stack.
The minimum element is directly added to the sortedQueue.
Restoring Elements:

We then move all elements from the stack back to the queue, restoring its original state minus the sorted elements.
Repeat Process:

This process repeats until all elements are moved to the sortedQueue.
Combining Queues:

Finally, we move the elements from the sortedQueue back to the original queue, now in sorted order.
This approach ensures that we only use one additional stack for auxiliary storage, maintaining limited space usage while sorting the queue*/


