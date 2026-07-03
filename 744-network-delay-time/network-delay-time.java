class Solution {
    public int networkDelayTime(int[][] edges, int V,int src) {
        
  int ans[]=new int[V+1];
        List<List<pair>>graph=new ArrayList<>();
       PriorityQueue<Node> pq =
    new PriorityQueue<>((a, b) -> a.dist - b.dist);
        for(int i=0;i<=V;i++){
            graph.add(new ArrayList<>());
            ans[i]=Integer.MAX_VALUE;
        }
        ans[src]=0;
    pq.add(new Node(src,0));
        for(int i=0;i<edges.length;i++){
            int sr=edges[i][0];
            int des=edges[i][1];
            int wei=edges[i][2];
           graph.get(sr).add(new pair(des, wei));
            
        }
        while(pq.size()>0){
            Node temp=pq.poll();
            int node=temp.vertex;
            int di=temp.dist;
            if (di > ans[node]) {
    continue;
}
            for(int i=0;i<graph.get(node).size();i++){
                pair t=graph.get(node).get(i);
                int neigh=t.node;
                int d=t.dis;
                int sum=di+d;
                if(sum<ans[neigh]){
                    ans[neigh]=sum;
                    pq.add(new Node(neigh,sum));
                }
            }
        }
        int min=0;
     for(int i=1;i<ans.length;i++){
        if(ans[i]==Integer.MAX_VALUE){
            return -1;
        }
        min=Math.max(ans[i],min);
     }
     return min;
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
 class Node {
    int vertex;
    int dist;

    Node(int vertex, int dist) {
        this.vertex = vertex;
        this.dist = dist;
    }
 }