import java.util.*;
public class StepsToReduceBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String seq = sc.next();
        System.out.println(numSteps(seq));
        sc.close();
    }
    private static int numSteps(String s) {
        System.out.println(Integer.parseInt(s, 2));
        return helper(Integer.parseInt(s, 2), 0);
    }
    private static int helper(int num, int steps) {
        if(num == 1) {
            return steps;
        } if (num % 2 != 0) {
            return helper(num + 1, steps + 1);
        } if(num % 2 == 0) {
            return helper(num / 2, steps + 1);
        }
        return steps;
    }
}
