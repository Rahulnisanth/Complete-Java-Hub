import java.util.*;
public class ArrayGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        if(t >= 1 && t <= 10) {
            for(int i = 0;i < t; i++) {
                int n = sc.nextInt();
                if(n >= 1 && n <= 105){
                    int[] arr = new int[n];
                    for(int j = 0; j < n; j++) {
                        arr[i] = sc.nextInt();
                        if(arr[i] < 1 && arr[i] > 109) {
                            System.out.println(-1);
                            break;
                        }
                    }
                    System.out.println(findWinner(arr));
                } else {
                    System.out.println(-1);
                }
            }
        } else {
            System.out.println(-1);
        }
        sc.close();
    }
    private static String findWinner(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[i - 1]){
                return "Ashish";
            }
        }
        return "Jeel";
    }
}


