import java.util.*;
public class BestTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int i = 0;i < n; i++) {
            prices[i] = sc.nextInt();
        }
        System.out.println(maxProfit(prices));
        sc.close();
    }
    private static int maxProfit(int[] prices) {
        int firstBuy = -prices[0], secondBuy = -prices[0];
        int first_profit = 0, total_profit = 0;
        for(int price : prices) {
            firstBuy = Math.max(firstBuy, -price);
            first_profit = Math.max(first_profit, firstBuy + price);
            secondBuy = Math.max(secondBuy, first_profit - price);
            total_profit = Math.max(total_profit, price + secondBuy);
        }
        return total_profit;
    }
}

