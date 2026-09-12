class Solution {
    int n;
    Node [][]dp;
    int []next;
    public int[] maximumWeight(List<List<Integer>> intervals) {
        n=intervals.size();
        next=new int[n];
        dp=new Node[n+1][5];
        for(int i = 0;i<=n;i++){
            Arrays.fill(dp[i],null);
        }
        for(int i = 0;i<n;i++){
            intervals.get(i).add(i);
        }
       Collections.sort(intervals, (a, b) ->Integer.compare(a.get(0),b.get(0)));
       
          for(int i = 0;i<n;i++){
           int end=intervals.get(i).get(1);
           next[i]=NextIndex(intervals,end);
        }
        int k=4;
      Node ans =solve(intervals,0,k);
      int s=ans.idxs.size();
      int []an=new int[s];
      for(int i=0;i<s;i++){
an[i]=ans.idxs.get(i);
      }
      return an;

    }
    int NextIndex(List<List<Integer>> intervals,int end){
int res=n;
int st=0;
int en=n-1;
while(st<=en){
    int mid=st+(en-st)/2;
    if(intervals.get(mid).get(0)>end){
        res=mid;
        en=mid-1;
    }else{
        st=mid+1;
    }
 
}   return res;
    }
    Node solve(List<List<Integer>> intervals,int i,int k){
        if(k==0||i>=n){return new Node(0,new ArrayList<>());}
        if(dp[i][k]!=null){
            return dp[i][k];
        }
        Node skip=solve(intervals,i+1,k);
         int j=next[i];
        Node temp=solve(intervals,j,k-1);
        int weight=intervals.get(i).get(2);
        int idx=intervals.get(i).get(3);
        List<Integer> list = new ArrayList<>(temp.idxs);
        list.add(idx);
       Collections.sort(list);
          Node take=new Node(temp.score+weight,list);
        Node res;
        if(skip.score>take.score){
            res=skip;
        }
        else if(take.score>skip.score){
            res=take;
        }
        else{
         if(issmaller(skip.idxs,take.idxs)){
            res=skip;
         }
         else{
            res=take;
         }
        }
        return dp[i][k]=res;
    }
    boolean issmaller(List<Integer>a,List<Integer>b){
        int size=Math.min(a.size(),b.size());

        for (int i = 0; i < size; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}
class Node{
    long score;
    List<Integer>idxs;
    Node(long score,List<Integer>idxs){
        this.score=score;
        this.idxs=idxs;
    }

}