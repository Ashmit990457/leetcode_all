class Solution {
    public int missingInteger(int[] nums) {
        HashSet<Integer>set=new HashSet <>();
        for(int n:nums){
set.add(n);
        }
     int  sum=nums[0];
        for(int i=1;i<nums.length;i++){
           if(nums[i]-nums[i-1]==1) {
sum+=nums[i];
}else{
               break;
}
        }
        if(!set.contains(sum)){
return sum;}
        sum+=1;
        while(set.contains(sum)){
sum+=1;
}
        return sum;
    }
}