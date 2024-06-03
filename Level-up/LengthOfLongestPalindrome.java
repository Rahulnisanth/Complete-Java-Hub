import java.util.*;

public class LengthOfLongestPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(findLength(input));
        sc.close();
    }
    private static int findLength(String input) {
        int n = input.length();
        int count = 0;
        Set<Character> set = new HashSet<>();
        for(int i = 0;i < n; i++) {
            if(set.contains(input.charAt(i))) {
                set.remove(input.charAt(i));
                count++;
            } else {
                set.add(input.charAt(i));
            }
        } if(!set.isEmpty()) {
            return count * 2 + 1;
        } else {
            return count * 2;
        }
    }
}
