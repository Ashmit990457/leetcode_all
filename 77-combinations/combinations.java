class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>ans=new ArrayList <>();
        List <Integer>temp=new ArrayList <>();
      dfs(ans,temp,1,n,k)  ;
return ans;
    }
    void dfs(List <List <Integer >>ans,List<Integer>temp,int curr,int n,int k){
        if(temp.size()==k){
ans.add(new ArrayList <>(temp));
return;
}
if(curr>n){
return;
}
       
        for(int i=curr;i<=n;i++){
          temp.add(i);  

dfs(ans,temp,i+1,n,k);
temp.remove(temp.size()-1) ;
        }

    }
}