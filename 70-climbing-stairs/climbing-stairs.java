class Solution {
HashMap<Integer,Integer>map=new HashMap<>();
    public int climbStairs(int n) {
      int ans=  dfs(n,0);
      return ans;

    }
 int dfs(int n,int curr){
        if(curr>n){
            return 0;
        }
        if(curr==n){
            return 1;
        }
        if(map.containsKey(curr)){
            return map.get(curr);
        }
       int n1= dfs(n,curr+1);
       int n2= dfs(n,curr+2);
       map.put(curr,n1+n2);
return n1+n2;
    }
}