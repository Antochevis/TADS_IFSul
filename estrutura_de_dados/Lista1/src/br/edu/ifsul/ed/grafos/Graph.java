package br.edu.ifsul.ed.grafos;

import java.util.*;

public class Graph {
	private boolean directed;
	
	private Map<String, List<String>> adjacencyList;
	
	public Graph(boolean directed) {
		this.directed = directed;
		adjacencyList = new HashMap<>();
	}
	
	public void addVertex(String vertex) {
		if (!adjacencyList.containsKey(vertex)) {
			adjacencyList.put(vertex,  new ArrayList<>());
		}
	}
	
	public void addVertices(Collection<String> vertices) {
		for (String vertex : vertices) {
			addVertex(vertex);
		}
	}
	
	public void addEdge(String origin, String destination) {
		addVertex(origin);
		addVertex(destination);
		
		adjacencyList.get(origin).add(destination);
		
		if(!directed) {
			adjacencyList.get(destination).add(origin);
		}
	}
	
	public void printAdjacencyList() {
		System.out.println("Lista de Adjacências: ");
		for(Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
			System.out.println(entry.getClass() + " -> " + entry.getValue());
		}
	}
	
	//busca em profundidade recursiva
	
	public List<String> depthFirstSearch(String startVertex) {
		List<String> traversal = new ArrayList<>();
		Set<String> visited = new HashSet<>();
		
		dfsRecursive(startVertex, visited, traversal);
		
		return traversal;
	}
	
	public void dfsRecursive(String vertex, Set<String> visited, List<String> traversal) {
		visited.add(vertex);
		traversal.add(vertex);
		
		for (String adjacent : adjacencyList.get(vertex)) {
			if (!visited.contains(adjacent)) {
				dfsRecursive(adjacent, visited, traversal);
			}
		}
	}
	
	//busca em largura
	
	public List<String> breadthFirstSearch(String startVertex) {
		List<String> traversal = new ArrayList<>();
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		
		visited.add(startVertex);
		queue.offer(startVertex);
		
		while (!queue.isEmpty()) {
			String current = queue.poll();
			traversal.add(current);
			
			List<String> neighbors = adjacencyList.get(current);
			if(neighbors != null) {
				for(String neighbor : neighbors) {
					if(!visited.contains(neighbor)) {
						visited.add(neighbor);
						queue.offer(neighbor);
					}
				}
			}
		}
		return traversal;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
