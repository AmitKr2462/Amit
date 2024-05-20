/*Stack Sorting In-Place*/
package day12_Assignment_4;

import java.util.Stack;

public class StackSorter {

	public static void sortStack(Stack<Integer> stack) {
		Stack<Integer> tempStack = new Stack<>();

		while (!stack.isEmpty()) {
			int current = stack.pop();

			// Transfer elements from tempStack to stack to find the correct position for
			// current
			while (!tempStack.isEmpty() && tempStack.peek() > current) {
				stack.push(tempStack.pop());
			}

			// Place the current element in the correct position in tempStack
			tempStack.push(current);
		}

		// Transfer the sorted elements back to the original stack
		while (!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(34);
		stack.push(3);
		stack.push(31);
		stack.push(98);
		stack.push(92);
		stack.push(23);

		System.out.println("Original Stack: " + stack);
		sortStack(stack);
		System.out.println("Sorted Stack: " + stack);
	}

}
