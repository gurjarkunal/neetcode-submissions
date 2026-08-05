class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> h = new HashMap<>();
        int i = 0;
        int j = 0;
        int n = s.length();
        int ans = 0;

        while (j < n) {
            h.put(s.charAt(j), h.getOrDefault(s.charAt(j), 0) + 1);
            if (h.get(s.charAt(j)) > 1){
                h.remove(s.charAt(i));
                i++;
            }else {
                j++;
                ans = Math.max(ans, j - i);
            }
        }

        return ans;
    }
}
