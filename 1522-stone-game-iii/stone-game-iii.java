class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int[]dp=new int[stoneValue. length];
Arrays.fill(dp,Integer.MIN_VALUE);
        int dif=dfs(stoneValue,0,dp);
      if(dif>0){
          return "Alice";
      } 
        if(dif<0){
            return "Bob";
        }
        return "Tie";
    }
    int dfs(int arr[],int idx,int dp[]){

if(idx>=arr.length){
    return 0;
}
if(dp[idx]!=Integer.MIN_VALUE){
    return dp[idx];
}
        int take1=arr[idx]-dfs(arr,idx+1,dp);
        int take2=Integer.MIN_VALUE;
        if(idx+1<arr.length){
           take2 =arr[idx]+arr[idx+1]-dfs(arr,idx+2,dp);
        }
        int take3=Integer.MIN_VALUE;
   if(idx+2<arr.length){take3=arr[idx]+arr[idx+1]+arr[idx+2]-dfs(arr,idx+3,dp);}
    dp[idx]=Math.max(take3,Math.max(take1,take2));
        return dp[idx];
}
}