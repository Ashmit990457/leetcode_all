class Solution {
    int[][]dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp=new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<text1.length();i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=dfs(text1,text2,0,0,text1.length(),text2.length());
        return ans;
        
    }
    int dfs(String t1,String t2,int i,int j,int n,int m){
        if(i>=n||j>=m){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if(t1.charAt(i)==t2.charAt(j)){
ans=1+dfs(t1,t2,i+1,j+1,n,m);
        }
        int ans1=dfs(t1,t2,i+1,j,n,m);
        int ans2=dfs(t1,t2,i,j+1,n,m);
        return dp[i][j]=Math.max(ans1,Math.max(ans2,ans));
    }
}