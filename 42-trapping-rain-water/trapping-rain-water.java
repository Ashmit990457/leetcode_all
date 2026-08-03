class Solution {
    public int trap(int[] height) {
        int sum=0;
        int left[]=new int[height.length];
        int right[]=new int[height.length];
        int max=Integer.MIN_VALUE;

        for(int i=0;i<height.length;i++){
max=Math.max(max,height[i]);
            left[i]=max;
            }
        max=Integer.MIN_VALUE;
        for(int i=height.length-1;i>=0;i--){
            max=Math.max(max,height[i]);
            right[i]=max;
        }
        for(int i=0;i<height.length;i++){
            sum=sum+Math.min(left[i],right[i])-height[i];
        }
        return sum;
    }
}