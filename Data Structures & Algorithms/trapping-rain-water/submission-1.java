class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int mxL = 0;
        int mxR = 0;
        int res = 0;
        while (l <= r){
            if (height[l] <= height[r]){
                if (height[l] > mxL){
                    mxL = height[l];
                }
                else {
                    res += mxL - height[l];
                }
                l++;
            }
            else {
                if (height[r] >= mxR){
                    mxR = height[r];
                }
                else {
                    res += mxR - height[r];
                }
                r--;
            }
        }
        return res;
    }
}
