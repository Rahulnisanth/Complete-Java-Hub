import java.util.*;
public class Tribbanocci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(tribonacci(n));
        sc.close();
    }
    private static int tribonacci(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return tribby(n, dp);
    }
    private static int tribby(int n, int[] dp) {
        if(n == 0) {
            return 0;
        } if (n == 1) {
            return 1;
        } if (n == 2) {
            return 1;
        } else if (dp[n] != -1) {
            return dp[n];
        } else {
            dp[n] = tribby(n - 1, dp) + tribby(n - 2, dp) + tribby(n - 3, dp);
            return dp[n]; 
        }
    }

}
