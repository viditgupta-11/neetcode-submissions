class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0, l = 0;
        for (int i = 0; i < s.length(); i++) {
            char sch = s.charAt(i);
            if (map.containsKey(sch)) {
                l = Math.max(l, map.get(sch) + 1);
            }
            map.put(sch, i);
            ans = Math.max(ans, i - l + 1);
        }
        return ans;
    }
}
