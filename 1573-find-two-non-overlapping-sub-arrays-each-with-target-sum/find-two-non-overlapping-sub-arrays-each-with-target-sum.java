class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int i=0;
        int j=0;
        int min[]=new int[arr.length];
        int res=Integer.MAX_VALUE;
        Arrays.fill(min,Integer.MAX_VALUE);
        int sum=0;
        int bestmin=Integer.MAX_VALUE;
        while(j<arr.length){
sum+=arr[j];
while(sum>target){
    sum-=arr[i];
    i++;
}
if(sum==target){
    int len=j-i+1;
    if(i>0&&min[i-1]!=Integer.MAX_VALUE)
   res=Math.min(res,len+min[i-1]);
   bestmin=Math.min(bestmin,len);

}
min[j]=bestmin;
j++;
        }
      
   if(res==Integer.MAX_VALUE)return -1;
   return res;
    }
}