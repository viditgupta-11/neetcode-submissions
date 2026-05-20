class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], height[i - 1]);
            suffix[n - i - 1] = Math.max(suffix[n - i], height[n - i]);
        }

        for (int i = 0; i < n; i++) {
            int amt = Math.min(prefix[i], suffix[i]) - height[i];
            if (amt > 0) {
                ans += amt;
            }
        }
        return ans;
    }
}
