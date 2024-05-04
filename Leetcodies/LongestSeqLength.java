import java.util.*;

public class LongestSeqLength {
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            return findMax(dp);
        }
    }
    private static int findMax(int[] array) {
        int maxx = 0;
        for(int num : array) {
            maxx = Math.max(maxx, num);
        }
        return maxx;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
        System.out.println(lengthOfLIS(array));
        sc.close();
    }
}