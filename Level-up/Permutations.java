import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        List<String> permutations = new ArrayList<>();
        generatePermutations(word, "", new boolean[word.length()], permutations);
        permutations.sort(null);
        System.out.println(permutations.size());
        for(String results : permutations){
            System.out.print("[" + results + "] ");
        }
        sc.close();
    }
    public static void generatePermutations(String word, String current, boolean[] used, List<String> permutations) {
        if(current.length() == word.length()){
            permutations.add(current);
            return;
        } else {
            for(int i = 0; i < word.length(); i++) {
                if(!used[i]){
                    used[i] = true;
                    generatePermutations(word, current + word.charAt(i), used, permutations);
                    used[i] = false;
                }
            }
        }
    }
}
