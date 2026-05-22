class Solution {
    public boolean isValid(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                dq.addFirst(ch);
            } else if (dq.isEmpty() || (ch == ')' && dq.getFirst() != '(') || (ch == ']' && dq.getFirst() != '[') || (ch == '}' && dq.getFirst() != '{')) {
                return false;
            } else {
                dq.removeFirst();
            }
        }
        return dq.isEmpty();
    }
}
