import java.util.*;

public class ChessKnight {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Initial Position :
        int x = sc.nextInt();
        int y = sc.nextInt();
        // Target Position :
        int u = sc.nextInt();
        int v = sc.nextInt();
        // Chess Board : Size is irrelevant for this logic
        int[][] memo = new int[64][64];
        for(int i = 0;i < 64; i++) {
            Arrays.fill(memo[i], -1);
        }
        boolean[][] visited = new boolean[64][64]; 
        // Main course :
        int steps = placeKnightInTarget(x, y, u, v, visited, memo);
        if (steps != -1) {
            System.out.println("Steps Count : " + steps);
        } else {
            System.out.println("No solution exists");
        }
        sc.close();
    }

    // Method to calculate the minimum steps to place the knight in the target place of the board :
    private static int placeKnightInTarget(int x, int y, int u, int v, boolean[][] visited, int[][] memo) {
        if (x == u && y == v) {
            return 0;
        }

        int n = visited.length;
        if (x >= 0 && x < n && y >= 0 && y < n && !visited[x][y]) {
            visited[x][y] = true; 
            if(memo[x][y] != -1){
                return memo[x][y];
            }
            // Top :
            int topRight = placeKnightInTarget(x - 2, y + 1, u, v, visited, memo);
            if (topRight != -1) {
                memo[x][y] = topRight + 1;
                return memo[x][y];
            }
            int topLeft = placeKnightInTarget(x - 2, y - 1, u, v, visited, memo);
            if (topLeft != -1) {
                memo[x][y] = topLeft + 1;
                return memo[x][y];
            }
            // Bottom :
            int bottomRight = placeKnightInTarget(x + 2, y + 1, u, v, visited, memo);
            if (bottomRight != -1) {
                memo[x][y] = bottomRight + 1;
                return memo[x][y];
            }
            int bottomLeft = placeKnightInTarget(x + 2, y - 1, u, v, visited, memo);
            if (bottomLeft != -1) {
                memo[x][y] = bottomLeft + 1;
                return memo[x][y];
            }
            // Left :
            int leftTop = placeKnightInTarget(x - 1, y - 2, u, v, visited, memo);
            if (leftTop != -1) {
                memo[x][y] = leftTop + 1;
                return memo[x][y];
            }
            int leftBottom = placeKnightInTarget(x + 1, y - 2, u, v, visited, memo);
            if (leftBottom != -1) {
                memo[x][y] = leftBottom + 1;
                return memo[x][y];
            }
            // Right :
            int rightTop = placeKnightInTarget(x - 1, y + 2, u, v, visited, memo);
            if (rightTop != -1) {
                memo[x][y] = rightTop + 1;
                return memo[x][y];
            }
            int rightBottom = placeKnightInTarget(x + 1, y + 2, u, v, visited, memo);
            if (rightBottom != -1) {
                memo[x][y] = rightBottom + 1;
                return memo[x][y];
            }
            visited[x][y] = false;  
            return -1;
        }
        return -1;
    }
}
