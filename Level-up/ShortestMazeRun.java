import java.util.*;

public class ShortestMazeRun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] problem = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                problem[i][j] = sc.nextInt();
            }
        }
        int[][] solution = new int[n][n];
        int minSteps = Integer.MAX_VALUE;  
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (findMaze(i, j, problem, solution, 0) && solution[i][j] < minSteps) {
                minSteps = solution[i][j];
                }
            }
        }
        if (minSteps == Integer.MAX_VALUE) {
            System.out.println("No solution exists");
        } else {
            System.out.println("Shortest path: " + minSteps);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(solution[i][j] + " ");
                }
                System.out.println();
            }
        }
        sc.close();
    }

    private static boolean findMaze(int x, int y, int[][] problem, int[][] solution, int steps) {
        int n = problem.length;
        if (x == n - 1 && y == n - 1 && problem[n - 1][n - 1] != 1) {
            solution[x][y] = steps + 1; 
            return true;
        }
        if (x >= 0 && x < n && y >= 0 && y < n && problem[x][y] == 0 && solution[x][y] == 0) {
            solution[x][y] = steps + 1; 
            // Right:
            if (findMaze(x, y + 1, problem, solution, steps + 1)) {
                return true;
            }
            // Down:
            if (findMaze(x + 1, y, problem, solution, steps + 1)) {
                return true;
            }
            // Left:
            if (findMaze(x, y - 1, problem, solution, steps + 1)) {
                return true;
            }
            // Up:
            if (findMaze(x - 1, y, problem, solution, steps + 1)) {
                return true;
            }

            // Backtrack
            solution[x][y] = 0;
            return false;
        }
        return false;
    }
}
