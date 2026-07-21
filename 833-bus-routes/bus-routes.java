class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer,List<Integer>>map=new HashMap<>();
        HashSet<Integer>bus=new HashSet<>();
           HashSet<Integer>stops=new HashSet<>();
        
        for(int i=0;i<routes.length;i++){
       
          for(int j=0;j<routes[i].length;j++){
            int s=routes[i][j];
        
if(!map.containsKey(s)){
    map.put(s,new ArrayList<>());
}
map.get(s).add(i);
          }
        }
        int count=0;
        Queue<Integer>q=new LinkedList<>();
        if(source==target){return 0;}
       if(!map.containsKey(source)){
        return -1;
       }
       q.add(source);
        stops.add(source);
       while(q.size()>0){
int si=q.size();
for(int i=0;i<si;i++){
int stop=q.poll();
if(stop==target){return count;}
for(int buse:map.get(stop)){
    if(bus.contains(buse)){
continue;
    }
    bus.add(buse);
    for(int next:routes[buse]){
        if(!stops.contains(next)){
            stops.add(next);
            q.add(next);
        }
    }
}
}
count++;
       }
       return -1;
    }
}