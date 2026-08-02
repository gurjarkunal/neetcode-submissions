class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int [] a1 = new int[26];
        int [] a2 = new int[26];
        for (int i = 0; i < s.length(); i++){
            int idx = s.charAt(i) - 'a';
            a1[idx]++;
        }
        for (int i = 0; i < t.length(); i++){
            int idx = t.charAt(i) - 'a';
            a2[idx]++;
        }
        for (int i = 0; i < 26; i++){
            if (a1[i] != a2[i]) return false;
        }
        return true;
    }
}
