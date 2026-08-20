class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int n=prices.length;
        int max[]=new int[n];
        max[n-1]=prices[n-1];
        for(int i=n-2;i>=0;i--){
max[i]=Math.max(prices[i],max[i+1]);
        }
        for(int i=0;i<n-1;i++){
if(prices[i]<max[i+1]){
   ans=Math.max(ans,max[i+1]-prices[i]); 
}
        }
        return ans;
    }
    
}