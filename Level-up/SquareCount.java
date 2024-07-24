import java.util.Scanner;

public class SquareCount {
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

    public static int count4Cycles(int[][] graph, int V) {
        int[][] aux2 = new int[V][V];
        int[][] aux4 = new int[V][V];

        multiply(graph, graph, aux2, V);
        multiply(aux2, aux2, aux4, V);

        int count = 0;
        for (int i = 0; i < V; i++) {
            count += aux4[i][i];
        }
        return count / 4;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        int[][] graph = new int[V][V];
        int[] edges = new int[V];
        for(int i = 0;i < V; i++){
            edges[i] = scanner.nextInt();
        }
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(" ");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            graph[x][y] = 1;
        }
        System.out.println(count4Cycles(graph, V));
        scanner.close();
    }
}
