class Solution {
    public int largestInteger(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        HashMap<Integer,Integer>map=new HashMap<>();
        int i=0;
        int j=k-1;
        while(j<nums.length){
            HashSet<Integer>set=new HashSet<>();
for(int l=i;l<=j;l++){
     set.add(nums[l]);
}
for(int x:set){
    map.put(x,map.getOrDefault(x,0)+1);
}
i++;
j++;
        } 
        for(int x:map.keySet()){
            if(map.get(x)==1){
                max=Math.max(x,max);
            }
        }
        if(max==Integer.MIN_VALUE){return -1;}
        return max;
           }
}