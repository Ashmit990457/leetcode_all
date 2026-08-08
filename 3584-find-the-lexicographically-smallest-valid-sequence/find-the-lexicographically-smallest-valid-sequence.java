class Solution {
    public int[] validSequence(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int last[]=new int[m];
        Arrays.fill(last,-1);
        int j=m-1;
        for(int i=n-1;i>=0;i--){       
if(  j>=0&&word1.charAt(i)==word2.charAt(j)){
    last[j]=i;
    j--;
}
}
        
        int skip=0;
        int res[]=new int[m];
        j=0;
        for(int i=0;i<n;i++){
            if(j==m){
                break;
            }
            if(word1.charAt(i)==word2.charAt(j)){
              
                res[j]=i;
                  j++;
            }
            else if(skip==0&&j==m-1){
                res[j]=i;
                skip=1;
                j++;
            }
            else if(skip==0&&i<last[j+1]){
                 res[j]=i;
                skip=1;
                j++;
            }
           
        }
        if(j!=m){
            return new int[0];
        }
        return res;
    }
}