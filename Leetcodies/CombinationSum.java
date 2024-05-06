import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] candidates = new int[n];
        for(int i = 0;i < n; i++) {
            candidates[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(Arrays.toString(combinationSum(candidates, target).toArray()));
        sc.close();
    }
    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(candidates, target, 0, result, list);
        return result;
    }
    private static void backtrack(int[] array, int target, int idx, List<List<Integer>> result, List<Integer> list) {
        if(idx == array.length) {
            if(target == 0) {
                result.add(new ArrayList<>(list));
            }
            return;
        } if (array[idx] <= target) {
            list.add(array[idx]);
            backtrack(array, target - array[idx], idx, result, list);
            list.remove(list.size() - 1);
        }
        backtrack(array, target, idx + 1, result, list);
    }
}
