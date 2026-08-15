class Solution {
    public int longestSubsequence(int[] nums) {
        int ans=0;
        int n=nums.length;
        int count=0;
        for(int i:nums){
            if(i==0){count++;}
            ans=ans^i;
        }
        if(ans>0){
            return n;
            }
if(ans==0&&count==n){
    return 0;
    }
return n-1;
    }
}