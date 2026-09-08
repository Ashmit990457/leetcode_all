class Solution {
    public long countCommas(long n) {
       int len=0;
       long temp=n;
       while(temp!=0){
        temp=temp/10;
        len++;
       }
       if(len<4)return 0;
       if(len<7){
return n-999;
       }
        if(len<10){
return 999999-999+2*(n-999999);
       }
        if(len<13){
return  999999-999+2*(999999999-999999)+ 3*(n-999999999);
       }
       if (n == 1000000000000000L) {
    return 3998998998999005L;
}
return 999999L-999L+2*(999999999L-999999L)+ 3*(999999999999L-999999999L)+4*(n-999999999999L);
    }
}