import java.util.Scanner;

public class TriangleCount {
    
    public static void multiply(int[][] A, int[][] B, int[][] C, int V) {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                C[i][j] = 0;
                for (int k = 0; k < V; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
    }

    public static int getTrace(int[][] matrix, int V) {
        int trace = 0;
        for (int i = 0; i < V; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static int triangleInGraph(int[][] graph, int V) {
        int[][] aux2 = new int[V][V];
        int[][] aux3 = new int[V][V];
        
        multiply(graph, graph, aux2, V);
        multiply(graph, aux2, aux3, V);
        
        int trace = getTrace(aux3, V);
        return trace / 6;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        
        int[][] graph = new int[V][V];
        
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(" ");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        System.out.println(triangleInGraph(graph, V));
        scanner.close();
    }
}
