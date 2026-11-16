class Solution {
    public String digitSum(String s, int k) {
       StringBuilder sb=new StringBuilder(s);
        while(sb.length()>k){
            StringBuilder temp=new StringBuilder();
            int it=(sb.length()+k-1)/k;
            int j=0;
            for(int i=0;i<it;i++){
                int sum=0;
                int count=0;
                while(count!=k&&j<sb.length()){
sum+=sb.charAt(j)-'0';
count++;j++;
                }
                temp.append(sum);
            }
            sb=temp;
        }
        return sb.toString();
    }
}