import java.util.LinkedList;
import java.util.Queue;

public class ChessKnightMoves {
    // Chess board
    private static int[][] board = new int[200][200];

    // Valid move checking function
    private static boolean isValid(int x, int y) {
        return x >= 0 && x < 200 && y >= 0 && y < 200;
    }

    // Marking function
    private static void markMoves(int startX, int startY, int step) {
        // Possible moves for the chess knight
        int[] dx = {2, 2, 1, 1, -1, -1, -2, -2};
        int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};

        // Adding the next valid moves in queue
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});

        // Visited 2D array for tracking all the x,y
        boolean[][] visited = new boolean[200][200];
        visited[startX][startY] = true;

        // Traversing the queue
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            // Calculating all possible valid moves
            for (int i = 0; i < 8; i++) {
                int newX = currentX + dx[i];
                int newY = currentY + dy[i];

                // Marking the board & adding the next moves to queue when condition satisfies
                if (isValid(newX, newY) && board[newX][newY] == 0 && !visited[newX][newY]) {
                    board[newX][newY] = step + 1;
                    queue.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }

            // Incrementing the step for next traversal
            step++;
        }
    }

    public static void main(String[] args) {
        // Input stream
        int startX = 5;
        int startY = 5;
        markMoves(startX - 1, startY - 1, 0);

        // Printing the board to see the result
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}

