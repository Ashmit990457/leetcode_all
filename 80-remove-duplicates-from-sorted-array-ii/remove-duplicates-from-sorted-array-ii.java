class Solution {
    public int removeDuplicates(int[] nums) {
        int count=0;
       int i=0;
       int j=1;
       while(j<nums.length){
        if(nums[i]==nums[j]){
            count++;
            if(count>=2){
                nums[j]=Integer.MAX_VALUE;
            }
            j++;
        }
        else{
            count=0;
            i=j;
            j++;
        }
       }
       Arrays.sort(nums);
      i=0;
      int ans=0;
      while(i<nums.length&&nums[i]!=Integer.MAX_VALUE){
        ans++;
        i++;
      }
      return ans;
    }
}