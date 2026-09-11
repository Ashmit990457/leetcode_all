class Solution {
    List<String>ans;
    public String getPermutation(int n, int k) {
        ans=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        boolean vis[]=new boolean[n+1];
        dfs(n,sb,vis);
    
        return ans.get(k-1);
        
    }
    void dfs(int n,StringBuilder curr,boolean vis[]){
        if(curr.length()==n){
            ans.add(curr.toString());
            return;
        }
        for(int i=1;i<=n;i++){
            if(vis[i]==false){
                vis[i]=true;
        curr.append(i);
        dfs(n,curr,vis);
        vis[i]=false;
        curr.deleteCharAt(curr.length()-1);
            }
        }
    }
}