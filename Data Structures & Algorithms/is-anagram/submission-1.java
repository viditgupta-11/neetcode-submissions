class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char sch : s.toCharArray()) {
            map.put(sch, map.getOrDefault(sch, 0) + 1);
        }
        for (char tch : t.toCharArray()) {
            if (!map.containsKey(tch)) {
                return false;
            }
            map.put(tch, map.get(tch) - 1);
            if (map.get(tch) == 0) {
                map.remove(tch);
            }
        }
        return map.isEmpty();
    }
}
