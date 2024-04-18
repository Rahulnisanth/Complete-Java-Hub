import java.util.*;
/**
 * IslandPerimeter
 */
public class IslandPerimeter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] grid = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(findIslandPerimeter(grid));
        sc.close();
    }
    private static int findIslandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int perimeter = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1){
                    perimeter += dfs(grid, i, j);
                }
            }
        }
        return perimeter;
    }
    private static int dfs(int[][] grid, int row, int col) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0){
            return 1;
        } else {
            if(grid[row][col] == -1){
                return 0;
            }
            grid[row][col] = -1;
            return dfs(grid, row + 1, col) +
            dfs(grid, row - 1, col) + dfs(grid, row, col + 1) + dfs(grid, row, col - 1);
        }
    }
}