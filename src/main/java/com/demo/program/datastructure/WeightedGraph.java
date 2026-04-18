package com.demo.program.datastructure;

import java.util.LinkedList;

public class WeightedGraph {
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        LinkedList<Edge>[] adjacencyList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new LinkedList[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        public void addEgde(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencyList[source].addFirst(edge); //for directed graph
        }

        public void printGraph() {
            for (int i = 0; i < vertices; i++) {
                LinkedList<Edge> list = adjacencyList[i];
                for (int j = 0; j < list.size(); j++) {
                    System.out.println("vertex-" + i + " is connected to " +
                            list.get(j).destination + " with weight " + list.get(j).weight);
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEgde(0, 1, 4);
        graph.addEgde(0, 2, 3);
        graph.addEgde(1, 3, 2);
        graph.addEgde(1, 2, 5);
        graph.addEgde(2, 3, 7);
        graph.addEgde(3, 4, 2);
        graph.addEgde(4, 0, 4);
        graph.addEgde(4, 1, 4);
        graph.addEgde(4, 5, 6);
        graph.printGraph();
    }
}

//-----------------------------------------------------------------------------
//        Output
//-----------------------------------------------------------------------------
//        vertex-0 is connected to 2 with weight 3
//        vertex-0 is connected to 1 with weight 4
//        vertex-1 is connected to 2 with weight 5
//        vertex-1 is connected to 3 with weight 2
//        vertex-2 is connected to 3 with weight 7
//        vertex-3 is connected to 4 with weight 2
//        vertex-4 is connected to 5 with weight 6
//        vertex-4 is connected to 1 with weight 4
//        vertex-4 is connected to 0 with weight 4