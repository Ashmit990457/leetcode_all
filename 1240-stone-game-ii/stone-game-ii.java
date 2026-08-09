class Solution {
     int suff[];
     int dp[][];
    public int stoneGameII(int[] piles) {
        int n=piles.length;
     suff=new int[piles.length+1];
     dp=new int[n][n+1];
     
      for(int i=piles.length-1;i>=0;i--){
        suff[i]=suff[i+1]+piles[i];
      }  
int ans=dfs(piles,n,0,1);
return ans;
    }
    int dfs(int[]arr,int n,int idx,int m){
if(idx>=n){
    return 0;
}
if(dp[idx][m]!=0){
    return dp[idx][m];
}
int total=suff[idx];
int best=0;
int taken=0;
for(int x=1;x<=2*m&&idx+x<=n;x++){
    taken+=arr[idx+x-1];
    int newm=Math.max(m,x);
    int oppobest=dfs(arr,n,idx+x,newm);
    int curr=total-oppobest;
    best=Math.max(best,curr);
}
return dp[idx][m]=best;
    }
}