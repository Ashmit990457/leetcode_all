class Solution {
    int dp[][];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        dp=new int[n+1][m+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
          if(obstacleGrid[0][0]==1||obstacleGrid[n-1][m-1]==1){return 0;}
        int ans=dfs(obstacleGrid,0,0,n,m);
        return ans;

    }
    int dfs(int[][]arr,int i,int j,int n,int m){
        if(i>=n||j>=m){return 0;}
        if(i==n-1&&j==m-1){
            return 1;
        }
        if(isvalid(i,j,n,m)&&arr[i][j]==1){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans1=dfs(arr,i+1,j,n,m);
        int ans2=dfs(arr,i,j+1,n,m);
        return dp[i][j]=ans1+ans2;
    }
    boolean isvalid(int i,int j,int n,int m){
        if(i>=n||i<0||j>=m||j<0){return false;}
        return true;
    }
}