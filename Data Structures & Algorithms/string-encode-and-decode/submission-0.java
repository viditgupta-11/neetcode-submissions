class Solution {
    Map<String, List<String>> map = new HashMap<>();
    public String encode(List<String> strs) {
        String str = UUID.randomUUID().toString();
        map.put(str, strs);
        return str;
    }

    public List<String> decode(String str) {
        return map.get(str);
    }
}
