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
            exceptions[i][0] = scanner.nextInt();
            exceptions[i][1] = scanner.nextInt();
        }
        System.out.println(minimumDays(S, X, exceptions));
        scanner.close();
    }

    public static int minimumDays(int S, int X, int[][] exceptions) {
        Arrays.sort(exceptions, Comparator.comparingInt(arr -> arr[0]));
        int currentDistance = S;
        int currentDay;
        
        // Initial days -->
        currentDistance = currentDistance - (exceptions[0][0] - 1) * X;
        currentDay = exceptions[0][0] - 1;
        
        // Exception traversal -->
        int idx = 0;
        for (int i = exceptions[0][0]; i <= exceptions[exceptions.length - 1][0]; i++) {
            if (exceptions[idx][0] == i) {
                currentDistance -= exceptions[idx][1];
                idx++;
                currentDay++;
            } else {
                currentDistance -= X;
                currentDay++;
            }
        }
        // Extended days of the end -->
        while (currentDistance > 0) {
            currentDistance -= X;
            currentDay++;
        }
        
        return currentDay;
    }
}   

