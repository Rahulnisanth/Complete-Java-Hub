import java.util.*;

public class WonderfulSubstrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        System.out.println(wonderfulSubstrings(word));
        sc.close();
    }
    private static long wonderfulSubstrings(String word) {
        long[] count = new long[1024];
        long result = 0;
        int xor = 0;
        count[xor] = 1;
        for(char ch : word.toCharArray()) {
            int idx = ch - 'a';
            xor ^= 1 << idx;
            result += count[xor];
            for(int i = 0; i < 10; i++) {
                result += count[xor ^ (1 << i)];
            }
            count[xor] += 1;
        }
        return result;
    }
}
