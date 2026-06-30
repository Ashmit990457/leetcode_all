class Solution {
    public int findCircleNum(int[][] isConnected) {
       List<Integer>vis=new ArrayList<>();
       int ans=0;
       for(int i=0;i<isConnected.length;i++){
        vis.add(-1);
       } 
       int n = isConnected.length;

List<List<Integer>> graph = new ArrayList<>();

for (int i = 0; i < n; i++) {
    graph.add(new ArrayList<>());
}

for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        if (isConnected[i][j] == 1 && i != j) {
            graph.get(i).add(j);
        }
    }
}
       for(int i=0;i<isConnected.length;i++){
        if(vis.get(i)==-1){
            dfs(graph,vis,i);
            ans++;
        }
       }
       return ans;
    }
    void dfs(
List<List<Integer>> graph,List<Integer>vis,int curr){
        vis.set(curr,0);
        for(int i=0;i<graph.get(curr).size();i++){
            int neigh=graph.get(curr).get(i);
            if(vis.get(neigh)!=0){
                dfs(graph,vis,neigh);
            }
        }
        return;
    }
}