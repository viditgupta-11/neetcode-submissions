class Solution {
    private boolean isPossible(char[] sc1, char[] sc2) {
        for (int i = 0; i < 26; i++) {
            if (sc1[i] != sc2[i]) {
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        char[] sc1 = new char[26];
        char[] sc2 = new char[26];

        for (char sch1 : s1.toCharArray()) {
            sc1[sch1 - 'a']++;
        }
        int ans = 0, l = 0;
        for (int r = 0; r < s2.length(); r++) {
            sc2[s2.charAt(r) - 'a']++;
            if (r - l + 1 == s1.length()) {
                boolean check = isPossible(sc1, sc2);
                if (check) {
                    return check;
                }
                sc2[s2.charAt(l) - 'a']--;
                l++;
            }
        }
        return false;
    }
}
