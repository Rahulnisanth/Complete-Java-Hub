import java.util.*;
/* Given the knights position on the chess board represented by S, find if a knight can reach a particular position[GOAL] on the chess board. 
S -  represents the starting position of the knight
X - represents the destination position of the knight [GOAL position]
Here are the constraints:
1) A value for a position "1" represents your own coin in which case you cannot jump to that place
2) A value 0 means it is an empty slot or occupied by another coin in which case you can jump to that place.
3) Any position outside the 8x8 board is considered an invalid position. The knight cannot move there. */
public class ChessKnightII {
    static char[][] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 8;
        int startX = -1, startY = -1;
        int endX = -1, endY = -1;
        board = new char[n][n];
        for(int i=0;i<n;i++) {
            String line = sc.nextLine();
            String[] parts = line.split(": ")[1].split(",");
            for(int j=0;j<n;j++) {
                board[i][j] = parts[j].charAt(0);
                if (board[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
                if (board[i][j] == 'X') {
                    endX = i;
                    endY = j;
                }
            }
        }
        if(findKnightTarget(startX, startY, endX, endY)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        sc.close();
    }
    // Backtracing with BFs approach :
    private static boolean findKnightTarget(int startX, int startY, int endX, int endY) {
        int[] dx = {2, 2, 1, 1, -2, -2, -1, -1};
        int[] dy = {1, -1, 2, -2, 1, -1, 2, -2};
        boolean[][] visited = new boolean[8][8];
        Queue<int[]> queue = new LinkedList<>(); 
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            // Base case :
            if(currentX == endX && currentY == endY) {
                return true;
            }
            // Edge case :
            for(int i=0;i<8;i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                if(isValid(nextX, nextY, 8) && board[nextX][nextY] != '1' && !visited[nextX][nextY]) {
                    queue.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
        return false;
    }
    public static boolean isValid(int x, int y, int n) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}
