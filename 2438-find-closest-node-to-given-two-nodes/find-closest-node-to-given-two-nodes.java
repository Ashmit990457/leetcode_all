class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int max=Integer.MIN_VALUE;
int val=-1;
    int ans=Integer.MAX_VALUE;

int dis1[]=new int[edges.length];
        int dis2[]=new int[edges.length];
        int vis1[]=new int[edges.length];
        int vis2[]=new int[edges.length];
        for(int i=0;i<edges.length;i++){
            dis1[i]=-1;
            dis2[i]=-1;
            vis1[i]=0;
            vis2[i]=0;
        }
        dfs(node1,edges,vis1,dis1,0);
        dfs(node2,edges,vis2,dis2,0);
        for(int i=0;i<dis1.length;i++){
  if(dis1[i]==-1||dis2[i]==-1)  {
continue;
  }
        max=Math.max(dis1[i],dis2[i]);
        
if(max<ans){
 ans=max;   
    val=i;
}


                

     }
        return val;
    }
    void dfs(int node,int edges[],int vis[],int dis[],int ds){

    if(node==-1||vis[node]==1){
   return;
 }
        vis[node]=1;
dis[node]=ds+1;
        dfs(edges[node],edges,vis,dis,ds+1);

    }
}