package br.edu.ifsul.ed.grafos;

public class exercicio2main {
    public static void main(String[] args) {
        
        Graph graph = new Graph(false);

        graph.addEdge("a", "b");
        graph.addEdge("a", "e");
        
        graph.addEdge("b", "f");
        graph.addEdge("b", "a");

        graph.addEdge("e", "a");
        graph.addEdge("e", "f");
        graph.addEdge("e", "i");

        graph.addEdge("i", "e");
        graph.addEdge("i", "f");

        graph.addEdge("f", "b");
        graph.addEdge("f", "i");
        graph.addEdge("f", "c");
        graph.addEdge("f", "g");
        graph.addEdge("f", "j");

        graph.addEdge("j", "f");
        graph.addEdge("j", "k");

        graph.addEdge("c", "f");
        graph.addEdge("c", "d");
        graph.addEdge("c", "h");
        graph.addEdge("c", "g");

        graph.addEdge("g", "f");
        graph.addEdge("g", "c");
        graph.addEdge("g", "k");
        graph.addEdge("g", "h");
        graph.addEdge("g", "d");
        graph.addEdge("g", "l");

        graph.addEdge("k", "j");
        graph.addEdge("k", "g");
        graph.addEdge("k", "l");

        graph.addEdge("h", "d");
        graph.addEdge("h", "c");
        graph.addEdge("h", "g");
        graph.addEdge("h", "i");

        graph.addEdge("l", "k");
        graph.addEdge("l", "g");
        graph.addEdge("l", "h");

        graph.addEdge("d", "c");
        graph.addEdge("d", "g");
        graph.addEdge("d", "h");

        System.out.println("===== BFS a partir de 'b' =====");
        System.out.println(graph.breadthFirstSearch("b"));
    }
}
