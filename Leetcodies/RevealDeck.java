import java.util.*;
public class RevealDeck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        List<Integer> list = extractSequence(input);
        System.err.println(Arrays.toString(revealDeck(list)));
        sc.close();
    }
    
    public static int[] revealDeck(List<Integer> deck) {
        Collections.sort(deck);
        int n = deck.size();
        int[] result = new int[n];
        Deque<Integer> indices = new LinkedList<>();
        for(int i = 0; i < deck.size(); i++) {
            indices.offerLast(i);
        }
        for(int card : deck) {
            int idx = indices.pollFirst();
            result[idx] = card;
            if(!indices.isEmpty()) 
                indices.offerLast(indices.pollFirst());
        }
        return result;
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
