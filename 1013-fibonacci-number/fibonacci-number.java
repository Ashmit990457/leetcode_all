
class Solution {
    public int fib(int n) {
        HashMap<Integer,Integer>dp=new HashMap<>();
    int ans=    dfs(n,dp);
    return ans;
    }
    int dfs(int n,   HashMap<Integer,Integer>map){
        if(n==0){return 0;
        }
        if(n==1){return 1;}
        if(map.containsKey(n)){
            return map.get(n);
        }
        int ans=dfs(n-1,map)+dfs(n-2,map);
        return ans;
    }
}