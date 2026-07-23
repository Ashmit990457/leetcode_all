class Solution {
    int maxtime=0;
       public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
       List<List<Integer>>graph=new ArrayList<>();
        for(int i=0;i<n;i++){
       graph.add(new ArrayList<>());
       } 
       for(int i=0;i<manager.length;i++){
        if(manager[i]!=-1){
            graph.get(manager[i]).add(i);
        }
       } 
       dfs(graph,0,headID,informTime);
return maxtime;
    }
    void dfs(List<List<Integer>>graph,int currtime,int head,int []inform){
        maxtime=Math.max(maxtime,currtime);
        for(int i=0;i<graph.get(head).size();i++){
            int neigh=graph.get(head).get(i);
            dfs(graph,currtime+inform[head],neigh,inform);
        }
        return;
    }
}