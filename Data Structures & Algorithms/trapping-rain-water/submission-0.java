class Solution {
    public int[] getLeftMax(int[] h, int n) {
        int[] leftMax = new int[n];
        leftMax[0] = h[0];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], h[i]);
        }

        return leftMax;
    }

        public int[] getRightMax(int[] h, int n) {
        int[] rightMax = new int[n];
        rightMax[n - 1] = h[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], h[i]);
        }

        return rightMax;
    }

    public int trap(int[] height) {
        int sum = 0;
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left = getLeftMax(height, n);
        right = getRightMax(height, n);
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        for (int i = 0; i < n; i++) {
            int h = Math.min(left[i], right[i]) - height[i];
            sum += h;
        }

        return sum;
    }
}
