import java.util.*;
/**
 * MaxAreaRectange
 */
public class MaxAreaRectange {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        List<Integer> list = extractSequence(input);
        System.out.println(maxAreaRectangle(list));
        sc.close();
    }
    private static int maxAreaRectangle(List<Integer> heights) {
        // Converting to array :
        int[] array = heights.stream().mapToInt(i -> i).toArray();
        int maxArea = 0, n = array.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i <= n; i++) {
            int height = i == n ? 0 : array[i];
            while(!stack.isEmpty() && height < array[stack.peek()]) {
                int top = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = array[top] * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.add(i);
        }
        return maxArea;
    }
    public static List<Integer> extractSequence(String input) {
        List<Integer> sequence = new ArrayList<>();
        
        input = input.replaceAll("\\[|\\]", "");
        
        String[] parts = input.split(",\\s*");
        for (String part : parts) {
            sequence.add(Integer.parseInt(part.trim()));
        }
        
        return sequence;
    }
}