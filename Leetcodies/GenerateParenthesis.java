import java.util.*;
class GenerateParenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(Arrays.toString(generateParenthesis(n).toArray()));
        sc.close();
    }
    private static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    private static void backtrack(List<String> result, String combination, int open, int close, int n) {
        if(combination.length() == 2 * n) {
            result.add(combination);
            return;
        } if (open < n) {
            backtrack(result, combination + "(", open + 1, close, n);
        } if (close < open) {
            backtrack(result, combination + ")", open, close + 1, n);
        }
    }
}