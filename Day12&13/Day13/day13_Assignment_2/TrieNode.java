package day13_Assignment_2;

public class TrieNode {

	TrieNode[] children;
	boolean isEndOfWord;

	public TrieNode() {
		this.children = new TrieNode[26]; // Assuming only lowercase a-z letters
		this.isEndOfWord = false;
	}

}
