import java.util.Scanner;

public class PivotIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(pivotIndex(arr));
        sc.close();
    }
    public static int pivotIndex(int[] nums) {
        int partial = 0;
        int total = 0;
        for(int num : nums) {
            total += num;
        }
        for(int i = 0; i < nums.length; i++) {
            total -= nums[i];
            if(partial == total)
                return i;
            partial += nums[i];
        }
        return -1;
    }
}
