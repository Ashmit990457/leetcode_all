class Solution {
    int dp[];
    int prev[];
    int m = 1_000_000_007;

    public int distinctSubseqII(String s) {
        int n = s.length();

        dp = new int[n + 1];
        prev = new int[n + 1];

        Arrays.fill(dp, -1);

        int temp[] = new int[26];

        for (int i = 1; i <= n; i++) {
            int idx = s.charAt(i - 1) - 'a';

            prev[i] = temp[idx];
            temp[idx] = i;
        }

        return (dfs(n) - 1 + m) % m;
    }

    int dfs(int n) {
        if (n == 0) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        long total = (2L * dfs(n - 1)) % m;

        int dup = 0;

        if (prev[n] != 0) {
            dup = dfs(prev[n] - 1);
        }

        return dp[n] = (int)((total - dup + m) % m);
    }
}