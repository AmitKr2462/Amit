
//Task 6: Searching for a Sequence in a Stack

package day12_Assignment_6;

import java.util.Stack;

public class StackSequenceChecker {

	public static boolean isSequencePresent(Stack<Integer> stack, int[] sequence) {
		if (sequence.length == 0) {
			return true;
		}

		Stack<Integer> tempStack = new Stack<>();
		int sequenceIndex = 0;
		boolean sequenceFound = false;

		while (!stack.isEmpty()) {
			int current = stack.pop();
			tempStack.push(current);

			if (current == sequence[sequenceIndex]) {
				sequenceIndex++;

				if (sequenceIndex == sequence.length) {
					sequenceFound = true;
					break;
				}
			} else {

				sequenceIndex = 0;
			}
		}

		while (!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}

		return sequenceFound;
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		int[] sequence1 = { 3, 4, 5 };
		int[] sequence2 = { 2, 3, 5 };

		System.out.println("Is sequence {3, 4, 5} present? " + isSequencePresent(stack, sequence1)); // true
		System.out.println("Is sequence {2, 3, 5} present? " + isSequencePresent(stack, sequence2)); // false
	}

}
