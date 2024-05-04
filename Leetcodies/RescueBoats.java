import java.util.Arrays;
import java.util.Scanner;

public class RescueBoats {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] people = new int[n];
        for(int i=0;i<n;i++) {
            people[i] = sc.nextInt();
        }
        int limit = sc.nextInt();
        System.out.println(numRescueBoats(people, limit));
        sc.close();
    }
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int start = 0, end = people.length - 1;
        int boats = 0;
        while(start <= end) {
            if(people[start] + people[end] <= limit) {
                start++;
            }
            end--;
            boats++;
        }
        return boats;
    }
}
