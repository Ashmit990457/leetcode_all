class Solution {
    int x[]={1,-1,0,0};
    int y[]={0,0,1,-1};
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<pair>q=new LinkedList<>();
        int left=maze.length;
        int right=maze[0].length;
        q.add(new pair(entrance[0],entrance[1],0));
        maze[entrance[0]][entrance[1]]='+';
        while(q.size()>0){
            pair temp=q.poll();
            int r=temp.row;
            int c=temp.col;
            int di=temp.dis;
            for(int i=0;i<4;i++){
                int rw=r+x[i];
                int cl=c+y[i];
                boolean valid=isvalid(rw,cl,left,right);
                if(valid==true&&maze[rw][cl]=='.'){
                    if(rw==0||rw==left-1||cl==0||cl==right-1){
                        return di+1;
                    }
                    maze[rw][cl]='+';
                    q.add(new pair(rw,cl,di+1));
                }
            }
        };
        return -1;
    }
   boolean isvalid(int r,int c,int row,int col){
    if(r<0||r>=row||c<0||c>=col)
{
    return false;
}  
return true; }
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