import java.util.*;
public class GrayCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        List<Integer> list = extractSequence(input);
        System.err.println(isGrayCode(list));

        sc.close();
    }
    
    public static boolean isGrayCode(List<Integer> sequence) {
        int n = sequence.size();
        if(n <= 1){
            return true;
        } else {
            for(int i = 1; i < n; i++) {
                if(Integer.bitCount(sequence.get(i) ^ sequence.get(i - 1)) != 1){
                    return false;
                }
            }
            if(Integer.bitCount(sequence.get(0) ^ sequence.get(n - 1)) != 1){
                return false;
            }
        }
        return true;
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