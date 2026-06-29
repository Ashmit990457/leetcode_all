class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       List<List<Integer>>graph=new ArrayList<>(numCourses);
       List<Integer>ind=new ArrayList<>(numCourses);
       int ans[]=new int[numCourses];
       for (int i = 0; i < numCourses; i++) {
    graph.add(new ArrayList<>());
}
for (int i = 0; i < numCourses; i++) {
 ind.add(0);
}
       for(int i=0;i<prerequisites.length;i++){
        int src=prerequisites[i][1];
        int dest=prerequisites[i][0];
        graph.get(src).add(dest);
ind.set(dest, ind.get(dest) + 1);
       } 
       Queue<Integer>q=new LinkedList<>();
       for(int i=0;i<numCourses;i++){
        if(ind.get(i)==0){
            q.add(i);
        }
       }
       int j=0;
       while(q.size()>0){
        int node=q.poll();
        ans[j]=node;
        j++;
        for(int i=0;i<graph.get(node).size();i++){
            int n=graph.get(node).get(i);
            ind.set(n,ind.get(n)-1);
            if(ind.get(n)==0){
                q.add(n);
            }
        }
       }
       if(j!=numCourses){
        return new int[0];
       }
       return ans;
    }
}