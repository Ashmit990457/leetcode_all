class Solution {
    int x[]={1,-1,0,0};
    int y[]={0,0,1,-1};
    public void solve(char[][] board) {
        int row=board.length;
        int col=board[0].length;
        int i=0;int j=0;
        for(j=0;j<col;j++){
            if(board[0][j]=='O'){
                dfs(board,0,j,row,col);
            }
        }
          for(j=0;j<col;j++){
            if(board[row-1][j]=='O'){
                dfs(board,row-1,j,row,col);
            }
        }
          for(i=0;i<row;i++){
            if(board[i][0]=='O'){
                dfs(board,i,0,row,col);
            }
        }
          for(i=0;i<row;i++){
            if(board[i][col-1]=='O'){
                dfs(board,i,col-1,row,col);
            }
        }
        for(i=0;i<row;i++){
            for(j=0;j<col;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
                else{
                    board[i][j]='X';
                }
            }
        }
    }
    void dfs(char[][]board,int i,int j,int row,int col){
        board[i][j]='#';
        for(int k=0;k<4;k++){
            int r=i+x[k];
            int c=j+y[k];
            boolean t=isvalid(r,c,row,col);
            if(t==true&&board[r][c]=='O'){
                dfs(board,r,c,row,col);
            }
        }
        return;
    }
    boolean isvalid(int i,int j,int row,int col){
        if(i<0||i>=row||j<0||j>=col){
            return false;
        }
        return true;
    }
}