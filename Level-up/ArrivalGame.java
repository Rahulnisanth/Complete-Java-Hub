import java.util.*;
/**
 * ArrivalGame
 */
public class ArrivalGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int S = scanner.nextInt();
        int X = scanner.nextInt();
        int N = scanner.nextInt();
        int[][] exceptions = new int[N][2];
        for (int i = 0; i < N; i++) {
            exceptions[0][i] = scanner.nextInt();
            exceptions[1][i] = scanner.nextInt();
        }
        System.out.println(minimumDays(S, X, exceptions));
        scanner.close();
    }

    public static int minimumDays(int S, int X, int[][] exceptions) {
        Arrays.sort(exceptions, Comparator.comparingInt(arr -> arr[0]));
        int currentDistance = 0;
        int currentDay = 1;
        for (int[] exception : exceptions) {
            int day = exception[0];
            int distance = exception[1] - currentDistance;
            if (distance <= 0) {
                continue;
            }
            currentDistance += distance;
            currentDay += (distance / X) + (distance % X == 0 ? 0 : 1);
            if (currentDistance >= S) {
                return currentDay;
            }
        }
        int remainingDistance = S - currentDistance;
        return currentDay + (remainingDistance / X) + (remainingDistance % X == 0 ? 0 : 1);
    }
}   

