class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
List<List<Integer>>ans=new ArrayList<>();
Arrays.sort(nums);
List<Integer>temp=new ArrayList<>();
    dfs(nums,temp,ans,0);
return ans;
    }
   void dfs(int []arr,List<Integer>temp,List<List<Integer>>ans,int idx){
        ans.add(new ArrayList<>(temp));
for(int i=idx;i<arr.length;i++){
    if(i>idx&&arr[i]==arr[i-1]){
        continue;
    }
    temp.add(arr[i]);
    dfs(arr,temp,ans,i+1);
    temp.remove(temp.size()-1);
}

    }
}