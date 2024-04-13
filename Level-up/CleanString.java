import java.util.*;
public class CleanString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        System.out.println(cleanCount(word));
        sc.close();
    }
    private static int cleanCount(String word) {
        if(word == null || word.length() <= 1) {
            return 0;
        } else {
            HashMap<Character, Integer> countMap = new HashMap<>();
            for(char ch : word.toCharArray()) {
                countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
            }
            int charCount = 0;
            Set<Character> seen = new HashSet<>();
            for(char ch : word.toCharArray()) {
                if(seen.contains(ch)){
                    countMap.put(ch, countMap.get(ch) - 1);
                    charCount++;
                } if (countMap.get(ch) == 1) {
                    seen.remove(ch);
                } else {
                    seen.add(ch);
                } 
            }
            return charCount;
        }
    }
}
