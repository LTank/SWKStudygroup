import java.util.*;

public class GraphUtil<T> {
    final private HashMap<T, Set<T>> adjacencyList;
    final private int[][] adjacencyMatrix;

    public GraphUtil() {
        this.adjacencyList = new HashMap<>();
        this.adjacencyMatrix = new int[5][5]; // Matrix with 5 vertices
    }

    public void addVertex(T v) {
        if (this.adjacencyList.containsKey(v)) {
            throw new IllegalArgumentException("Vertex already exists.");
        }
        this.adjacencyList.put(v, new HashSet<T>());
    }

    public void removeVertex(T v) {
        if (!this.adjacencyList.containsKey(v)) {
            throw new IllegalArgumentException("Vertex doesn't exist.");
        }
        this.adjacencyList.remove(v);

        for (T u : this.adjacencyList.keySet()) {
            this.adjacencyList.get(u).remove(v);
        }
    }

    public void addEdge(T v, T u, int weight) {
        if (!this.adjacencyList.containsKey(v) || !this.adjacencyList.containsKey(u)) {
            throw new IllegalArgumentException();
        }
        this.adjacencyList.get(v).add(u);
        this.adjacencyList.get(u).add(v);


    }

    public void removeEdge(T v, T u) {
        if (!this.adjacencyList.containsKey(v) || !this.adjacencyList.containsKey(u)) {
            throw new IllegalArgumentException();
        }
        this.adjacencyList.get(v).remove(u);
        this.adjacencyList.get(u).remove(v);
//        this.edges.remove()
    }

    public void isAdjacent(T v, T u) {
        if (this.adjacencyList.get(v).contains(u)){
            System.out.print(v.toString() + " is adjacent to " + u.toString());
        } else {
            System.out.print(v.toString() + " is NOT adjacent to " + u.toString());
        }
    }

    public void showNeighbors(T v){
        System.out.print ("\nNeighbors of " + v + ": ");
        for (T vertex : this.adjacencyList.get(v)) {
            System.out.print(vertex + ", ");
        }
    }

    public void showGraph(){
        for (T v : this.adjacencyList.keySet()){
            showNeighbors(v);
        }
    }

    public void showWeight(T v, T u){

        System.out.println();
    }
}
