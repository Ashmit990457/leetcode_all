class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int len_of_max=0;
        int len_of_min=0;
        int i=0;
        int j=1;
        while(j<nums.length){
            if(nums[j]>nums[j-1]){
                 len_of_max=Math.max(len_of_max,j-i);
                j++;
            }
            else{
              
               i=j;
               j++;
            }
        }
        i=0;
        j=1;
         while(j<nums.length){
            if(nums[j]<nums[j-1]){
                   len_of_min=Math.max(len_of_min,j-i);
                j++;
            }
            else{
            
               i=j;
               j++;
            }
        }
        return Math.max(len_of_min,len_of_max)+1;
    }
}