import java.util.*;

public class RemoveToMakeValid {
    private String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> idx = new HashSet<>();
        for(int i = 0;i < s.length(); i++) {
            char letter = s.charAt(i);
            if(letter == '(') {
                stack.add(i);
            } else if(letter == ')') {
                if(!stack.isEmpty())
                    stack.pop();
                else
                    idx.add(i);
            }
        }
        idx.addAll(stack);
        StringBuilder result = new StringBuilder();
        for(int i = 0;i < s.length(); i++) {
            if(!idx.contains(i)) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        RemoveToMakeValid obj = new RemoveToMakeValid();
        System.out.println(obj.minRemoveToMakeValid(s));
        sc.close();
    }
}