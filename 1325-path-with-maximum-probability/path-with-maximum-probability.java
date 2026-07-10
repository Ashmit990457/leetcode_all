class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<demo>>graph=new ArrayList <>();
        double ans[]=new double[n];
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
ans[i]=0.0;
        }
        for(int i=0;i<edges.length;i++){
            int src=edges[i][0];
            int des=edges[i][1];
            double wei=succProb[i];
            graph.get(src).add(new demo(des,wei));
graph.get(des).add(new demo(src,wei));   }
    PriorityQueue<pair>pq=new PriorityQueue<>((a,b)->{
return Double.compare(b.pro,a.pro);
    } ) ; 
ans[start]=1.0;
pq.add(new pair(1.0,start));
while(pq.size()>0){
    pair temp=pq.poll();
    double pr=temp.pro;
    int no=temp.node;
    if(ans[no]<pr){
continue;
}
for(int i=0;i<graph.get(no).size();i++){
    demo d=graph.get(no).get(i);
int ver=d.vertex;
    double w=d.weight;
    double sum=pr*w;
    if(ans[ver]<sum){
ans[ver]=sum;
        pq.add(new pair(sum,ver));
}
}
    }
    return ans[end];
}
}class pair{
    double pro;
    int node;
    pair(double pro,int node){
   this.pro=pro;
    this.node=node;
    }
}
class demo{
    int vertex;
    double weight;
    demo(int vertex,double weight){
        this.vertex=vertex;
        this.weight=weight;
    }
}