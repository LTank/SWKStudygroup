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
        graph.addEdge(a, b);
        graph.addEdge(a, c);

        // Adding edges to b
        graph.addEdge(b, a); // Dette er det samme som a, b og er derfor redundant
        graph.addEdge(b, c);
        graph.addEdge(b, d);
        graph.addEdge(b, e);

        // Adding edges to c
        graph.addEdge(c, a);
        graph.addEdge(c, b);
        graph.addEdge(c, e);

        // Adding edges to d
        graph.addEdge(d, b);
        graph.addEdge(d, e);

        // Adding edges to e
        graph.addEdge(e, b);
        graph.addEdge(e, c);
        graph.addEdge(e, d);

        // Exploring our graph
//        graph.isAdjacent(e, a);

//        graph.showNeighbors(e);

        graph.showGraph();


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