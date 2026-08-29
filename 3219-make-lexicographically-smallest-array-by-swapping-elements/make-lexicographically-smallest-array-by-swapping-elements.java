class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        ArrayList<pair>list=new ArrayList<>();
         
        for(int i=0;i<nums.length;i++){
list.add(new pair(nums[i],i));
        }
        list.sort((a,b)->Integer.compare(a.val,b.val));
        int st=0;
        while(st<list.size()){
            int end=st;
            while(end+1<list.size()&&list.get(end+1).val-list.get(end).val<=limit){
                end++;
            }
            ArrayList<Integer>indices=new ArrayList<>();
            for(int i=st;i<=end;i++){
indices.add(list.get(i).idx);
            }
            Collections.sort(indices);
            for(int i=0;i<indices.size();i++){
                nums[indices.get(i)]=list.get(st+i).val;
            }
            st=end+1;
        }
        return nums;
    }
    class pair{
        int val;
        int idx;
        pair(int val, int idx){
            this.val=val;
            this.idx=idx;
        }
    }
}