import java.util.*;

public class ShortestMazeRunTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int[][] solution = new int[n][n];
        int steps = 0;
        steps = findMaze(x, y, grid, solution);
        if (steps != -1) {
            System.out.println("Steps Count : " + (steps + 1));
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(solution[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution exists");
        }
        sc.close();
    }

    private static int findMaze(int x, int y, int[][] grid, int[][] solution) {
        int n = grid.length;
        if ((x == 0 && y == 0) || (x == 0 && y == n - 1) || (x == n - 1 && y == 0) || (x == n - 1 && y == n - 1)) {
            solution[x][y] = 1;
            return 0; 
        }
        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0 && solution[x][y] == 0) {
            solution[x][y] = 1;
            // Right :
            int rightSteps = findMaze(x, y + 1, grid, solution);
            if (rightSteps != -1) {
                return rightSteps + 1;
            }
            // Down :
            int downSteps = findMaze(x + 1, y, grid, solution);
            if (downSteps != -1) {
                return downSteps + 1;
            }
            // Left :
            int leftSteps = findMaze(x, y - 1, grid, solution);
            if (leftSteps != -1) {
                return leftSteps + 1;
            }
            // Up :
            int upSteps = findMaze(x - 1, y, grid, solution);
            if (upSteps != -1) {
                return upSteps + 1;
            }
            // Backtracks :
            solution[x][y] = 0;
        }
        return -1; 
    }
}
