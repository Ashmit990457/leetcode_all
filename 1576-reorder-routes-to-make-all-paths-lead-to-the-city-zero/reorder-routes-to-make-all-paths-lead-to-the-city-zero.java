class Solution {
    int ans=0;
    public int minReorder(int n, int[][] connections) {
        HashMap<Integer,HashSet<Integer>>map=new HashMap<>();
        
List<List<Integer>>graph=new ArrayList <>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList <>());
        }
        for(int i=0;i<connections.length;i++){
            int src=connections[i][0];
            int des=connections[i][1];
graph.get(src).add(des);
graph.get(des).add(src);
            if(!map.containsKey(src)){
                map.put(src,new HashSet<>());
            }
            map.get(src).add(des);
        }
boolean vis[]=new boolean[n];
        dfs(graph,map,0,vis);
        return ans;
    }
void dfs(List<List<Integer>>graph,HashMap<Integer,HashSet<Integer>>map,int node,boolean vis[]){
if(vis[node]==true){return ;}
    vis[node]=true;

    for(int i=0;i<graph.get(node).size();i++){
        int neigh=graph.get(node).get(i);
        if(vis[neigh]==false){
if (map.containsKey(node) && map.get(node).contains(neigh)) {
    ans++;
}
            dfs(graph,map,neigh,vis);
        }
    }
}
}