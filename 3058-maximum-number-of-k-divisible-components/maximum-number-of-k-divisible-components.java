class Solution {
    int ans=0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>>graph=new ArrayList<>();
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
        dfs(graph,0,vis,values,k);
        return ans;

    }
    long dfs(List<List<Integer>>graph,int node,int vis[],int values[],int k){
if(vis[node]==1){
    return 0;
}
vis[node]=1;
long sum=values[node];
        for(int i=0;i<graph.get(node).size();i++){
            int neigh=graph.get(node).get(i);
            if(vis[neigh]==0){
            sum+=dfs(graph,neigh,vis,values,k);
            }
        }
        if(sum%k==0){
            ans++;
            return 0;
        }
        return sum;
    }
}