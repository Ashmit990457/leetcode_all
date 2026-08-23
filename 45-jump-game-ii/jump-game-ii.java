class Solution {
int dp[];
    public int jump(int[] nums) {
         dp=new int[nums.length+1];
          Arrays.fill(dp,-1);
        int ans=dfs(nums,0);
       
       
        return ans;
    }
    int dfs(int nums[],int i){
        if(i>=nums.length-1){
            return 0;
        }
        if(dp[i]!=-1){return dp[i];}
        int n=nums[i];
        int ans=Integer.MAX_VALUE;
        for(int j=1;j<=n;j++){
   int nex=dfs(nums,i+j);
   if(nex!=Integer.MAX_VALUE){
    ans=Math.min(ans,1+nex);
   }
        }
        return dp[i]=ans;
    }
}