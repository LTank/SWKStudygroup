import java.util.ArrayList;

public class Graph {
    int[][] adjacencyMatrix;

    public Graph() {

    }

    public void addEdge(int i, int j, int weight) {
        if (this.adjacencyMatrix[i][j] > 0 || this.adjacencyMatrix[j][i] > 0) {
            throw new IllegalArgumentException();
        }
        this.adjacencyMatrix[i][j] = weight;
        this.adjacencyMatrix[j][i] = weight;
    }

    public void removeEdge(int i, int j) {
        if (this.adjacencyMatrix[i][j] < 1 || this.adjacencyMatrix[j][i] < 1 ) {
            throw new IllegalArgumentException();
        }
        this.adjacencyMatrix[i][j] = -1;
        this.adjacencyMatrix[j][i] = -1;
    }

    public void buildMatrix(int size){
        this.adjacencyMatrix = new int[size][size];
        for (int i = 0;i < size; i++){
            for (int j = 0; j < size; j++){
                if(i == j){
                    this.adjacencyMatrix[i][j] = 0;
                } else {
                    this.adjacencyMatrix[i][j] = -1;
                }
            }
        }
    }

    public void printMatrix(int size){

        System.out.println("\ta\tb\tc\td\te");
        ArrayList<String> letter = new ArrayList<>();
        letter.add("a");
        letter.add("b");
        letter.add("c");
        letter.add("d");
        letter.add("e");

        for (int i = 0;i < size; i++){
            for (int j = 0; j < size; j++){
                if(j == 0){
                    System.out.print(letter.get(i) + "\t");
                }
                if(j != size - 1) {
                    System.out.print(adjacencyMatrix[i][j] + "\t");
                } else {
                    System.out.println(adjacencyMatrix[i][j]);
                }
            }
        }
    }

}
