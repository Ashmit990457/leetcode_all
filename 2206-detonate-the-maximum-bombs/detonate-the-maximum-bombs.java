class Solution {
    public int maximumDetonation(int[][] bombs) {
        List<List<Integer>>graph=new LinkedList<>();
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<bombs.length;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<bombs.length;i++){
            for(int j=0;j<bombs.length;j++){
                if(i==j){continue;}
                long dx=(long)bombs[i][0]-bombs[j][0];
                long dy=(long)bombs[i][1]-bombs[j][1];
                long d=dx*dx+dy*dy;
                long r1=(long)bombs[i][2]*bombs[i][2];
                long r2=(long)bombs[j][2]*bombs[j][2];
                if(d<=r1){
                    graph.get(i).add(j);
                }
               if(d<=r2){
                    graph.get(j).add(i);
                }
            }
        }
    for(int i=0;i<bombs.length;i++){
            int vis[]=new int [bombs.length];
            int count=0;
            dfs(i,vis,graph);
            for(int j=0;j<vis.length;j++){
                if(vis[j]==1){count++;}
                ans=Math.max(count,ans);
            }
    }
return ans;
    }
    void dfs(int node,int vis[],List<List<Integer>>graph){
        if(vis[node]==1){
            return;
        }
        vis[node]=1;
        for(int i=0;i<graph.get(node).size();i++){
int neigh=graph.get(node).get(i);
    dfs(neigh,vis,graph);
        }
return;
    }
}
