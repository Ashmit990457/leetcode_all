class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        List<Integer>list=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int x:map.keySet()){
            if(map.get(x)==1){
                list.add(x);
            }
        }
        int ans[]=new int [list.size()];
         for(int i=0;i<list.size();i++){
ans[i]=list.get(i);
        }
        return ans;
    }
}