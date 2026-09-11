class Solution {
    public int totalNumbers(int[] nums) {
        int ans=0;
    
    
        HashSet<Integer>set=new HashSet<>();
       
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                continue;
            }
           for(int j=0;j<nums.length;j++){
            if(j==i){continue;}
             for(int k=0;k<nums.length;k++){
                  if(k==i||k==j){continue;}
                  int temp=0;
temp=temp*10+nums[i];
temp=temp*10+nums[j];
temp=temp*10+nums[k];  
if(!set.contains(temp)&&temp%2==0){
    ans++;
    set.add(temp);
}    
            
        }
        }  
        }
        return ans;
    }
}