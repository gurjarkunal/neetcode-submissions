class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] prevRes = previousSmaller(heights, n);
        int[] nextRes = nextSmaller(heights, n);
        int res = 0;
        // System.out.println(Arrays.toString(prevRes));
        // System.out.println(Arrays.toString(nextRes));
        for (int i = 0; i < n; i++) {
            int curr = (nextRes[i] - prevRes[i] - 1) * heights[i];
            res = Math.max(res, curr);
        }
        return res;
    }

    public int[] previousSmaller(int[] h, int n) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        res[0] = -1;
        st.push(0);

        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && h[st.peek()] > h[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                res[i] = -1;
            } else if (h[st.peek()] < h[i]) {
                res[i] = st.peek();
            } else {
                res[i] = res[st.peek()];
            }

            st.push(i);
        }
        return res;
    }
    public int[] nextSmaller(int[] h, int n) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        res[n - 1] = n;
        st.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && h[st.peek()] > h[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                res[i] = n;
            } else if (h[st.peek()] < h[i]) {
                res[i] = st.peek();
            } else {
                // Equal height
                res[i] = res[st.peek()];
            }
            st.push(i);
        }
        return res;
    }
}
