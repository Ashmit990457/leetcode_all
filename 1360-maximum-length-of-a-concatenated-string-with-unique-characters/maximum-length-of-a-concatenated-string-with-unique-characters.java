class Solution {
    int ans=0;
    public int maxLength(List<String> arr) {
        HashSet<Character>set=new HashSet <>();
        dfs(arr,set,0);
        return ans;
    }
    void dfs(List <String>list,HashSet<Character>set,int idx){
if(idx==list.size()){
    ans=Math.max(ans,set.size());
    return;
}
        dfs(list,set,idx+1);
        String s=list.get(idx);
        boolean temp=true;        for(char c:s.toCharArray()){
            if(set.contains(c)){
temp=false;
                break;
}}HashSet<Character> tempSet = new HashSet<>();

for(char c : s.toCharArray()){
    if(tempSet.contains(c)){
        temp = false;
        break;
    }
    tempSet.add(c);
}
if(temp==true){
for(char c:s.toCharArray ()){
    set.add(c);
}

dfs(list,set,idx+1);
         for(char c:s.toCharArray ()){
    set.remove(c);
         }   
}
        

}
}