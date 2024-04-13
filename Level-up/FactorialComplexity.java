import java.util.*;
public class FactorialComplexity {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0;i < t; i++){
            int num = sc.nextInt();
            List<Integer> result =  leadingFactorials(num);
            System.out.println(result.size());
            formatPrint(result);
        }
        sc.close();
    }
    private static List<Integer> leadingFactorials(int num) {
        List<Integer> result = new ArrayList<>();
        int low = 0, high = (int)1e6;
        while(low < high) {
            int mid = (low + high) / 2;
            if(facts(mid) < num){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        for(int i = low;i < low + 5; i++) {
            if(facts(i) == num) {
                result.add(i);
            }
        }
        return result;
    }
    private static int facts(int num) {
        int count = 0;
        while(num != 0) {
            num /= 5;
            count += num;
        }
        return count;
    }
    private static void formatPrint(List<Integer> list) {
        for(int num : list) {
            System.out.print(num + " ");
        }
    }
}