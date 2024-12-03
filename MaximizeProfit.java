public class MaximizeProfit {
    public static int maximizeProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0; 

        int minPrice = Integer.MAX_VALUE; 
        int maxProfit = 0; 

        for (int i = 0; i < n; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {2, 3, 5};
        int[] prices2 = {8, 5, 1};

        System.out.println("Maximum Profit (Example 1): " + maximizeProfit(prices1)); 
        System.out.println("Maximum Profit (Example 2): " + maximizeProfit(prices2)); 
    }
}
