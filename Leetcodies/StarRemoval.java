import java.util.*;
public class StarRemoval {
    private static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '*') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        for(char ch : stack) {
            result.append(ch);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(removeStars(input));
        sc.close();
    }
}
