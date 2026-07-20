class Solution {
    int count=0;
    HashSet<Integer>set=new HashSet<>();
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
       List<List<Integer>>graph=new ArrayList<>();
       
       for(int i=0;i<restricted.length;i++){
        set.add(restricted[i]);
       }
       int vis[]=new int[n];
       for(int i=0;i<n;i++){
        graph.add(new ArrayList<>());
       }
       for(int i=0;i<edges.length;i++){
        int src=edges[i][0];
        int des=edges[i][1];
        graph.get(src).add(des);
        graph.get(des).add(src);
       } 
       if(set.contains(0)){return 0;}
       dfs(graph,0,vis);
       return count;
    }
    void dfs(List<List<Integer>>graph,int node,int[]vis){
        if(vis[node]==1){
            return;
        }
           vis[node]=1;
        count++;
     
        for(int i=0;i<graph.get(node).size();i++){
            int neigh=graph.get(node).get(i);
            if(set.contains(neigh)){continue;}
            if(vis[neigh]==0){
            dfs(graph,neigh,vis);
            }
        }
    }
}