class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n=img1.length;
        int ans=0;
        for(int i=-(n-1);i<=n-1;i++){
              for(int j=-(n-1);j<=n-1;j++){
                int count=0;
              for(int k=0;k<=n-1;k++){
                for(int l=0;l<=n-1;l++){
                   int ni=k+i;int nj=l+j;
                   if(ni<0||nj<0||ni>=n||nj>=n){continue;}
                   if(img1[k][l]==1&&img2[ni][nj]==1){count++;}
            
        }
            
        }
        ans=Math.max(count,ans);
        }
        }return ans;
    }
}