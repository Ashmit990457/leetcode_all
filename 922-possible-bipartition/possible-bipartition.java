class Solution {
    boolean res=true;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>>graph=new ArrayList<>();
        List<Integer>color=new ArrayList<>();
         for(int i=0;i<n+1;i++){
          color.add(-1);
        }
        for(int i=0;i<n+1;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<dislikes.length;i++){
            int src=dislikes[i][0];
            int des=dislikes[i][1];
            graph.get(src).add(des);
graph.get(des).add(src);
        }
         for(int i=0;i<n;i++){
         if(color.get(i)==-1){
            dfs(graph,color,i,0);
         }
        }
        return res;
    }
        void dfs(List<List<Integer>>graph,List<Integer>color,int node,int c){
            color.set(node,c);
            for(int i=0;i<graph.get(node).size();i++){
                int neigh=graph.get(node).get(i);
             if(color.get(neigh)!=-1&&color.get(neigh)==c){
        res=false;
        return;
    }
    if(color.get(neigh)==-1){
        dfs(graph,color,neigh,1-c);
    }
            }
        }
    
}