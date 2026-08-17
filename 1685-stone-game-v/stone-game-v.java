class Solution {
    int dp[][];
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        dp=new int[n+1][n+1];  
        for(int i=0;i<n;i++){
        Arrays.fill(dp[i],-1);}
       int prefix[]=new int[n+1];
prefix[0]=0;
        for(int i=1;i<n+1;i++){
            prefix[i]=prefix[i-1]+stoneValue[i-1];
        }
int ans=dfs(stoneValue, 0,n-1,prefix);
        return ans;
    }
    int dfs(int arr[],int left,int right,int prefix[]){
        if(left==right){
            return 0;
        }
        if(dp[left][right]!=-1){
            return dp[left][right];
        }
        int max=0;
        for(int i=left;i<right;i++){
            int leftsum=prefix[i+1]-prefix[left];
int rightsum =prefix[right+1]-prefix[i+1];
int score=0;
            if(leftsum>rightsum){
score =rightsum +dfs(arr,i+1,right,prefix);
}
            else if(rightsum>leftsum){
                score=leftsum+dfs(arr,left,i,prefix);
            }
            else{
                score=Math.max(leftsum +dfs(arr,left,i,prefix), rightsum+dfs(arr,i+1,right,prefix));
            }
       max=  Math.max(max,score);
        }
        return dp[left][right]= max;
    }
}