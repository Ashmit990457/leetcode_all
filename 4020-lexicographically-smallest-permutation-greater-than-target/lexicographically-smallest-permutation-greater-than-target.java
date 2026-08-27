class Solution {
    String res="";
    public String lexGreaterPermutation(String s, String target) {
        int map[]=new int[26];
        for(char c:s.toCharArray()){
        map[c-'a']++;
        }
        StringBuilder curr=new StringBuilder();
        dfs(target,map,false,curr,0);
return res;
    }
   boolean dfs(String target,int map[],boolean taken,StringBuilder curr,int i){
if(i==target.length()){
    if(taken==true){
        res=curr.toString();
        return true;
    }
    return false;
}
for(char c='a';c<='z';c++){
    if(map[c-'a']==0){continue;}
    if(taken==false&&c<target.charAt(i)){continue;}
    curr.append(c);
    map[c-'a']--;
    boolean isgreat=taken||c>target.charAt(i);
    if(dfs(target,map,isgreat,curr,i+1)){
return true;
    } 
    curr.deleteCharAt(curr.length()-1);
    map[c-'a']++;
}
return false;
    }
}