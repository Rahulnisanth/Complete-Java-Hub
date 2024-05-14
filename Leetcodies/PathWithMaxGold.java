import java.util.*;

public class PathWithMaxGold {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(getMaximumGold(grid));
        sc.close();
    }
    public static int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxGold = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxGold = Math.max(maxGold, backtrack(i, j, grid, 0));
            }
        }
        return maxGold;
    }
    private static int backtrack(int x, int y, int[][] grid, int goldCount) {
        int m = grid.length;
        int n = grid[0].length;
        // Stopper case ->
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) {
            return goldCount;
        } 
        // Backtracking case ->
        else {
        int currentGold = grid[x][y];
        goldCount += currentGold;
        grid[x][y] = 0;
        int maxGold = Math.max(
            Math.max(backtrack(x, y + 1, grid, goldCount), backtrack(x, y - 1, grid, goldCount)),
            Math.max(backtrack(x + 1, y, grid, goldCount), backtrack(x - 1, y, grid, goldCount))
        );
        grid[x][y] = currentGold;
        return maxGold;
        }
    }
}
