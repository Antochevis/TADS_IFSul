package br.edu.ifsul.ed.grafos;

public class exercicio3main {
	 public static void main(String[] args) {

	        WeightedGraph graph = new WeightedGraph(false);
	        
	        graph.addEdge("x", "z", 12);
	        graph.addEdge("x", "v", 30);

	        graph.addEdge("v", "r", 17);

	        graph.addEdge("z", "v", 35);
	        graph.addEdge("z", "r", 25);
	        graph.addEdge("z", "s", 20);

	        graph.addEdge("s", "r", 7);
	        graph.addEdge("s", "t", 12);
	        graph.addEdge("s", "u", 10);

	        graph.addEdge("t", "u", 5);

	        graph.addEdge("u", "r", 15);
	        graph.addEdge("u", "v", 15);

	        var result = graph.dijkstraWithPredecessor("x", "t");

	        @SuppressWarnings("unchecked")
	        var distances = (java.util.Map<String, Integer>) result.get("distances");

	        System.out.println("Menor custo de x até t: " + distances.get("t"));
	        System.out.println("Menor caminho: " + graph.getShortestPath("x", "t"));
	    }
}
