import java.util.*;
public class SpecialArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++) nums[i] = sc.nextInt();
        System.out.println(specialArray(nums));
        sc.close();
    }
    public static int specialArray(int[] nums) {
        Arrays.sort(nums);
        for(int x = 1;x <= nums.length; x++) {
            int count = 0;
            for(int num : nums) {
                if(num >= x) count++;
            }
            if(count == x) return x;
        }
        return -1;
    }
}
