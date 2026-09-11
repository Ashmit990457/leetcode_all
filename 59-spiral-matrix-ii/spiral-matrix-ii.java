class Solution {
    public int[][] generateMatrix(int n) {
        boolean vis[][]=new boolean[n][n];
        int[][]ans=new int[n][n];
        int it=n*n;
        int i=0;int j=0;
        int count=1;
        while(count<=it){
      while(j<n&&vis[i][j]==false){
        vis[i][j]=true;
        ans[i][j]=count;
        count++;
        j++;
      }
      i++;
j--;
       while(i<n&&vis[i][j]==false){
         vis[i][j]=true;
        ans[i][j]=count;
        count++;
        i++;
      }
   i--;
      j--;
      while(j>=0&&vis[i][j]==false){
         vis[i][j]=true;
        ans[i][j]=count;
        count++;
        j--;
      }
      i--;
     j++;
      while(i>=0&&vis[i][j]==false){
         vis[i][j]=true;
        ans[i][j]=count;
        count++;
        i--;
      }
      i++;
      j++;
    }
      return ans;

    }
}