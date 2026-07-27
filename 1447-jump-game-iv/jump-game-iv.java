class Solution {
    public int minJumps(int[] arr) {
int n=arr.length;
        int ans=0;
        boolean vis[]=new boolean [n];
        HashMap<Integer,List<Integer>>map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(arr[i])){
map.put(arr[i],new ArrayList<>());
}
            map.get(arr[i]).add(i);
        }
     Queue<Integer>q=new LinkedList<>();
        q.add(0);
        vis[0]=true;
        while(q.size()>0){
            int s=q.size();
            for(int i=0;i<s;i++){
                int idx=q.poll();
                if(idx==n-1){return ans;}
                if(map.containsKey(arr[idx])){
for(int curr:map.get(arr[idx])){
if(vis[curr]==false){
vis[curr]=true;
    q.add(curr);
}
}
map.remove(arr[idx]);

}
if(idx-1>=0&&vis[idx-1]==false){q.add(idx-1);vis[idx-1]=true;}
                    if(idx+1<n&&vis[idx+1]==false){q.add(idx+1);vis[idx+1]=true;}
            }
ans++;
        }
        return ans;
    }
}