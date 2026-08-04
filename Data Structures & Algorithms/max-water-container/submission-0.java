class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int i = 0;
        int j = heights.length - 1;

        while (i < j) {
            int h = 0;
            int w = 0;
            h = Math.min(heights[i], heights[j]);
            w = j - i;
            maxArea = Math.max(maxArea, h * w);
            if (heights[i] > heights[j])
                j--;
            else
                i++;
        }
        return maxArea;
    }
}
