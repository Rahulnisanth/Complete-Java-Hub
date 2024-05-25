import java.util.*;

public class WordBreakII {
    static List<String> result;
    static Set<String> set;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<String> wordDict = new ArrayList<>();
        while(sc.hasNext()){
            wordDict.add(sc.next());
        }
        System.err.println(Arrays.toString(wordBreak(s, wordDict).toArray()));
        sc.close();
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        result = new ArrayList<>();
        set = new HashSet<>();
        for (String word : wordDict)
            set.add(word);
        backtrack(s, 0, new StringBuilder());
        return result;
    }

    private static void backtrack(String s, int start, StringBuilder current) {
        if (s.length() == start) {
            result.add(current.toString().trim());
        }
        for (int i = start; i < s.length(); i++) {
            if (set.contains(s.substring(start, i + 1))) {
                int len = current.length();
                current.append(s.substring(start, i + 1));
                current.append(" ");
                backtrack(s, i + 1, current);
                current.setLength(len);
            }

        }
    }
}