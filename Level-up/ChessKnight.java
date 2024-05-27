import java.util.*;
public class ChessKnight {
    public static boolean isValid(int x, int y, int n) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static int[][] getPossibleMoves(int x, int y, int n) {
        int[][] moves = {{2, 1}, {2, -1}, {1, 2}, {1, -2}, {-2, 1}, {-2, -1}, {-1, 2}, {-1, -2}};
        int[][] validMoves = new int[8][2];
        int count = 0;
        for (int[] move : moves) {
            int newX = x + move[0];
            int newY = y + move[1];
            if (isValid(newX, newY, n)) {
                validMoves[count][0] = newX;
                validMoves[count][1] = newY;
                count++;
            }
        }
        return Arrays.copyOf(validMoves, count);
    }

    public static int getMinimumSteps(int n, int startX, int startY, int endX, int endY) {
        Queue<int[]> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.offer(new int[]{startX, startY});
        visited.add(startX + "," + startY);
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int currentX = current[0];
                int currentY = current[1];
                if (currentX == endX && currentY == endY) {
                    return steps;
                }
                int[][] possibleMoves = getPossibleMoves(currentX, currentY, n);
                for (int[] move : possibleMoves) {
                    int newX = move[0];
                    int newY = move[1];
                    String key = newX + "," + newY;
                    if (!visited.contains(key)) {
                        queue.offer(new int[]{newX, newY});
                        visited.add(key);
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 8;
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
        int u = sc.nextInt() - 1;
        int v = sc.nextInt() - 1;
        int result = getMinimumSteps(n, x, y, u, v);
        System.out.println(result > 0 ? result : -1);
        sc.close();
    }
}

