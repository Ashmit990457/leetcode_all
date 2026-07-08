class Solution {
    public int minCostConnectPoints(int[][] points) {
        int vis[]=new int[points.length];
        int sum=0;
        PriorityQueue<pair>pq=new PriorityQueue<>((a,b)->{
            return a.dis-b.dis;
        });
        pq.add(new pair(0,0));
        while(pq.size()>0){
            pair temp=pq.poll();
            int n=temp.node;
            int d=temp.dis;
            if(vis[n]==1){
                continue;
            }
            sum+=d;
            vis[n]=1;
            for(int i=0;i<points.length;i++){
                if(vis[i]!=1){
            int di = Math.abs(points[n][0] - points[i][0]) +
         Math.abs(points[n][1] - points[i][1]);
                    pq.add(new pair(i,di));
                }
            }
            
        }
        return sum;
    }

}
class pair{
    int node;
    int dis;
    pair(int node,int dis){
        this.node=node;
        this.dis=dis;
    }
}