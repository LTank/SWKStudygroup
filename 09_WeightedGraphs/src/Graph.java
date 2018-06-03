public class Graph {
    int[][] adjacencyMatrix;

    public Graph() {

    }

    public void addEdge(int i, int j, int weight) {
        if (this.adjacencyMatrix[i][j] != 0 || this.adjacencyMatrix[j][i] != 0) {
            throw new IllegalArgumentException();
        }
        this.adjacencyMatrix[i][j] = weight;
        this.adjacencyMatrix[j][i] = weight;
    }

    public void removeEdge(int i, int j) {
        if (this.adjacencyMatrix[i][j] == 0 || this.adjacencyMatrix[j][i] == 0) {
            throw new IllegalArgumentException();
        }
        this.adjacencyMatrix[i][j] = 0;
        this.adjacencyMatrix[j][i] = 0;
    }

    public void buildMatrix(int size){
        this.adjacencyMatrix = new int[size][size];
        for (int i = 0;i < size; i++){
            for (int j = 0; j < size; j++){
                this.adjacencyMatrix[i][j] = 0;
            }
        }
    }

    public void printMatrix(int size){
        for (int i = 0;i < size; i++){
            for (int j = 0; j < size; j++){
                if(j != size - 1) {
                    System.out.print(adjacencyMatrix[i][j] + "\t");
                } else {
                    System.out.println(adjacencyMatrix[i][j]);
                }
            }
        }
    }

}
