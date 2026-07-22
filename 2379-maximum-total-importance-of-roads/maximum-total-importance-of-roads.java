class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int degree[]=new int[n];
        for(int i=0;i<roads.length;i++){
           int des=roads[i][1];
            int src=roads[i][0];
            degree[src]++;
            degree[des]++;
        }
        PriorityQueue<pair>pq=new PriorityQueue <>(
            (a,b)->{
return b.val-a.val;
            }
        );
        for(int i=0;i<degree.length;i++){
            pq.add(new pair(i,degree[i]));
        }
        int arr[]=new int[n];
        int c=n;
while(!pq.isEmpty()){
  pair temp=pq.poll();
    int node=temp.node;
    arr[node]=c;
    c--;
}
long sum=0;
        for(int i=0;i<roads.length;i++){
            int src=roads[i][0];
            int des=roads[i][1];
            sum=sum+arr[src]+arr[des];
        }
        return sum;
    }
}
class pair{
    int node;
    int val;
    pair(int node, int val){
        this.node=node;
        this.val=val;
    }
}