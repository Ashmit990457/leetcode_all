class Solution {
    Boolean[]dp;
    public boolean winnerSquareGame(int n) {
        dp=new Boolean [n+1];
    boolean ans=dfs(n);
         
return ans;
        
    }
    boolean dfs(int n){
if(n==0){
    return false;
}
        if(dp[n]!=null){return dp[n];}
        for(int i=1;i*i<=n;i++){
            if(!dfs(n-i*i)){
                dp[n]=true;
return true;
}
        }
dp[n]=false;
            return false;
    }
}