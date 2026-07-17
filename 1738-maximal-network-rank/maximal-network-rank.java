class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int mat[][]=new int [n][n];
        int arr[]=new int [n];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<roads.length;i++){
            int src=roads[i][0];
            int des=roads[i][1];
            mat[src][des]=1;
            mat[des][src]=1;
            arr[src]=arr[src]+1;
            arr[des]=arr[des]+1;
        }
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<n;j++){
int sum=0;
                if(mat[i][j]==1){
                    sum=arr[i]+arr[j]-1;
                }else{
                    sum=arr[i]+arr[j];
                }
max=Math.max(sum,max);
            }
        }
return max;
    }
}