import java.util.*;

public class MazeRun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] problem = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                problem[i][j] = sc.nextInt();
            }
        }
        int[][] solution = new int[n][n];
        if(findMaze(0, 0, problem, solution) == true) {
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++) {
                    System.out.print(solution[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution exists");
        }
        sc.close();
    }
    private static boolean findMaze(int x, int y, int[][] problem, int[][] solution) {
        int n = problem.length;
        if(x == n - 1 && y == n - 1) {
            solution[x][y] = 1;
            return true;
        } if(x >= 0 && x < n && y >= 0 && y < n && problem[x][y] == 0) {
            solution[x][y] = 1;
            if(findMaze(x + 1, y,problem, solution) == true) {
                return true;
            } if(findMaze(x, y + 1, problem, solution) == true) {
                return  true;
            }
            solution[x][y] = 0;
            return false;
        }
        return false;
    }
}
