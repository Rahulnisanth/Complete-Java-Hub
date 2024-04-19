import java.util.*;

public class CountIslands {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        char[][] grid = new char[row][col];
        for(int i = 0;i < row; i++){
            for(int j = 0;j < col; j++){
                grid[i][j] = sc.next().charAt(0);
            }
        }
        System.out.println(numIslands(grid));
        sc.close();
    }
    private static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        } else {
            int count = 0;
            for(int i = 0;i < grid.length; i++){
                for(int j = 0;j < grid[0].length; j++){
                    if(grid[i][j] == '1'){
                        count++;
                        dfs(grid, i, j);
                    }
                }
            }
            return count;
        }
    }
    private static void dfs(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
