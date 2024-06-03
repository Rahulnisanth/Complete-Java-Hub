import java.util.*;

public class ExtractNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        for(int i = 0;i < test_case; i++) {
            String input = sc.nextLine();
            List<Integer> result = findNumbersOtherThanNine(input);
            for(int num : result) {
                System.out.print(num + " ");
            }
        }
        sc.close();
    }
    private static List<Integer> findNumbersOtherThanNine(String input) {
        String[] string_numbers = input.split("\\D+");
        List<Integer> nums = new ArrayList<>();
        for(String string_number : string_numbers) {
            try{
                int num = Integer.parseInt(string_number);
            if(!isNineThere(num)) nums.add(num);
            } catch(NumberFormatException e) {
                continue;
            }
        }
        return nums;
    }
    private static boolean isNineThere(int num) {
        while(num != 0) {
            int rem = num % 10;
            if(rem == 9) return true;
            num /= 10;
        }
        return false;
    }
}
