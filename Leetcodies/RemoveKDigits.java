import java.util.*;
public class RemoveKDigits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        int k = sc.nextInt();
        System.out.println(removeKDigits(num, k));
        sc.close();
    }
    private static String removeKDigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for(char digit : num.toCharArray()) {
            while(k > 0 && !stack.isEmpty() && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        while(k-- > 0) {
            stack.pop();
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        return result.length() > 0 ? result.toString() : "0";
    }
}