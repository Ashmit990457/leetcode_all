class Solution {
     int dp[][];
    public int lengthOfLIS(int[] nums) {
        int ans=0;
         dp=new int[nums.length+1][nums.length+1];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
       for(int i=0;i<nums.length;i++){
        int res=dfs(nums,i+1,i);
        ans=Math.max(res,ans);
       }
       return ans;
    }
    int dfs(int nums[],int idx,int curr){
        if(idx>=nums.length){
            return 1;
        }
        if(dp[idx][curr]!=-1){
            return dp[idx][curr];
        }
        int ans=0;
        if(nums[curr]<nums[idx]){
ans=1+dfs(nums,idx+1,idx);
        }
        int noans=dfs(nums,idx+1,curr);
        return dp[idx][curr]= Math.max(ans,noans);
    }
}