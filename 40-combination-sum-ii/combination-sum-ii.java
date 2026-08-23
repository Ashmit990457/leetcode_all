class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
     Arrays.sort(candidates);
     List<List<Integer>>ans=new ArrayList<>();
   List<Integer>temp=new ArrayList<>();
   dfs(candidates,0,temp,ans,target,0);
   return ans;

    }
void dfs(int arr[],int i,List<Integer>temp,List<List<Integer>>ans,int target,int sum){
  
    if(sum>target){return;}
    if(sum==target){
        ans.add(new ArrayList<>(temp));
        return;
    }
    for(int j=i;j<arr.length;j++){
        if(j>i&&arr[j]==arr[j-1]){continue;}
        temp.add(arr[j]);
        dfs(arr,j+1,temp,ans,target,sum+arr[j]);
        temp.remove(temp.size()-1);
    }

}
}