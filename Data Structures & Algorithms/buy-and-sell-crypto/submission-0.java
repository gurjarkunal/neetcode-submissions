class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = prices[j] - prices[i];
                if (sum > 0) {
                    maxProfit = Math.max(sum, maxProfit);
                }
            }
        }
        return maxProfit;
    }
}
