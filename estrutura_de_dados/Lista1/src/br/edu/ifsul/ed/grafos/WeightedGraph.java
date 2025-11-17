package br.edu.ifsul.ed.grafos;

import java.util.*;

public class WeightedGraph {

	private boolean directed;
	private Map<String, List<Edge>> adjacencyList;
	private Map<String, Double> heuristics;

	public WeightedGraph(boolean directed) {
		this.directed = directed;
		this.adjacencyList = new HashMap<>();
		this.heuristics = new HashMap<>();
	}

	class Edge {
		public String destination;

		public int weight;

		public Edge(String destination, int weight) {
			this.destination = destination;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "(" + destination + ", " + weight + ")";
		}
	}

	class Pair {
		public String vertex;
		public int distance;

		public Pair(String vertex, int distance) {
			this.vertex = vertex;
			this.distance = distance;
		}
	}

	public void addVertex(String vertex) {
		if (!adjacencyList.containsKey(vertex)) {
			adjacencyList.put(vertex, new ArrayList<>());
		}
	}

	public void addVertices(Collection<String> vertices) {
		for (String vertex : vertices) {
			addVertex(vertex);
		}
	}

	public void addEdge(String origin, String destination, int weight) {
		addVertex(origin);
		addVertex(destination);

		adjacencyList.get(origin).add(new Edge(destination, weight));

		if (!directed) {
			adjacencyList.get(destination).add(new Edge(origin, weight));
		}
	}

	public void printAdjacencyList() {
		System.out.println("Lista de Adjacências (Vértice -> [(Destino, Peso),...]):");
		for (Map.Entry<String, List<Edge>> entry : adjacencyList.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}

	public Map<String, Object> dijkstraWithPredecessor(String source, String destination) {
		Map<String, Integer> distances = new HashMap<>();
		Map<String, String> predecessors = new HashMap<>();

		for (String vertex : adjacencyList.keySet()) {
			distances.put(vertex, Integer.MAX_VALUE);
			predecessors.put(vertex, null);
		}
		distances.put(source, 0);

		PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.distance));
		queue.add(new Pair(source, 0));

		while (!queue.isEmpty()) {
			Pair currentPair = queue.poll();
			String currentVertex = currentPair.vertex;
			int currentDistance = currentPair.distance;

			if (currentVertex.equals(destination)) {
				break;
			}

			if (currentDistance > distances.get(currentVertex)) {
				continue;
			}

			for (Edge edge : adjacencyList.get(currentVertex)) {
				int newDistance = currentDistance + edge.weight;
				if (newDistance < distances.get(edge.destination)) {
					distances.put(edge.destination, newDistance);
					predecessors.put(edge.destination, currentVertex);
					queue.add(new Pair(edge.destination, newDistance));
				}
			}
		}

		Map<String, Object> result = new HashMap<>();
		result.put("distances", distances);
		result.put("predecessors", predecessors);
		return result;
	}

	public List<String> getShortestPath(String source, String destination) {
		Map<String, Object> dijkstraResult = dijkstraWithPredecessor(source, destination);
		@SuppressWarnings("unchecked")
		Map<String, String> predecessors = (Map<String, String>) dijkstraResult.get("predecessors");

		List<String> path = new ArrayList<>();
		String current = destination;

		if (predecessors.get(current) == null && !current.equals(source)) {
			return path;
		}

		while (current != null) {
			path.add(current);
			current = predecessors.get(current);
		}

		Collections.reverse(path);
		return path;
	}

	public void setHeuristics(Map<String, Double> heuristics) {
		this.heuristics = heuristics;
	}

	class AStarNode {
		public String vertex;
		public double g;
		public double f;

		public AStarNode(String vertex, double g, double f) {
			this.vertex = vertex;
			this.g = g;
			this.f = f;
		}
	}

	private double heuristic(String vertex, String target) {
		return heuristics.getOrDefault(vertex, 0.0);
	}

	public Map<String, Object> aStarSearch(String source, String target) {
		Map<String, Double> gScore = new HashMap<>();
		Map<String, String> cameFrom = new HashMap<>();

		for (String vertex : adjacencyList.keySet()) {
			gScore.put(vertex, Double.MAX_VALUE);
			cameFrom.put(vertex, null);
		}
		gScore.put(source, 0.0);

		double initialFScore = gScore.get(source) + heuristic(source, target);
		PriorityQueue<AStarNode> openSet = new PriorityQueue<>(Comparator.comparingDouble(n -> n.f));
		openSet.add(new AStarNode(source, gScore.get(source), initialFScore));

		while (!openSet.isEmpty()) {
			AStarNode current = openSet.poll();
			if (current.vertex.equals(target)) {
				break;
			}
			for (Edge edge : adjacencyList.get(current.vertex)) {
				double tentativeG = gScore.get(current.vertex) + edge.weight;
				if (tentativeG < gScore.get(edge.destination)) {
					gScore.put(edge.destination, tentativeG);
					cameFrom.put(edge.destination, current.vertex);
					double fScore = tentativeG + heuristic(edge.destination, target);
					openSet.add(new AStarNode(edge.destination, tentativeG, fScore));
				}
			}

		}

		Map<String, Object> result = new HashMap<>();
		result.put("gScore", gScore);
		result.put("cameFrom", cameFrom);
		return result;
	}
	
	public List<String> getAStarPath(String source, String target) {
		Map<String, Object> result = aStarSearch(source, target);
		@SuppressWarnings("unchecked")
		Map<String, String> cameFrom = (Map<String, String>) result.get("cameFrom");
		
		List<String> path = new ArrayList<>();
		String current = target;
		
		if(cameFrom.get(current) == null && !current.equals(source)) {
			return path;
		}
		
		while (current != null) {
			path.add(current);
			current = cameFrom.get(current);
		}
		Collections.reverse(path);
		return path;
	}
}
