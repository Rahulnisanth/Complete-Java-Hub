import java.util.*;
public class MaximalRectangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] matrix = new char[n][m];
        for(int i = 0;i < n; i++) {
            for(int j = 0;j < m; j++) {
                matrix[i][j] = sc.next().charAt(0);
            }
        }
        System.out.println(maximalRectangle(matrix));
        sc.close();
    }
    private static int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        } else {
            int row = matrix.length;
            int col = matrix[0].length;
            int[] heights = new int[col];
            int maxArea = 0;
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    if(matrix[i][j] == '1') {
                        heights[j]++;
                    } else {
                        heights[j] = 0;
                    }
                }
                maxArea = Math.max(maxArea, largestArea(heights));
            }
            return maxArea;
        }
    }
    private static int largestArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        int n = heights.length;
        
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            
            stack.push(i);
        }
        
        return maxArea;
    }
}