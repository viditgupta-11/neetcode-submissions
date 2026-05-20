class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String strNew = new String(s);
            List<String> val = new ArrayList<>();
            if (map.containsKey(strNew)) {
                val = map.get(strNew);
            }
            val.add(str);
            map.put(strNew, val);
        }

        List<List<String>> ans = new ArrayList<>();
        for (String key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }
}
