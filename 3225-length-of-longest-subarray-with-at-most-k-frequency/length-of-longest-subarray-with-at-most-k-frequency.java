class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int i=0;
        int j=0;
        int ans=1;
        while(j<nums.length&&i<=j){
if(map.getOrDefault(nums[j],0)+1<=k){
    map.put(nums[j],map.getOrDefault(nums[j],0)+1);
    j++;
}
else{
    ans=Math.max(ans,j-i);
    map.put(nums[i],map.get(nums[i])-1);
    if(map.get(nums[i])==0){
        map.remove(nums[i]);
    }
    i++;
}
        }
        ans=Math.max(ans,j-i);
        return ans;
    }
}