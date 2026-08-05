
class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> h = new HashMap<>();
        int n = s.length();
        int low = 0;
        int maxF = 0;
        int ans = 0;

        for (int high = 0; high < n; high++) {
            h.put(s.charAt(high), h.getOrDefault(s.charAt(high), 0) + 1);
            maxF = Math.max(maxF, h.get(s.charAt(high)));

            while ((high - low + 1) - maxF > k) {
                h.put(s.charAt(low), h.get(s.charAt(low)) - 1);

                if (h.get(s.charAt(low)) == 0) {
                    h.remove(s.charAt(low));
                }
                low++;
            }

            ans = Math.max(ans, (high - low + 1));
        }
        return ans;
    }
}
