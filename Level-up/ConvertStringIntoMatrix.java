import java.util.*;
public class ConvertStringIntoMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        convertAndPrint(input);
        sc.close();
    }
    private static void  convertAndPrint(String input) {
        String buffer = input.substring(1, input.length() - 1);
        String[] rows = buffer.split("\\},\\{");
        for(String row : rows) {
            row = row.replace("{","").replace("}","");
            String[] numbers = row.split(",");
            for(String number : numbers) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
