@SuppressWarnings("ALL")

public class Main {
    public static void main(String[] args) {
        GraphUtil graph = new GraphUtil();

        // Creating vertices
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");

        // Adding vertices to graph
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);

        // Adding edges to a
        graph.addEdge(a, b, 2);
        graph.addEdge(a, c, 3);

        // Adding edges to b
        graph.addEdge(b, a, 4);
        graph.addEdge(b, c, 5);
        graph.addEdge(b, d, 6);
        graph.addEdge(b, e, 7);

        // Adding edges to c
        graph.addEdge(c, a, 8);
        graph.addEdge(c, b, 9);
        graph.addEdge(c, e, 10);

        // Adding edges to d
        graph.addEdge(d, b, 11);
        graph.addEdge(d, e, 12);

        // Adding edges to e
        graph.addEdge(e, b, 13);
        graph.addEdge(e, c, 14);
        graph.addEdge(e, d, 15);

        // Exploring our graph
        graph.isAdjacent(e, a);

        graph.showNeighbors(e);

//        graph.showGraph();

        // Manipulating our graph
//        graph.removeVertex(e);
//        graph.showNeighbors(c);
//
//        graph.showNeighbors(a);
//
//        graph.removeEdge(c, a);
//        graph.showNeighbors(a);
//        graph.showNeighbors(c);
//

    }
}