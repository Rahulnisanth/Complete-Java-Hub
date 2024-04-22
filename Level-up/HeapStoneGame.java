import java.util.*;
public class HeapStoneGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stones = sc.nextInt();
        System.out.println(predictWinner(stones));
        sc.close();
    }
    private static boolean predictWinner(int stones) {
        return (stones % 4) != 0;
    }
}
