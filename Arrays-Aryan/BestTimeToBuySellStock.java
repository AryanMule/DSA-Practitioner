public class BestTimeToBuySellStock {

    // Approach 1: Brute Force (O(n²))
    // Try buying on every day and selling on every future day
    public static int maxProfitBruteForce(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    // Approach 2: Optimized (O(n)) - Kadane’s Concept
    // Track minimum buying price so far and max profit possible
    public static int maxProfitOptimized(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < buyPrice) {
                buyPrice = price; // Found new cheaper day to buy
            } else {
                int profit = price - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }

    // Driver Code
    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};

        System.out.println("Brute Force Profit: " + maxProfitBruteForce(prices1)); // 5
        System.out.println("Optimized Profit: " + maxProfitOptimized(prices1));    // 5

        System.out.println("Brute Force Profit: " + maxProfitBruteForce(prices2)); // 0
        System.out.println("Optimized Profit: " + maxProfitOptimized(prices2));    // 0
    }
}
