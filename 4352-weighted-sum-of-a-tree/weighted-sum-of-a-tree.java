class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int n = parent.length;
        ArrayList<Integer>[] child = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            child[i] = new ArrayList<>();
        }

        
        for (int i = 1; i < n; i++) {
            child[parent[i]].add(i);
        }

        int[] dep = new int[n];
        dep[0] = 1;

        int hei = 1;

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int c : child[node]) {
                dep[c] = dep[node] + 1;
                hei = Math.max(hei, dep[c]);
                q.offer(c);
            }
        }
        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans += (long) nums[i] * (hei - dep[i] + 1);
        }

        return ans;
    }
}