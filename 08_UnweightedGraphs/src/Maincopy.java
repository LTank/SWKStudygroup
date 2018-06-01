public class Maincopy {
    public static void main(String[] args) {
        Graph graph = new Graph();

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
        graph.addEdge(b, a);
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



//        ShowGraph(graph);
//
//        ShowNeighbors(graph, a);
//
//        CheckForAdjacency(graph, c, d);

    }

    // Asking if to vertices are neighbors/adjacent
    private static void CheckForAdjacency(Graph graph, Vertex v, Vertex u) {
        if (graph.isAdjacent(v, u)){
            System.out.println(v.toString() + " is adjacent to " + u.toString());
        } else {
            System.out.println(v.toString() + " is NOT adjacent to " + u.toString());
        }
    }

    // Getting all neighbors of Vertex v
    private static void ShowNeighbors(Graph graph, Object v) {
        System.out.println("\nNeighbors of " + v + ": ");
        for (Object vertex : graph.getNeighbors(v)) {
            System.out.print(vertex + ", ");
        }
    }

    // Showing all vertices in graph
    private static void ShowGraph(Graph graph) {
        System.out.println("Graph contain(s) the following vertex/vertices: ");
        for (Object vertex : graph.getAllVertices()) {
            ShowNeighbors(graph, vertex);
        }
    }

}
