import java.util.*;
/**
 * Prims-Algorithm
 */
public class PrimsAlgorithm {
    static int V;

    public static int minKey(int[] keys, boolean[] mst) {
        int minVal = Integer.MAX_VALUE, vertex = -1;
        for(int i = 0;i < V; i++) {
            if( !mst[i] && keys[i] < minVal) {
                minVal = keys[i];
                vertex = i;
            }
        }
        return vertex;
    }

    public static void printMst(int[] parent, int[][] graph) {
        System.out.println("Edges\tweight");
        for(int i = 1;i < V; i++) {
            System.out.println(parent[i] + "->" + i + "\t" + graph[i][parent[i]]);
        }
    }

    public static void calculatePrims(int[][] graph) {
        int[] keys = new int[V];
        int[] parent = new int[V];
        boolean[] mst = new boolean[V];

        for(int i = 0;i < V; i++) {
            keys[i] = Integer.MAX_VALUE;
            mst[i] = false;
        }
        keys[0] = 0;
        parent[0] = -1;

        for(int k = 0; k < V - 1; k++) {
            int u = minKey(keys, mst);
            mst[u] = true;
            for(int v = 0;v < V; v++) {
                if(mst[v] == false && graph[u][v] != 0 && graph[u][v] < keys[v]) {
                    keys[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }
        printMst(parent, graph);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        int[][] graph = new int[V][V];
        for(int i = 0;i < V; i++) {
            for(int j = 0;j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        calculatePrims(graph);
        sc.close();
    }
}