class Solution {
    public String minWindow(String s, String t) {
        // Brute Force Approach
        int[] need = new int[256];
        int[] window = new int[256];
        int l = 0, h = 0;
        int minLen = Integer.MAX_VALUE;
        String ans = "";

        for (char c : t.toCharArray()) {
            need[c]++;
        }

        while (h < s.length()) {
            window[s.charAt(h)]++;

            while (containsAll(window, need)) { // can't use Arrays.equals(window, need) because
                                                // character count can be more but not less
                if (h - l + 1 < minLen) {
                    minLen = h - l + 1;
                    ans = s.substring(l, h + 1);
                }
                window[s.charAt(l)]--;
                l++;
            }
            h++;
        }
        return ans;
    }
    public static boolean containsAll(int[] window, int[] need) {
        for (int i = 0; i < 256; i++) {
            if (window[i] < need[i]) return false;
        }
        return true;
    }
}
