class Solution {
    public int longestConsecutive(int[] nums) {
              int res = 0;
        int N = nums.length;
        HashSet<Integer> h = new HashSet<>();
        for (int i = 0; i < N; i++) {
            h.add(nums[i]);
        }

        for (int i = 0; i < N; i++) {
            if (!h.contains(nums[i] - 1)){
                int currNum = nums[i];
                int currStreak = 1;

                while (h.contains(currNum + 1)){
                    currNum += 1;
                    currStreak += 1;
                }
                res = Math.max(res, currStreak);
            }


        }
        return res;
    }
}
