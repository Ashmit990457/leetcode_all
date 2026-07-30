class Solution {
    int x[]={1,-1,0,0};
    int y[]={0,0,1,-1};
    boolean ans=false;
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        boolean vis[][]=new boolean [n][m];
StringBuilder sb=new StringBuilder();

        
for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
        dfs(board, vis, i, j, new StringBuilder(), word, n, m);
        if (ans) return true;
    }
}
return false;
    }
void dfs(char[][]board,boolean[][]vis,int row,int col,StringBuilder sb,String word,int n,int m){
    sb.append(board[row][col]);
if(word.equals(sb.toString())){
 ans=true;
    return;
}
    if(sb.length()>word.length()){
        sb.deleteCharAt(sb.length()-1);
        return;
    }
    vis[row][col]=true;
for(int i=0;i<4;i++){
    int r=row+x[i];
    int c=col+y[i];
  boolean valid= isvalid(r,c,n,m);
    if(valid==true&&vis[r][c]==false){
       
dfs(board,vis,r,c,sb,word,n,m);
}
}
    vis[row][col]=false;
sb.deleteCharAt(sb.length()-1);
    
}




    
    boolean isvalid(int i,int j,int n,int m){
        if(i>=n||i<0||j<0||j>=m){
return 
    false;}
return true;
    }
}