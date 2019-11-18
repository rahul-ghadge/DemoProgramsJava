package com.demo.program.datastructure.searching;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraph {

	private Queue<Node> queue;
	static ArrayList<Node> nodes = new ArrayList<Node>();

	public BFSGraph() {
		queue = new LinkedList<Node>();
	}
	
	static class Node {
		int data;
		boolean visited;
		List<Node> neighbours;

		Node(int data) {
			this.data = data;
			this.neighbours = new ArrayList<>();
		}

		public void addneighbours(Node neighbourNode) {
			this.neighbours.add(neighbourNode);
		}

		public List<Node> getNeighbours() {
			return neighbours;
		}

		public void setNeighbours(List<Node> neighbours) {
			this.neighbours = neighbours;
		}
	}


	public void bfs(Node node) {
		queue.add(node);
		node.visited = true;
		while (!queue.isEmpty()) { 			// check queue is not empty
			Node element = queue.remove(); 	// remove element from queue(FIFO)
			System.out.print(element.data + " --> ");
			List<Node> neighbours = element.getNeighbours();
			for (int i = 0; i < neighbours.size(); i++) {
				Node n = neighbours.get(i);
				if (n != null && !n.visited) {	// if node is not null and not
					queue.add(n);				// visited then add in Queue
					n.visited = true;			// and mark as visited true
				}
			}
		}
	}

	public static void main(String arg[]) {

		Node node40 = new Node(40);
		Node node10 = new Node(10);
		Node node20 = new Node(20);
		Node node30 = new Node(30);
		Node node60 = new Node(60);
		Node node50 = new Node(50);
		Node node70 = new Node(70);

		node40.addneighbours(node10);	// directed edge form 40 to 10
		node40.addneighbours(node20);	// directed edge form 40 to 20
		node10.addneighbours(node30);	// directed edge form 10 to 30
		node20.addneighbours(node10);	// directed edge form 20 to 10
		node20.addneighbours(node30);	// directed edge form 20 to 30
		node20.addneighbours(node60);	// directed edge form 20 to 60
		node20.addneighbours(node50);	// directed edge form 20 to 50
		node30.addneighbours(node60);	// directed edge form 30 to 60
		node60.addneighbours(node70);	// directed edge form 60 to 70
		node50.addneighbours(node70);	// directed edge form 50 to 70
		System.out.println("\nThe BFS traversal of the graph is :");
		BFSGraph bfsGraph = new BFSGraph();
		bfsGraph.bfs(node40);
	}
}

/*
 * 	40	--->	20	--->	50	\
 * 	|		  _/	|	\_			     \ -- >   70
 * 	|	  _/		|		\_		     / -- >
 * 	v  v-		  v			-v      /
 * 	10	--->	30	--->	60
 *
 */
