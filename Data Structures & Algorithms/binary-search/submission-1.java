class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int h = n - 1;

        while (l <= h) {
            int m = l + (h - l) / 2;
            if (nums[m] == target) return m;
            else if (target > nums[m]) l++;
            else h--;
        }

        return -1;
    }
}
