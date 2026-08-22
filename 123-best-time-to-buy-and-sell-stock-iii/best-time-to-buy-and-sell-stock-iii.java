class Solution {
    int dp[][];
    public int maxProfit(int[] prices) {
        dp=new int[prices.length+1][5];
        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=dfs(prices,0,4,prices.length);
        return ans;
    }
    int dfs(int arr[],int i,int k,int n){
        if(i>=n){return 0;}
        if(k==0){return 0;}
        if(dp[i][k]!=-1){
            return dp[i][k];
        }
        if(k%2==0){
            int c1=dfs(arr,i+1,k-1,n)-arr[i];
            int c2=dfs(arr,i+1,k,n);
            return dp[i][k]=Math.max(c1,c2);
        }
        else{
 int c1=dfs(arr,i+1,k-1,n)+arr[i];
            int c2=dfs(arr,i+1,k,n);
            return dp[i][k]=Math.max(c1,c2);
        }
    }
}