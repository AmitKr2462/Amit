/*Task 1: String Operations
Write a method that takes two strings, concatenates them, reverses the
result, and then extracts the middle substring of the given length. 
Ensure your method handles edge cases, such as an empty string or a 
substring length larger than*/

package day16_Assignment_1;

public class StringOperations {

	public static String concatReverseAndExtract(String str1, String str2, int length) {

		String concatenated = str1 + str2;

		String reversed = new StringBuilder(concatenated).reverse().toString();

		if (length >= reversed.length()) {
			return reversed;
		}

		int startIndex = (reversed.length() - length) / 2;

		return reversed.substring(startIndex, startIndex + length);
	}

	public static void main(String[] args) {
		// Test cases
		System.out.println(concatReverseAndExtract("hello", "world", 5));
		System.out.println(concatReverseAndExtract("abc", "def", 4));
		System.out.println(concatReverseAndExtract("abc", "", 2));
		System.out.println(concatReverseAndExtract("", "xyz", 1));
		System.out.println(concatReverseAndExtract("a", "b", 5));
	}

}
