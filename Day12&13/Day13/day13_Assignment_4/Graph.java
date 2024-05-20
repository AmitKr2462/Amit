/*Task 4: Graph Edge Addition Validation
Given a directed graph, write a function that adds an edge between two nodes and then checks if
the graph still has no cycles. If a cycle is created, the edge should not be added.*/

package day13_Assignment_4;

import java.util.*;

public class Graph {

	private Map<Integer, List<Integer>> adjacencyList;

	public Graph() {
		adjacencyList = new HashMap<>();
	}

	public boolean addEdge(int source, int destination) {
		if (!adjacencyList.containsKey(source)) {
			adjacencyList.put(source, new ArrayList<>());
		}
		if (!adjacencyList.containsKey(destination)) {
			adjacencyList.put(destination, new ArrayList<>());
		}

		adjacencyList.get(source).add(destination);

		if (hasCycle()) {

			adjacencyList.get(source).remove((Integer) destination);
			return false;
		}
		return true;
	}

	private boolean hasCycle() {
		Set<Integer> visited = new HashSet<>();
		Set<Integer> recStack = new HashSet<>();

		for (Integer node : adjacencyList.keySet()) {
			if (hasCycleUtil(node, visited, recStack)) {
				return true;
			}
		}
		return false;
	}

	private boolean hasCycleUtil(int node, Set<Integer> visited, Set<Integer> recStack) {
		if (recStack.contains(node)) {
			return true;
		}
		if (visited.contains(node)) {
			return false;
		}
		visited.add(node);
		recStack.add(node);

		for (Integer neighbor : adjacencyList.get(node)) {
			if (hasCycleUtil(neighbor, visited, recStack)) {
				return true;
			}
		}

		recStack.remove(node);
		return false;
	}

	public static void main(String[] args) {
		Graph graph = new Graph();
		System.out.println(graph.addEdge(1, 2));
		System.out.println(graph.addEdge(2, 3));
		System.out.println(graph.addEdge(3, 4));
		System.out.println(graph.addEdge(4, 2));
	}

}
