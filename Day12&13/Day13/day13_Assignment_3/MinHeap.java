/*Task 3: Implementing Heap Operations
Code a min-heap in C# with methods for insertion, deletion, and fetching the minimum element.
Ensure that the heap property is maintained after each operation.""
		+ "
*/
package day13_Assignment_3;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {

	private List<Integer> heap;

	public MinHeap() {
		heap = new ArrayList<>();
	}

	
	public void insert(int element) {
		heap.add(element);
		heapifyUp(heap.size() - 1);
	}

	
	public int getMin() {
		if (heap.isEmpty()) {
			throw new IllegalStateException("Heap is empty");
		}
		return heap.get(0);
	}

	
	public int deleteMin() {
		if (heap.isEmpty()) {
			throw new IllegalStateException("Heap is empty");
		}
		int minElement = heap.get(0);
		int lastElement = heap.remove(heap.size() - 1);
		if (!heap.isEmpty()) {
			heap.set(0, lastElement);
			heapifyDown(0);
		}
		return minElement;
	}

	
	private void heapifyUp(int index) {
		while (index > 0) {
			int parentIndex = (index - 1) / 2;
			if (heap.get(index) >= heap.get(parentIndex)) {
				break;
			}
			swap(index, parentIndex);
			index = parentIndex;
		}
	}

	
	private void heapifyDown(int index) {
		int size = heap.size();
		while (index < size) {
			int leftChildIndex = 2 * index + 1;
			int rightChildIndex = 2 * index + 2;
			int smallest = index;

			if (leftChildIndex < size && heap.get(leftChildIndex) < heap.get(smallest)) {
				smallest = leftChildIndex;
			}
			if (rightChildIndex < size && heap.get(rightChildIndex) < heap.get(smallest)) {
				smallest = rightChildIndex;
			}
			if (smallest == index) {
				break;
			}
			swap(index, smallest);
			index = smallest;
		}
	}

	
	private void swap(int i, int j) {
		int temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}

	
	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap();
		minHeap.insert(3);
		minHeap.insert(2);
		minHeap.insert(1);
		minHeap.insert(5);
		minHeap.insert(4);

		System.out.println("Min element: " + minHeap.getMin()); // Output: 1

		System.out.println("Deleted Min element: " + minHeap.deleteMin()); // Output: 1
		System.out.println("New Min element: " + minHeap.getMin()); // Output: 2

		System.out.println("Deleted Min element: " + minHeap.deleteMin()); // Output: 2
		System.out.println("New Min element: " + minHeap.getMin()); // Output: 3
	}

}
