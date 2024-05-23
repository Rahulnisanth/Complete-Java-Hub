import java.util.*;
public class BeautifulSubsets {
    static int count = 0;
    static Map<Integer, Integer> map = new HashMap<>();
    
    public static int beautifulSubsets(int[] nums, int k) {
        explore(nums, 0, k);
        return count - 1;
    }
    private static void explore(int[] nums, int index, int k) {
        if(nums.length == index) {
            count++;
            return;
        }
        int num = nums[index];
        if(!map.containsKey(num - k) && !map.containsKey(num + k)) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            explore(nums, index + 1, k);
            map.put(num, map.get(num) - 1);
            if(map.get(num) == 0) {
                map.remove(num);
            }
        }
        explore(nums, index + 1, k);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums  = new int[n];
        for(int i=0;i<n;i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(beautifulSubsets(nums, k));
        sc.close();
    }

}