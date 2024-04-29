import java.util.*;

public class MinXorCounts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(minOperations(nums, k));
        sc.close();
    }
    public static int minOperations(int[] nums, int k) {
        int xorFinal = 0;
        for (int n : nums) {
            xorFinal = xorFinal ^ n;
        }
        
        int count = 0;
        while (k > 0 || xorFinal > 0) {
            if ((k % 2) != (xorFinal % 2)) {
                count++;
            }
            k /= 2;
            xorFinal /= 2;
        }
        
        return count;
    }
}
