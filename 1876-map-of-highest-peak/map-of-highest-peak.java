class Solution {
           
    int x[]={1,-1,0,0};
    int y[]={0,0,1,-1};
    public int[][] highestPeak(int[][] matrix) {

  
        int n=matrix.length;
        int m=matrix[0].length;
     int ans[][]=new int[n][m];
        Queue <pair>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==1){
                    ans[i][j]=0;
                     q.add(new pair(i,j));
                }
else{
ans[i][j]=-1;
}
            }
        }
        while(q.size()>0){
            pair temp=q.poll();
            int r=temp.row;
            int c=temp.col;
            for(int i=0;i<4;i++){
                int ro=r+x[i];
                int co=c+y[i];
                boolean valid=isvalid(ro,co,n,m);
if(valid==true&&ans[ro][co]==-1){
    ans[ro][co]=ans[r][c]+1;
    q.add(new pair(ro,co));
}
            }
        }
        return ans;
    }
    boolean isvalid(int i,int j,int n,int m){
  if(i>=n||i<0||j>=m||j<0){
      return false;
  }
    return true;
    }
}class pair{
    int row;
    int col;
    pair(int row,int col){
this.row=row;
        this.col=col;
    }
}
    
