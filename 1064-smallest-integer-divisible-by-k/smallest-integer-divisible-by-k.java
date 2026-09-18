class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k%2==0||k%5==0){return -1;}
        long n=1;
        int ans=1;
        boolean t=true;
        while(true){
            if(n%k==0){
                t=false;
                return ans;
            }
            n=(n*10+1)%k;
            ans++;
        }
       
    }
}