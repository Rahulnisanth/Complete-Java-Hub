import java.util.*;

public class PileStoneGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        List<Integer> piles = extractSequence(input);
        System.out.println(Arrays.toString(piles.toArray()));
        System.out.println(willRamWins(piles));
        sc.close();
    }
    private static boolean willRamWins(List<Integer> piles) {
        int ram = 0, krishna = 0;
        for(int i = 0; i < piles.size(); i++) {
            if(i % 2 == 0) {
                ram += piles.get(i);
            } else {
                krishna += piles.get(i);
            }
        }
        return ram > krishna;
    }
    private static List<Integer> extractSequence(String input) {
        List<Integer> sequence = new ArrayList<>();
        
        input = input.replaceAll("\\[|\\]", "");
        
        String[] parts = input.split(",\\s*");
        for (String part : parts) {
            sequence.add(Integer.parseInt(part.trim()));
        }
        
        return sequence;
    }
}
