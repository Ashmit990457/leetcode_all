class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<pair>>graph=new ArrayList<>();
        int city=-1;
        int minCount=Integer.MAX_VALUE;
        PriorityQueue<node>pq=new PriorityQueue<>((a,b)->{
            return a.dis-b.dis;
        });
        int ans[]=new int[n];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
         for(int i=0;i<n;i++){
          ans[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<edges.length;i++){
            int src=edges[i][0];
            int des=edges[i][1];
            int we=edges[i][2];
            graph.get(src).add(new pair(des,we));
             graph.get(des).add(new pair(src,we));
        }
        int count=0;
        while(count<n){
            for(int i=0;i<n;i++){
          ans[i]=Integer.MAX_VALUE;
        }
            pq.add(new node(count,0));
            ans[count]=0;
            while(pq.size()>0){
                node temp=pq.poll();
                int ve=temp.ver;
                int di=temp.dis;
                if(di>ans[ve]){
                    continue;
                }
          for(int i=0;i<graph.get(ve).size();i++){
            pair t=graph.get(ve).get(i);
            int no=t.node;
            int w=t.wei;
            int sum=di+w;
            if(sum<ans[no]){
                ans[no]=sum;
                pq.add(new node(no, sum));
            }
          }
            }
            int an=0;
            for(int i=0;i<ans.length;i++){
                if(i!=count&&ans[i]<=distanceThreshold){
                    an++;
                }
            }
             if (an<= minCount) {
        minCount = an;
        city = count;
    }
count++;
        }
        return city;
    }

}
class pair{
    int node;
    int wei;
    pair(int node,int wei){
        this.node=node;
        this.wei=wei;
    }
}
class node{
    int ver;
    int dis;
    node(int ver,int dis){
        this.ver=ver;
        this.dis=dis;
    }
    }