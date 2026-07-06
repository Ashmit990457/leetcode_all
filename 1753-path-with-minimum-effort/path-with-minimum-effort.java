class Solution {
    int x[]={1,-1,0,0};
    int y[]={0,0,1,-1};
    public int minimumEffortPath(int[][] heights) {
       int n=heights.length;
     
       int m=heights[0].length;
       int res[][]=new int[n][m];
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            res[i][j]=Integer.MAX_VALUE;
        }
       }
       res[0][0]=0;
       PriorityQueue<pair>pq=new PriorityQueue<>((a,b)->{
        return a.dis-b.dis;
       });
       pq.add(new pair(0,0,0));
       while(pq.size()>0){
        pair temp=pq.poll();
        int r=temp.row;
        int c=temp.col;
        int d=temp.dis;
        for(int i=0;i<4;i++){
            int ro=r+x[i];
            int co=c+y[i];
            boolean valid=isvalid(ro,co,n,m);
            if(valid==true){
                int dif=Math.abs(heights[r][c]-heights[ro][co]);
               int ans=Math.max(dif,d);
               if(ans<res[ro][co]){
                res[ro][co]=ans;
                pq.add(new pair(ro,co,ans));
               }
            }
        }
       }
       return res[n-1][m-1];
    }
    boolean isvalid(int i,int j,int n,int m){
        if(i<0||i>=n||j<0||j>=m){
            return false;
        }
        return true;
    }
}
class pair{
    int row;
    int col;
    int dis;
    pair(int row,int col,int dis){
        this.row=row;
        this.col=col;
        this.dis=dis;
    }
}