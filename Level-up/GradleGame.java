import java.util.*;
/**
 * GradleGame
 */
public class GradleGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(willGradleWins(input));
        sc.close();
    }
    private static boolean willGradleWins(String input) {
        int leftSum = 0, rightSum = 0;
        int count = 0;
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '?') {
                count++;
            } else if(i < input.length() / 2) {
                leftSum += input.charAt(i) - '0';
            } else {
                rightSum += input.charAt(i) - '0';
            }
        }
        if(count == 0) {
            return leftSum != rightSum;
        } else {
            return count % 2 == 0;
        }
    }

}