class Solution {
    public int minChanges(String s) {
        int ans=0;
        int i=0;
        while(i+1<s.length()){
            if(s.charAt(i)!=s.charAt(i+1)){
                ans++;
            }
            i+=2;
        }
        return ans;
    }
}