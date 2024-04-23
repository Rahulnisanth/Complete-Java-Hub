import java.util.*;
public class GuessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int range = sc.nextInt();
        System.out.println(getMinCost(range));
        sc.close();
    }
    private static int getMinCost(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return calculateMinCost(dp, 1, n);
    }
    private static int calculateMinCost(int[][] dp, int left, int right) {
        if(left >= right) {
            return 0;
        } if(dp[left][right] != 0) {
            return dp[left][right];
        } else {
            int minCost = Integer.MAX_VALUE;
            for(int guess = left; guess <= right; guess++){
                int cost = guess + Math.max(calculateMinCost(dp, left, guess - 1), calculateMinCost(dp, guess + 1, right));
                minCost = Math.min(minCost, cost);
            }
            return minCost;
        }
    }
}
