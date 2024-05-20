/*Task 2: Trie for Prefix Checking
Implement a trie data structure in C# that supports insertion of strings and provides a method to check
if a given string is a prefix of any word in the trie.*/
package day13_Assignment_2;

public class Trie {

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Method to insert a word into the trie
	public void insert(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			int index = c - 'a';
			if (node.children[index] == null) {
				node.children[index] = new TrieNode();
			}
			node = node.children[index];
		}
		node.isEndOfWord = true;
	}

	// Method to check if there is any word in the trie that starts with the given
	// prefix
	public boolean startsWith(String prefix) {
		TrieNode node = root;
		for (char c : prefix.toCharArray()) {
			int index = c - 'a';
			if (node.children[index] == null) {
				return false;
			}
			node = node.children[index];
		}
		return true;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();

		trie.insert("apple");
		trie.insert("app");
		trie.insert("bat");
		trie.insert("ball");

		System.out.println(trie.startsWith("app")); // Output: true
		System.out.println(trie.startsWith("bat")); // Output: true
		System.out.println(trie.startsWith("bal")); // Output: true
		System.out.println(trie.startsWith("cat")); // Output: false
	}

}
