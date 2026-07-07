class Solution {
    int x[]={1,-1,0,0};
    int y[]={0,0,1,-1};
    public int swimInWater(int[][] grid) {
       
        int low=grid[0][0];
        int res=0;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                high=Math.max(high,grid[i][j]);
            }
        }
        while(low<=high){
             boolean[][] vis = new boolean[grid.length][grid[0].length];
           int mid=low+(high-low)/2;
           if(mid<grid[0][0]){
            low=mid+1;
            continue;
           }
        boolean ans= dfs(grid,grid.length,grid[0].length,0,0,mid,vis);
        if(ans==true){
            high=mid-1;
            res=mid;
        }
        else{
            low=mid+1;
        }
        }
        return res;
    }
   boolean dfs(int[][]grid,int n,int m,int row,int col,int mid,boolean vis[][]){
        if(row==n-1&&col==m-1){
            return true;
        }
        vis[row][col]=true;
        int ro=row;
        int co=col;
        for(int i=0;i<4;i++){
int a=ro+x[i];
int b=co+y[i];
boolean val=isvalid(a,b,n,m);
if(val==true&&vis[a][b]==false&&grid[a][b]<=mid){
   if(dfs(grid,n,m,a,b,mid,vis)){
    return true;
   }
 
}
        }
        return false;
    }
    boolean isvalid(int row,int col,int n,int m){
        if(row<0||row>=n||col<0||col>=m){
            return false;
        }
        return true;
    }
    
}