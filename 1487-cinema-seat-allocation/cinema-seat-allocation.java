class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer,HashSet<Integer>>map=new HashMap <>();
        for(int i=0;i<reservedSeats.length;i++){
            int r=reservedSeats[i][0];
int c=reservedSeats[i][1];
            if(!map.containsKey(r)){
map.put(r,new HashSet<>());
}
            map.get(r).add(c);
        }
        int count=0;
        for(int k:map.keySet()){
          HashSet<Integer>set=map.get(k);
              if(!set.contains(2)&&!set.contains(3)&&!set.contains(4)&&!set.contains(5)){
                count++;
set.add(2);set.add(3);set.add(4);set.add(5);
            }
            if(!set.contains(4)&&!set.contains(5)&&!set.contains(6)&&!set.contains(7)){
                count++;
set.add(4);set.add(5);set.add(6);set.add(7);
            }
            if(!set.contains(6)&&!set.contains(7)&&!set.contains(8)&&!set.contains(9)){
                count++;
set.add(6);set.add(7);set.add(8);set.add(9);
            }
            
        }
        int c=n-map.size();
        count=count+2*c;
        return count;
    }
}