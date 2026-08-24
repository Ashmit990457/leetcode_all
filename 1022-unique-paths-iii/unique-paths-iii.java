class Solution {
    int x[] = { 1, -1, 0, 0 };
    int y[] = { 0, 0, 1, -1 };
int ans=0;
int count0=0;
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int st=0;
        int end=0;
        int vis[][] = new int[n][m];
        boolean isstart = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
              count0++;
                }

                if (grid[i][j] == 1) {
               st=i;
               end=j;
                }

            }
            
        }
         dfs(grid, st, end,n,m,vis,count0);
        return ans;

    }

    void dfs(int grid[][], int i, int j, int n, int m, int vis[][],int count0) {
        if (grid[i][j] == 2&&count0==0) {
            ans++;
            return;
        }
        if (grid[i][j] == -1) {
            return;
        }
        if (vis[i][j] == 1) {
            return;
        }
        if(grid[i][j]==0){count0--;}
        vis[i][j] = 1;
        for(int k=0;k<4;k++){
            int r=x[k]+i;
            int c=y[k]+j;
            boolean valid=isvalid(r,c,n,m);
            if(valid==true&&vis[r][c]==0){
                dfs(grid,r,c,n,m,vis,count0);
               
            }
        }
         vis[i][j]=0;

    }

    boolean isvalid(int i, int j, int n, int m) {
        if (i >= n || i < 0 || j >= m || j < 0) {
            return false;
        }
        return true;
    }
}