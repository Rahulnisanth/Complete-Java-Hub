import java.util.*;
public class ValidUTF8 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        List<Integer> list = extractSequence(input);
        System.err.println(validUtf8(list));

        sc.close();
    }
    
    public static boolean validUtf8(List<Integer> data) {
        int remainingBytes = 0;
        for (int value : data) {
            // If this byte is a leading byte
            if (remainingBytes == 0) {
                if ((value & 0b10000000) == 0) { // 1-byte character
                    remainingBytes = 0;
                } else if ((value & 0b11100000) == 0b11000000) { // 2-byte character
                    remainingBytes = 1;
                } else if ((value & 0b11110000) == 0b11100000) { // 3-byte character
                    remainingBytes = 2;
                } else if ((value & 0b11111000) == 0b11110000) { // 4-byte character
                    remainingBytes = 3;
                } else {
                    return false; // Invalid leading byte
                }
            } else {
                // If this byte is not a leading byte, it must start with 10
                if ((value & 0b11000000) != 0b10000000) {
                    return false;
                }
                remainingBytes--;
            }
        }
        return remainingBytes == 0;
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
