class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    
        int dis[]=new int[n];

        for(int i=0;i<n;i++){
dis[i]=Integer.MAX_VALUE;

        }
        dis[src]=0;
     
        for(int i=0;i<k+1;i++){
                int[] temp = dis.clone();   
            for(int j=0;j<flights.length;j++){
int sr=flights[j][0];
int ds=flights[j][1];
int pr=flights[j][2];
if(dis[sr]!=Integer.MAX_VALUE&&temp[ds]>dis[sr]+pr){
    temp[ds]=dis[sr]+pr;
}
            }
            dis=temp;
        }
        if(dis[dst]==Integer.MAX_VALUE){
            return -1;
        }
        return dis[dst];
    }
}