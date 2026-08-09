class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int hi = 0;
        int n = piles.length;
        int minHours = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            hi = Math.max(hi, piles[i]);
        }

        while (l < hi) {
            int m = l + (hi - l) / 2;
            int totalHours = calHours(piles, m, n);
            if (totalHours <= h) {
                hi = m;
            } else
                l = m + 1;
        }
        return l;
    }

    public int calHours(int[] piles, int m, int n) {
        int totalHours = 0;
        for (int i = 0; i < n; i++) {
            totalHours += piles[i] / m;
            if (piles[i] % m != 0) {
                totalHours++;
            }
        }
        return totalHours;
    }
}
