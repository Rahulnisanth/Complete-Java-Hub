import java.util.*;
/*
 * Counting the possible odd pairs in the two arrays 
 */
public class OddPairCount {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            // First array
            String firstArrayInput = sc.nextLine().replace("{", "").replace("}", "");
            String[] firstArrayElements = firstArrayInput.split(", ");
            ArrayList<Integer> firstArray = new ArrayList<>();
            for (String element : firstArrayElements) {
                firstArray.add(Integer.parseInt(element));
            }
            // Second array 
            String secondArrayInput = sc.nextLine().replace("{", "").replace("}", "");
            String[] secondArrayElements = secondArrayInput.split(", ");
            ArrayList<Integer> secondArray = new ArrayList<>();
            for (String element : secondArrayElements) {
                secondArray.add(Integer.parseInt(element));
            }
            // Core problem
            if (!firstArray.isEmpty() && !secondArray.isEmpty()) {
                int _count1 = 0;
                for (int num : firstArray) {
                    if ((num & 1) == 1) {
                        _count1++;
                    }
                }
                int _count2 = 0;
                for (int num : secondArray) {
                    if ((num & 1) == 1) {
                        _count2++;
                    }
                }
                int _total = _count1 * _count2;
                if (_total != 5001) {
                    System.out.println(_total);
                } else {
                    System.out.println(_total - 1);
                }
            }
            sc.close();
        } catch (NumberFormatException e) {
            // ValueError catch block ...
            System.out.println("");
        }
    }
}

