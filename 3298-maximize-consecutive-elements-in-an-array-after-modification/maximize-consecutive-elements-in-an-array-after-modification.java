class Solution {
    int n;
    int dp[][];
    public int maxSelectedElements(int[] nums) {
        n=nums.length;
        dp=new int[n+1][2];
          for(int i=0;i<nums.length;i++){
Arrays.fill(dp[i],-1);
        }
        Arrays.sort(nums);
        int res=1;
        for(int i=0;i<nums.length;i++){
res=Math.max(res,Math.max(solve(i,0,nums),solve(i,1,nums)));
        }
        return res;
    }
    int solve(int i,int inc,int[]nums){
        int currval=nums[i]+inc;
        int len=1;
        if(dp[i][inc]!=-1){
            return dp[i][inc];
        }
        int j=find(nums,i+1,currval+1);
        if(j!=-1){
            len=Math.max(len,1+solve(j,0,nums));
        }
         j=find(nums,i+1,currval);
        if(j!=-1){
            len=Math.max(len,1+solve(j,1,nums));
        }
        return dp[i][inc]= len;
    }
    int find(int[]nums,int i,int tar){
        int st=i;
        int end=n-1;
        int ans=-1;
        while(st<=end){
            int mid=st+(end-st)/2;
           if(nums[mid]>=tar){
            if(nums[mid]==tar){
                ans=mid;
            }
            end=mid-1;
           }
              else{
                st=mid+1;
              }    
               

        }
        return ans;
    }
}