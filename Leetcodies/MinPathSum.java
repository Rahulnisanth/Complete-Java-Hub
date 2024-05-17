import java.util.*;
/**
 * MinPathSum
 */
public class MinPathSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(minPathSum(grid));
        sc.close();
    }
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        // Base case [first rows & first column] :
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int j = 1; j < m; j++) {
            dp[j][0] = dp[j - 1][0] + grid[j][0];
        }
        // Remaining fills :
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        // Final answer :
        return dp[m - 1][n - 1];
    }
}