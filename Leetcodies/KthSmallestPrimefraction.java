import java.util.*;

public class KthSmallestPrimefraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(arr, k)));
        sc.close();
    }
    private static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        Queue<int[]> heap = new PriorityQueue<>(Comparator.comparingDouble(array -> (double) array[0] / array[1]));

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                heap.offer(new int[] { arr[i], arr[j] });
            }
        }

        int[] result = null;
        for (int i = 0; i < k; i++) {
            result = heap.poll();
        }
        return result;
    }
}