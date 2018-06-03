public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        int numberOfVertices = 10;
        graph.buildMatrix(numberOfVertices);

        // Adding edges
        graph.addEdge(1, 0, 3);
        graph.addEdge(2, 0, 8);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 10);
        graph.addEdge(2, 4, 4);
        graph.addEdge(3, 4, 4);

        graph.printMatrix(numberOfVertices);

        graph.removeEdge(3,4);

        System.out.println("");

        graph.printMatrix(numberOfVertices);
    }
}