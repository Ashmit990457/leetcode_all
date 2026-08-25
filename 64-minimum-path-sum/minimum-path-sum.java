class Solution {
   HashMap<String,Integer>dp;
    public int minPathSum(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        dp=new HashMap<>();
        
        int ans=dfs(grid,0,0,n,m);
        return ans;
    }
    int dfs(int[][]arr,int i,int j,int n,int m){
       if(i>=n||j>=m){
          return 0;
        }
        if(i==n-1&&j==m-1){
          return arr[i][j];
        }
        String key=i+"-"+j;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
         int ans2=Integer.MAX_VALUE;
        int ans1=Integer.MAX_VALUE;
        if(i+1<n){
     ans1=dfs(arr,i+1,j,n,m);
        }
        if(j+1<m){
       ans2=dfs(arr,i,j+1,n,m);
        }
       int ans=arr[i][j]+Math.min(ans1,ans2);
        dp.put(key,ans);
        return dp.get(key);
        
    }
}