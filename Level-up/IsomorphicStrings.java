import java.util.*;

public class IsomorphicStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        String test = sc.nextLine();
        System.err.println(checkIsomorphic(target, test));
        sc.close();
    }
    private static boolean checkIsomorphic(String target, String test) {
        if(target.length() != test.length()){
            return false;
        } else {
            Map<Character, Character> map = new HashMap<>();
            for(int i = 0;i < target.length(); i++){
                if(map.containsKey(target.charAt(i))){
                    if(map.get(target.charAt(i)) != test.charAt(i)){
                        return false;
                    }
                } else {
                    if(map.containsValue(test.charAt(i))){
                        return false;
                    }
                    map.put(target.charAt(i), test.charAt(i));
                }
            }
            return true;
        }
    }
}
