class Pair {
    int ele;
    int freq;

    Pair(int e, int f) {
        ele = e;
        freq = f;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < n; i++) {
            h.put(nums[i], h.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> { return b.freq - a.freq; });

        for (Map.Entry<Integer, Integer> it : h.entrySet()) {
            int ele = it.getKey();
            int freq = it.getValue();
            Pair p = new Pair(ele, freq);
            pq.add(p);
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            Pair p = pq.poll();
            ans[i] = p.ele;
        }

        return ans;
    }
}
