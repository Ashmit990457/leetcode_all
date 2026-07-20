class Solution {
    int ans=Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        List<List<pair>>graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            int src=roads[i][0];
            int des=roads[i][1];
            int wei=roads[i][2];
            graph.get(src).add(new pair(des,wei));
                  graph.get(des).add(new pair(src,wei));
        }
    int []vis=new int[n+1];
        dfs(graph,1,vis);
        return ans;

    }
    void dfs( List<List<pair>>graph,int node,int []vis){
        if(vis[node]==1){return ;}
        vis[node]=1;
        for(int i=0;i<graph.get(node).size();i++){
            pair temp=graph.get(node).get(i);
            int neigh=temp.node;
            int w=temp.weight;
              ans=Math.min(ans,w);
            if(vis[neigh]==0){
                dfs(graph,neigh,vis);
            }
        }
        return;
    }
}
class pair{
    int node;
    int weight;
    pair(int node,int weight){
        this.node=node;
        this.weight=weight;
    }
}