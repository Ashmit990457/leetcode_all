class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] edges) {
     List<List<Integer>>graph=new ArrayList<>();
     boolean[]sus=new boolean[n];
     List<Integer>list=new ArrayList<>();
      boolean[]vis=new boolean[n];
     for(int i=0;i<n;i++){
        graph.add(new ArrayList<>());
     }
     for(int i=0;i<edges.length;i++){
        int src=edges[i][0];
        int des=edges[i][1];
        graph.get(src).add(des);
     }
     dfs(graph,sus,k,vis);
     for(int i=0;i<n;i++){
        if(sus[i]==false){
            for(int nei:graph.get(i)){
                if(sus[nei]==true){
for(int j=0;j<n;j++){
list.add(j);
}
return list;
                }
            }
        }
     }
     for(int i=0;i<n;i++){
        if(sus[i]==false){
            list.add(i);
        }
     }
     return list;
    }
    void dfs(List<List<Integer>>graph,boolean[]sus,int curr,boolean []vis){
if(vis[curr]==true){
    return;
}
vis[curr]=true;
sus[curr]=true;
for(int i=0;i<graph.get(curr).size();i++){
    int neigh=graph.get(curr).get(i);
    dfs(graph,sus,neigh,vis);
}
    }
}