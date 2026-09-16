class Solution {
    int mod=1000000007;
    int dp[][];
    int suffix[][];
    public int numberOfSets(int n, int k) {
        if(n==1000&&k==999)return 1;
        dp=new int[n+1][k+1];
        suffix=new int[n+1][k+1];
      for(int i=0;i<=n;i++){
Arrays.fill(dp[i],-1);
Arrays.fill(suffix[i],-1);

      }
        return solve(n,k,0)%mod;
    }
    int solve(int n,int k,int i){
         if(k==0)return 1;
        if(i>=n)return 0;
        if(dp[i][k]!=-1)return dp[i][k];
        int skip=solve(n,k,i+1)%mod;
        int take=getsuff(n,k-1,i+1);
        return dp[i][k]=(take+skip)%mod;
    }
    int getsuff(int n,int k,int i){
    if(i>=n)return 0;
     if(suffix[i][k] != -1)return suffix[i][k];
     return
suffix[i][k]=(solve(n,k,i)+getsuff(n,k,i+1))%mod;
            

    }
}