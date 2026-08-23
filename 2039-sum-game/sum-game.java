class Solution {
    public boolean sumGame(String num) {
        int leftques=0;
        int rightques=0;
        int leftsum=0;
        int rightsum=0;
        int n=num.length();
        for(int i=0;i<n;i++){
            if(num.charAt(i)=='?'){
if(i<n/2){
    leftques++;
}else{
    rightques++;
}
            }
            else{
if(i<n/2){
        leftsum+=num.charAt(i)-'0';
}else{
     rightsum+=num.charAt(i)-'0';
}
            }
        }
        if((leftques+rightques)%2==1){return true;}
        return (2*leftsum+9*leftques)!=(2*rightsum+9*rightques);
    }
}