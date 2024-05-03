import java.util.Arrays;
import java.util.Scanner;

public class ZigZagOrder {
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void zigzag(int[] array, int n) {
        boolean temp = true;
        for (int i = 0; i < n - 1; i++) {
            if (temp) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
                temp = false;
            } else {
                if (array[i] < array[i + 1]) {
                    swap(array, i, i + 1);
                }
                temp = true;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        zigzag(array, n);
        System.out.println(Arrays.toString(array));
        sc.close();
    }
}

