import java.util.Scanner;

public class ClimbStair {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findCountStairs(n));
        sc.close();
    }
    public static int findCountStairs(int n) {
        int total = 0;
        int _oneBefore = 1, _twoBefore = 1;
        for(int i = 2; i <= n; i++){
            total = _oneBefore + _twoBefore;
            _twoBefore = _oneBefore;
            _oneBefore = total;
        }
        return total;
    }
}