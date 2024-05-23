
/*Task 2: Kruskal’s Algorithm for MST
Implement Kruskal’s algorithm to find the minimum spanning tree of a given connected,
undirected graph with non-negative edge weights*/

package day16_Assignment_2;

import java.util.*;

public class KruskalsAlgorithm {

	private int V; // Number of vertices in the graph
	private List<Edge> edges; // List of all edges in the graph

	public KruskalsAlgorithm(int v) {
		V = v;
		edges = new ArrayList<>();
	}

	// Method to add an edge to the graph
	public void addEdge(int src, int dest, int weight) {
		edges.add(new Edge(src, dest, weight));
	}

	// Method to find the parent of a given node with path compression
	private int find(Subset[] subsets, int i) {
		if (subsets[i].parent != i) {
			subsets[i].parent = find(subsets, subsets[i].parent);
		}
		return subsets[i].parent;
	}

	// Method to perform union of two subsets using rank
	private void union(Subset[] subsets, int x, int y) {
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);

		// Attach smaller rank tree under root of higher rank tree
		if (subsets[xroot].rank < subsets[yroot].rank) {
			subsets[xroot].parent = yroot;
		} else if (subsets[xroot].rank > subsets[yroot].rank) {
			subsets[yroot].parent = xroot;
		} else {
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}

	// Method to implement Kruskal's algorithm and return the MST
	public List<Edge> kruskalMST() {
		List<Edge> result = new ArrayList<>(); // Store the resulting MST
		Collections.sort(edges, Comparator.comparingInt(o -> o.weight)); // Sort all edges by weight

		Subset[] subsets = new Subset[V]; // Create V subsets with single elements
		for (int v = 0; v < V; ++v) {
			subsets[v] = new Subset(v, 0);
		}

		int i = 0; // Index variable for sorted edges
		int e = 0; // Index variable for result[]

		// Number of edges to be taken is equal to V-1
		while (e < V - 1 && i < edges.size()) {
			Edge nextEdge = edges.get(i++); // Pick the smallest edge
			int x = find(subsets, nextEdge.src);
			int y = find(subsets, nextEdge.dest);

			// If including this edge doesn't cause a cycle
			if (x != y) {
				result.add(nextEdge); // Include it in the result
				e++;
				union(subsets, x, y); // Union the two vertices
			}
		}

		return result; // Return the resulting MST
	}

	public static void main(String[] args) {
		int V = 4; // Number of vertices
		KruskalsAlgorithm graph = new KruskalsAlgorithm(V);

		// Add edges to the graph
		graph.addEdge(0, 1, 10);
		graph.addEdge(0, 2, 6);
		graph.addEdge(0, 3, 5);
		graph.addEdge(1, 3, 15);
		graph.addEdge(2, 3, 4);

		// Get the MST
		List<Edge> mst = graph.kruskalMST();

		// Print the MST
		System.out.println("Edges in the Minimum Spanning Tree:");
		for (Edge edge : mst) {
			System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
		}
	}

}

class Edge {
	int src, dest, weight;

	public Edge(int src, int dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}
}

// Define the Subset class to help with union-find operations
class Subset {
	int parent, rank;

	public Subset(int parent, int rank) {
		this.parent = parent;
		this.rank = rank;
	}
}
