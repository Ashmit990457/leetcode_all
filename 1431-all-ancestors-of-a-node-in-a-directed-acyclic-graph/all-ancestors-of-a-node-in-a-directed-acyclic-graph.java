class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
      List<List<Integer>>graph=new ArrayList <>();
        List<List<Integer>>ans=new ArrayList <>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
            ans.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int src=edges[i][0];
            int des=edges[i][1];
          graph.get(src).add(des);    
        }
for(int i=0;i<n;i++){
    int vis[]=new int[n];
    dfs(graph,i,ans,i,vis);
}
        return ans;
    }
  void dfs(List<List<Integer>>graph,int node,List<List<Integer>>ans,int start,int vis[]){
        if(vis[node]==1){
return;
        }
        vis[node]=1;
        for(int i=0;i<graph.get(node).size();i++){
            int neigh=graph.get(node).get(i);
            if(vis[neigh]==0){
            ans.get(neigh).add(start);
dfs(graph,neigh,ans,start,vis);
            }
        }
    }
}