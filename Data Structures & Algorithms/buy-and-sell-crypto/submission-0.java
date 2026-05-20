class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0, l = 0;
        for (int r = 1; r < prices.length; r++) {
            if (prices[l] < prices[r]) {
                ans = Math.max(ans, prices[r] - prices[l]);
                continue;
            }
            l = r;
        }
        return ans;
    }
}
