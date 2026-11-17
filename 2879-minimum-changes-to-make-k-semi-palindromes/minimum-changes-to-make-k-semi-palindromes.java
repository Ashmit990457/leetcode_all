class Solution {
    int un=Integer.MAX_VALUE;
    int n;
    String str;
    int dp[][];
    public int minimumChanges(String s, int k) {
        n=s.length();
        dp=new int[n][k+1];
        for(int i=0;i<n;i++)
{
    Arrays.fill(dp[i],-1);
}        str=s;
        return solve(0,k);

    }
    int solve(int start,int k){
        if(k==0){
        if(start==n){
            return 0;
        }
        return un;
    }
    if(start+2*k>n){
        return un;
    }
    if(dp[start][k]!=-1){
        return dp[start][k];
    }
    int result=un;
    for(int end=start+1;end<n;end++){
        int remaincost=solve(end+1,k-1);
        if(remaincost==un){
            continue;
        }
        result=Math.min(result,getcost(start,end)+remaincost);
    }
    return dp[start][k]=result;
    }
    int getcost(int i,int j){
        int len=j-i+1;
        int mincost=un;
        for(int d=1;d<len;d++){
            if(len%d!=0){continue;}
            int cost=0;
            for(int g=0;g<d;g++){
                int l=i+g;
                int r=l+(len/d-1)*d;
                while(l<r){
                    if(str.charAt(l)!=str.charAt(r)){cost++;
                   
                    }
                     l+=d;
                    r-=d;
                }
            }
            mincost=Math.min(cost,mincost);

        }
        return mincost;
    }
}