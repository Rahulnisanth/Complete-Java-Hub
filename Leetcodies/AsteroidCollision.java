import java.util.*;
public class AsteroidCollision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] asteroids = new int[n];
        for(int i = 0; i < n; i++) {
            asteroids[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
        sc.close();
    }
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int item : asteroids) {
            if(item > 0) {
                stack.push(item);
            } else {
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(item))
                    stack.pop();
                if(stack.isEmpty() || stack.peek() < 0)
                    stack.push(item);
                else if(stack.peek() + item == 0)
                    stack.pop();
            }
        }
        // Making array -->
        int[] result = new int[stack.size()];
        for(int i = result.length - 1; i>= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
