class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char sch : s.toCharArray()) {
            if ((sch >='A' && sch <= 'Z') || (sch >='a' && sch <= 'z') || (sch >='0' && sch <= '9')) {
                sb.append(sch);
            }
        }
        String str = sb.toString().toLowerCase();
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
