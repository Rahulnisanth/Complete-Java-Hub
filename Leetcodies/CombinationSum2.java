import java.util.*;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, new ArrayList<>(), target, candidates, result);
        return result;
    }
    public static void backtrack(int idx, List<Integer> dump, int target, int[] candidates, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(dump));
            return;
        }
        for(int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;
            dump.add(candidates[i]);
            backtrack(i + 1, dump, target - candidates[i], candidates, result);
            dump.remove(dump.size() - 1);
        }
    }
}