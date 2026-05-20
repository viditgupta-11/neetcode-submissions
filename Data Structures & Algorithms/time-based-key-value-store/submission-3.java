class TimeMap {
    class ValueNode {
        String value;
        int timestamp;

        public ValueNode(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    Map<String, List<ValueNode>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        ValueNode valueNode = new ValueNode(value, timestamp);
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(valueNode);
    }
    
    public String get(String key, int timestamp) {
        List<ValueNode> list = map.get(key);
        if (list == null) {
            return "";
        }
        String ans = "";
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                ans = list.get(mid).value;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
