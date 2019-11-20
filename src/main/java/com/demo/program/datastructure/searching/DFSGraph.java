package com.demo.program.datastructure.searching;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class DFSGraph {	
	
	static class Node {
		int data;
		boolean visited;
		List<Node> neighbourNodes;
		
		public Node(int data) {
			this.data = data;
			this.neighbourNodes = new ArrayList<>();
		}
		
		public void addNeighbour(Node node) {
			this.neighbourNodes.add(node);
		}
	}
	
	
	// DFS using recursive method call
	public void dfsRecursive(Node parentNode) {
		System.out.print(parentNode.data + " --> ");
		
		parentNode.visited = true;

		for (Node node : parentNode.neighbourNodes) {
			if(null != node && !node.visited)
				dfsRecursive(node);
		}		
	}

	
	// DFS using stack
	public void dfsUsingStack(Node parentNode) {
		Stack<Node> stack = new Stack<>();		
		stack.add(parentNode);
		
		while (!stack.isEmpty()) {			
			Node currentNode = stack.pop();
			
			if(!currentNode.visited) {
				currentNode.visited = true;
				System.out.print(currentNode.data + " --> ");
			}
			
			for (Node node : currentNode.neighbourNodes) {
				if(null != node && !node.visited) 
					stack.add(node);
			}
		}
	}
	
	
	public static void main(String[] args) {

		System.out.println("\nThe DFS traversal of the graph is :");
		DFSGraph bfsGraph = new DFSGraph();
		bfsGraph.dfsRecursive(getGraphData());
		
		System.out.println("\n-------------------------------");
		bfsGraph.dfsUsingStack(getGraphData());
	}
	
	public static Node getGraphData() {
		Node node40 = new Node(40);
		Node node10 = new Node(10);
		Node node20 = new Node(20);
		Node node30 = new Node(30);
		Node node60 = new Node(60);
		Node node50 = new Node(50);
		Node node70 = new Node(70);

		node40.addNeighbour(node10);	// directed edge form 40 to 10
		node40.addNeighbour(node20);	// directed edge form 40 to 20
		node10.addNeighbour(node30);	// directed edge form 10 to 30
		node20.addNeighbour(node10);	// directed edge form 20 to 10
		node20.addNeighbour(node30);	// directed edge form 20 to 30
		node20.addNeighbour(node60);	// directed edge form 20 to 60
		node20.addNeighbour(node50);	// directed edge form 20 to 50
		node30.addNeighbour(node60);	// directed edge form 30 to 60
		node60.addNeighbour(node70);	// directed edge form 60 to 70
		node50.addNeighbour(node70);	// directed edge form 50 to 70
		
		return node40;
	}
}

/*
 * 	40	--->	20	--->	50	\
 * 	|		_/	|	\_			 \ -- >  70
 * 	|	 _/		|		\_		 / -- >
 * 	v v-		v			-v  /
 * 	10	--->	30	-->		60
 *
 */


// Output ::
//
// The DFS traversal of the graph is :
// 40 --> 10 --> 30 --> 60 --> 70 --> 20 --> 50 -->
// -------------------------------
// 40 --> 20 --> 50 --> 70 --> 60 --> 30 --> 10 --> 
