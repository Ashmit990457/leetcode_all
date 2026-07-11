class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<pair>>graph=new ArrayList<>();
        PriorityQueue<Node>pq=new PriorityQueue<>((a,b)->{
         return Long.compare(a.dis,b.dis);
        });
        long dis[]=new long[n];
        int ways[]=new int[n];
        for(int i=0;i<n;i++){
            dis[i]=Long.MAX_VALUE;
            ways[i]=0;
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            int src=roads[i][0];
            int des=roads[i][1];
            int wei=roads[i][2];
            graph.get(src).add(new pair(des,wei));
             graph.get(des).add(new pair(src,wei));
        }
        ways[0]=1;
        dis[0]=0;
pq.add(new Node(0,0));
while(pq.size()>0){
Node temp=pq.poll();
int node=temp.vertex;
long d=temp.dis;
if(dis[node]<d){
    continue;
}
for(int i=0;i<graph.get(node).size();i++){
    pair p=graph.get(node).get(i);
    int no=p.node;
    int w=p.weight;
    long sum=d+w;
    if(dis[no]==sum){
        ways[no]=(ways[no]+ways[node])%1000000007;
    }
    if(dis[no]>sum){
dis[no]=sum;
ways[no]=ways[node];
pq.add(new Node(no,sum));
    }
}


}
return ways[n-1];


    }
}
class pair{
    int node;
    int weight;
    pair(int node,int weight){
        this.node=node;
        this.weight=weight;
    }
}
class Node{
    int vertex;
    long dis;
    Node(int vertex,long dis){
        this.vertex=vertex;
        this.dis=dis;
    }
}