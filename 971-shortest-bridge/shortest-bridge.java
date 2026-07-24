class Solution {
    int x[] = {1, -1, 0, 0};
    int y[] = {0, 0, 1, -1};

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        boolean vis[][] = new boolean[n][m];

        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (found) break;
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, vis, q, n, m);
                    found = true;
                    break;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = temp.row + x[i];
                int nc = temp.col + y[i];

                if (!isValid(nr, nc, n, m) || vis[nr][nc])
                    continue;

                if (grid[nr][nc] == 1)
                    return temp.val;

                vis[nr][nc] = true;
                q.add(new Pair(nr, nc, temp.val + 1));
            }
        }

        return -1;
    }

    void dfs(int[][] grid, int r, int c, boolean vis[][],
             Queue<Pair> q, int n, int m) {

        if (!isValid(r, c, n, m) || vis[r][c] || grid[r][c] == 0)
            return;

        vis[r][c] = true;
        q.add(new Pair(r, c, 0));

        for (int i = 0; i < 4; i++) {
            dfs(grid, r + x[i], c + y[i], vis, q, n, m);
        }
    }

    boolean isValid(int r, int c, int n, int m) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}

class Pair {
    int row, col, val;

    Pair(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}