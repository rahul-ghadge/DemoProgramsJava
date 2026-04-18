package com.demo.program.datastructure.searching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BFSShortestPath {

	private Map<String, Node> nodes = new HashMap<>();
	
	static class Node {

		public String nodeName;
		public List<Node> neighbourNodes;
		public boolean visited;

		public Node(String node) {
			nodeName = node;
			neighbourNodes = new ArrayList<>();
		}

		public void addNeighbour(Node node) {
			neighbourNodes.add(node);
		}
	}
	
	
	public void addEdge(String nodeName1, String nodeName2) {
//		Node nodeOne = nodes.getOrDefault(nodeName1, new Node(nodeName1)); 		// get node if already present
//		if (null == nodeOne)
//			nodeOne = new Node(nodeName1); 			// if node not present then add new node

//		Node nodeTwo = nodes.getOrDefault(nodeName2, new Node(nodeName2));
//		if (null == nodeTwo)
//			nodeTwo = new Node(nodeName2);

		Node nodeOne = nodes.getOrDefault(nodeName1, new Node(nodeName1));
		Node nodeTwo = nodes.getOrDefault(nodeName2, new Node(nodeName2));

		nodeOne.addNeighbour(nodeTwo); 				// add edge between node one and two
		nodeTwo.addNeighbour(nodeOne); 				// add edge between node two and one

		nodes.put(nodeName1, nodeOne);
		nodes.put(nodeName2, nodeTwo);
	}
	
	
	public List<String> shortestPath(String startNodeName, String lastNodeName) {
		
		List<Node> tempNodes = new ArrayList<>();
		Map<String, String> parentNodes = new HashMap<>();
		
		tempNodes.add(nodes.get(startNodeName));	// add starting node in temp nodes
		parentNodes.put(startNodeName, null);		// add starting node in parent nodes
		
		while (tempNodes.size() > 0) {

			Node currentNode = tempNodes.remove(0);		// get first node from temp list
			for (Node neighbourNode : currentNode.neighbourNodes) {

				// if node is not visited and not present in parent nodes
				if (null != neighbourNode
						&& !parentNodes.containsKey(neighbourNode.nodeName)	// node should not present in parent nodes map
						&& !neighbourNode.visited) {							// node is not visited yet

					tempNodes.add(neighbourNode);									// add node if above condition satisfies
					parentNodes.put(neighbourNode.nodeName, currentNode.nodeName);	// put neighbour node as parent node
					neighbourNode.visited = true;									// set as visited true

					if (neighbourNode.nodeName.equals(lastNodeName)) { 	// if neighbour node is last node which we are looking
						List<String> path = new ArrayList<>();				// then return path from first node to last node
						while (null != lastNodeName) {
							path.add(0, lastNodeName);						// add each new node at 0th position
							lastNodeName = parentNodes.get(lastNodeName); 	// update last node with connected node
						}
						return path;
					}
				}
			}
//			tempNodes.remove(0);
		}		
		return null;
	}


	public static void main(String[] args) {
		BFSShortestPath graph = constructGraph();
		List<String> result = graph.shortestPath("A", "F");
		System.out.println(result);

		graph = constructGraph();
		result = graph.shortestPath("A", "E");
		System.out.println(result);
	}
	
	
	private static BFSShortestPath constructGraph() {
		BFSShortestPath graph = new BFSShortestPath();
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("B", "C");
		graph.addEdge("B", "D");
		graph.addEdge("C", "D");
		graph.addEdge("C", "E");
		graph.addEdge("D", "E");
		graph.addEdge("D", "F");
		
		return graph;
	}

}
