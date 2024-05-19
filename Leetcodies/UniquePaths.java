import java.util.*;

public class UniquePaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for(int i = 0;i < m; i++) {
            for(int j = 0;j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(uniquePathsWithObstacles(grid));
        sc.close();
    }
    private static int uniquePathsWithObstacles(int[][] grid) {
        return backtrack(0, 0, grid);
    }
    private static int backtrack(int x, int y, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // Target acquired :
        if(x == m - 1 && y == n - 1) {
            return 1;
        } 
        // Incase of obstacle :
        if(x >= m || y >= n || grid[x][y] == 1) {
            return 0;
        }
        grid[x][y] = 1; // Mark as visited
        int paths = backtrack(x, y + 1, grid) + backtrack(x + 1, y, grid);
        grid[x][y] = 0; // Mark as un-visited for next round
        return paths;
    }
}
