class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        List<Integer>list=new ArrayList<>();
        int it=n*m;
        int i=0;int j=0;
        boolean vis[][]=new boolean[n][m];
        while(it!=0){
while(j<m&&vis[i][j]==false){
    list.add(matrix[i][j]);
    vis[i][j]=true;
    j++;
    it--;
}
i++;
j--;
while(i<n&&vis[i][j]==false){
    list.add(matrix[i][j]);
    vis[i][j]=true;
    i++;
    it--; 
}
j--;
i--;
while(j>=0&&vis[i][j]==false){
     list.add(matrix[i][j]);
    vis[i][j]=true;
    j--;
    it--; 
}
i--;
j++;
while(i>=0&&vis[i][j]==false){
      list.add(matrix[i][j]);
    vis[i][j]=true;
    i--;
    it--; 
}
i++;
j++;
        }
        return list;
    }
}