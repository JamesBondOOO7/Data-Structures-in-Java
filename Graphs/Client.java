package graphs;

import java.util.HashMap;

public class Client {

	public static void main(String[] args) {
		
		Graph graph = new Graph();
		
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		
		graph.addEdge("A", "B", 2);
		graph.addEdge("A", "D", 3);
		graph.addEdge("B", "C", 1);
		graph.addEdge("C", "D", 8);
		graph.addEdge("D", "E", 10);
		graph.addEdge("E", "F", 45);
		graph.addEdge("E", "G", 7);
		graph.addEdge("F", "G", 18);
		
		graph.display();
		
		System.out.println(graph.numVertex());
		System.out.println(graph.numEdges());
		
		System.out.println(graph.containsEdge("A", "C"));
		System.out.println(graph.containsEdge("E", "F"));
		
		graph.removeEdge("A", "B");
		graph.display();
		
		graph.removeVertex("F");
		graph.display();
		
		graph.addVertex("F");// Isolated edge
		graph.display();
		
		graph.addEdge("A", "F",10);
		graph.display();
		
		System.out.println(graph.hasPath("A", "G", new HashMap<String , Boolean>()));
		
		System.out.println(graph.BFS("A", "G"));
		System.out.println(graph.DFS("A","G"));
		graph.BFT();
		graph.DFT();
		
		System.out.println("Cyclic : " + graph.isCyclic());
		System.out.println("Connected : " + graph.isConnected());
		System.out.println("Tree : " + graph.isTree());
		graph.addEdge("B", "F", 5);
		System.out.println("Cyclic : " + graph.isCyclic());
		System.out.println("Connected : " + graph.isConnected());
		System.out.println("Tree : " + graph.isTree());
//		System.out.println(graph.getComponenets());
//		graph.addVertex("H");
//		System.out.println(graph.getComponenets());
		
		graph.prims().display();
		
		Graph graph1 = new Graph();
		
		graph1.addVertex("A");
		graph1.addVertex("B");
		graph1.addVertex("C");
		graph1.addVertex("D");
		graph1.addVertex("E");
		graph1.addVertex("F");
		graph1.addVertex("G");
		graph1.addVertex("H");
		
		graph1.addEdge("A", "B", 2);
		graph1.addEdge("A", "D", 6);
		graph1.addEdge("B", "C", 3);
		graph1.addEdge("C", "D", 1);
		graph1.addEdge("D", "E", 8);
		graph1.addEdge("E", "F", 5);
		graph1.addEdge("E", "G", 4);
		graph1.addEdge("F", "G", 7);
		
		graph1.prims().display();
		System.out.println(graph1.dijkstra("A"));
	}

}
