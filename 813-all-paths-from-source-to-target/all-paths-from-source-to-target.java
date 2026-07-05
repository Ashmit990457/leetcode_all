class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n=graph.length;
       List<List<Integer>>ans=new ArrayList <>();
        List<Integer>temp=new ArrayList <>();
        int[]vis=new int[n];
for(int i=0;i<n;i++){
    vis[i]=0;
}
        dfs(graph,vis,ans,0,temp,n);
return ans;
    }
void dfs(int[][]graph,int vis[],List<List<Integer>>ans,int c,List<Integer>temp,int n){
temp.add(c);
if(c==n-1){
ans.add(new ArrayList<>(temp));
temp.remove(temp.size()-1);
return;
}
    for(int i=0;i<graph[c].length;i++){
        int neigh=graph[c][i];
dfs(graph,vis,ans,neigh,temp,n);
    

}
temp.remove(temp.size()-1);
        return;
}
}