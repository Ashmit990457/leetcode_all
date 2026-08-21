class Solution {
    public long findKthSmallest(int[] coins, int k) {
       long res=-1;
       long left=1;
       int max=0;
       for(int i=0;i<coins.length;i++){
        max=Math.max(max,coins[i]);
       }
       long right=(long)max*k;
       while(left<=right){
        long mid=left+(right-left)/2;
        if(countsmall(mid,coins)>=k){
            res=mid;
            right=mid-1;
        }
        else{
            left=mid+1;
        }
       }
return res;
    }
    long countsmall(long mid,int coins[]){
        long correctcount=0;
        int n=coins.length;
        for(int i=1;i<(1<<n);i++){
long lcm=0;
long order=0;
for(int j=0;j<n;j++){
    if((i&(1<<j))!=0){
        order++;
         long g = gcd(lcm, coins[j]);
        if(lcm==0){
            lcm=coins[j];
        }else{
            lcm=lcm*coins[j]/g;
        }
    }
}
if(order%2==0){
    correctcount-=mid/lcm;
}else{
      correctcount+=mid/lcm;
}
      }
      return   correctcount;  
    }
    long gcd(long a,long b){
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}