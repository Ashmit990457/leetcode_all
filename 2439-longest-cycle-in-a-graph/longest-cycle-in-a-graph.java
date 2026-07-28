class Solution {
    int ans=-1;
    public int longestCycle(int[] edges) {
    HashMap<Integer,Integer>map=new HashMap <>();
        boolean vis[]=new boolean [edges.length];
        for(int i=0;i<edges.length;i++){
            if(vis[i]==false){
dfs(edges,map,vis,i,0);
}
        }
        return ans;
        
    }
  void  dfs(int[]arr,HashMap<Integer,Integer>map,boolean vis[],int node,int curr){   
      if(node==-1){return;}
      if(map.containsKey(node)){
ans=Math.max(ans,curr-map.get(node));
          return;
}
      if(vis[node]==true ) {return;}
      vis[node]=true;
      map.put(node,curr);
dfs(arr,map,vis,arr[node],curr+1);
      map.remove(node);
  }
}