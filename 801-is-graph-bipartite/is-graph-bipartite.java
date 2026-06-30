class Solution {
    boolean res=true;
    public boolean isBipartite(int[][] graph) {
        List<Integer>color=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            color.add(-1);
        }
    for(int i=0;i<color.size();i++){
        if(color.get(i)==-1){
            dfs(graph,color,0,i);
        }
    }
        return res;
    }
    void dfs(int[][]graph,List<Integer>color,int c,int node){
color.set(node,c);
for(int i=0;i<graph[node].length;i++){
    int neigh=graph[node][i];
    if(color.get(neigh)!=-1&&color.get(neigh)==c){
        res=false;
        return;
    }
    if(color.get(neigh)==-1){
        dfs(graph,color,1-c,neigh);
    }
}
return;
    }
}