class Solution {
    public int maxArea(int[] heights) {
        int ans = 0, l = 0, r = heights.length - 1;
        while (l < r) {
            int amt = Math.min(heights[l] , heights[r]) * (r - l);
            ans = Math.max(ans, amt);
            if (heights[l] > heights[r]) {
                r--;
            } else {
                l++;
            }
        }
        return ans;
    }
}
