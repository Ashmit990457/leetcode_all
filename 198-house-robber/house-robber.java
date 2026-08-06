class Solution {
    HashMap<Integer,Integer>map=new HashMap<>();
    public int rob(int[] nums) {
        int ans=dfs(nums,0);
        return ans;
    }
    int dfs(int[]arr,int idx){
        if(idx>=arr.length){
            return 0;
        }
        if(map.containsKey(idx)){
            return map.get(idx);
        }
        int n1=dfs(arr,idx+1);
        int n2=arr[idx]+dfs(arr,idx+2);
        map.put(idx,Math.max(n1,n2));
        return Math.max(n1,n2);
    }
}