package br.edu.ifsul.ed.grafos;


public class exercicio1main {
	public static void main(String[] args) {
		System.out.println(">>> Grafo Direcionado");
		 Graph graph = new Graph(true);

	        graph.addEdge("a", "b");
	        graph.addEdge("a", "e");
	        graph.addEdge("a", "f");
	        graph.addEdge("b", "c");
	        graph.addEdge("c", "d");
	        graph.addEdge("e", "g");
	        graph.addEdge("e", "d");
	        graph.addEdge("f", "h");
	        graph.addEdge("h", "d");

	        System.out.println("===== DFS a partir de 'a' =====");
	        System.out.println(graph.depthFirstSearch("a"));
	}
}
