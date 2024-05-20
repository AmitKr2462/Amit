/*Task 8: Circular Queue Binary Search
Consider a circular queue (implemented using a fixed-size array) where the elements are sorted but have been rotated
at an unknown index. Describe an approach to perform a binary search for a given element within this circular queue.*/

package day12_Assignment_8;

public class CircularQueueBinarySearch {

	public static int circularArrayBinarySearch(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			// Check if mid is the target
			if (arr[mid] == target) {
				return mid;
			}

			// Determine which half is sorted
			if (arr[low] <= arr[mid]) {
				// Left half is sorted
				if (arr[low] <= target && target < arr[mid]) {
					high = mid - 1; // Target is in the left half
				} else {
					low = mid + 1; // Target is in the right half
				}
			} else {
				// Right half is sorted
				if (arr[mid] < target && target <= arr[high]) {
					low = mid + 1; // Target is in the right half
				} else {
					high = mid - 1; // Target is in the left half
				}
			}
		}

		// Target not found
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 13, 18, 25, 2, 8, 10 };
		int target = 8;

		int index = circularArrayBinarySearch(arr, target);
		if (index != -1) {
			System.out.println("Element " + target + " found at index " + index);
		} else {
			System.out.println("Element " + target + " not found in the array.");
		}
	}

}

/*
 * Steps for Binary Search in a Circular Queue: Initialize Pointers: Set low to
 * the start and high to the end of the array. Find Midpoint: Calculate the
 * midpoint of the current range. Check Midpoint: If the midpoint element is the
 * target, return the index. Determine Sorted Half: Check if the left half is
 * sorted by comparing the low and mid elements. If the left half is sorted,
 * check if the target lies within this range. Otherwise, the right half must be
 * sorted; check if the target lies within this range. Adjust Pointers:
 * Depending on the sorted half and where the target lies, adjust low and high
 * to narrow down the search range. Repeat: Continue the process until the
 * target is found or the search range is exhausted.
 */
