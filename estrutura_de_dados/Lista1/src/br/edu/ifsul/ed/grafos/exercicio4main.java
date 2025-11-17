package br.edu.ifsul.ed.grafos;

import java.util.*;

public class exercicio4main {
	public static void main(String[] args) {

        WeightedGraph graph = new WeightedGraph(false);

        graph.addEdge("A", "E", 3);
        graph.addEdge("A", "C", 2);

        graph.addEdge("C", "D", 3);
        graph.addEdge("C", "G", 2);

        graph.addEdge("D", "E", 1);
        graph.addEdge("D", "F", 4);

        graph.addEdge("G", "H", 4);

        graph.addEdge("E", "F", 6);
        graph.addEdge("E", "B", 5);

        graph.addEdge("F", "H", 7);

        graph.addEdge("H", "I", 3);

        graph.addEdge("B", "I", 15);

        Map<String, Double> h = new HashMap<>();
        h.put("A", 3.9);
        h.put("D", 2.5);
        h.put("F", 1.5);
        h.put("E", 2.5);
        h.put("C", 3.2);
        h.put("G", 2.8);
        h.put("B", 4.3);
        h.put("I", 1.6);
        h.put("H", 0.0);

        graph.setHeuristics(h);

        List<String> path = graph.getAStarPath("A", "I");

        Map<String, Object> res = graph.aStarSearch("A", "I");
        @SuppressWarnings("unchecked")
        Map<String, Double> gScores = (Map<String, Double>) res.get("gScore");

        double cost = gScores.get("I");

        System.out.println("Menor caminho (A → I): " + path);
        System.out.println("Custo total: " + cost);
    }
}
