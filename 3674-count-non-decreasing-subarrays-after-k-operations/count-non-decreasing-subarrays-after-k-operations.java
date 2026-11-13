class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
     Deque<pair>q=new ArrayDeque<>();
     int n=nums.length;
     long cost=0;
     long ans=0;
     int j=n-1;
     for(int i=n-1;i>=0;i--){
        int num=nums[i];
        int count=1;
        while(!q.isEmpty()&&q.peekLast().val<num){
            pair p=q.removeLast();
            count+=p.count;
            cost+=(long)(num-p.val)*p.count;

        }
        q.addLast(new pair(num,count));
        while(cost>k){
            pair p=q.removeFirst();
            cost-=(long)(p.val-nums[j]);
            j--;
            if(p.count>1){
                q.addFirst(new pair(p.val,p.count-1));
            }
        }
        ans+=j-i+1;
     }
     return ans;
    }
}
class pair{
    int val;
    int count;
    pair(int val,int count){
        this.val=val;
        this.count=count;
    }
}