class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int h = n - 1;
        int res = Integer.MAX_VALUE;

        while (l <= h) {
            int m = l + (h - l) / 2;

            if (nums[m] > nums[n - 1]) {
                l++;
            } else {
                res = nums[m];
                h = m - 1;
            }
        }
        return res;
    }
}
