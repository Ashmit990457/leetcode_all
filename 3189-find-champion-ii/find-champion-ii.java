class Solution {
    public int findChampion(int n, int[][] edges) {
        int arr[]=new int[n];
for(int i=0;i<edges.length;i++){
    int des=edges[i][1];
    arr[des]=1;
    
}
int ans=-1;
        int count =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                ans=i;
                count++;
            }
        }
        if(count>1){return -1;}
        return ans;
    }
}