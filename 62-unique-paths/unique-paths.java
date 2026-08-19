class Solution {
    int dp[][];
    public int uniquePaths(int m, int n) {
        dp=new int[m+1][n+1];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=dfs(0,0,m,n);
        return ans;
    }
    int dfs(int i,int j,int m,int n){
        if(i>=m||j>=n){
            return 0;
        }
        if(i==m-1&&j==n-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans1=dfs(i+1,j,m,n);
        int ans2=dfs(i,j+1,m,n);
        return dp[i][j]=ans1+ans2;
    }
    
}