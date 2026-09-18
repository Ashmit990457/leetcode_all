class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n=s.length();
        int []start=new int[26];
           int []end=new int[26];
              boolean []isvalid=new boolean[26];
              Arrays.fill(start,-1);
              List<String>ans=new ArrayList<>();
              for(int i=0;i<n;i++){
                char c=s.charAt(i);
                if(start[c-'a']==-1){
                    start[c-'a']=i;
                }
                end[c-'a']=i;
              }
              for(int c=0;c<26;c++){
                if(start[c]==-1)continue;
                isvalid[c]=true;
                for(int i=start[c];i<=end[c];i++){
                    if(start[s.charAt(i)-'a']<start[c]){
                        isvalid[c]=false;
                        break;
                    }
                    end[c]=Math.max(end[c],end[s.charAt(i)-'a']);
                }
              }
              int laststart=Integer.MAX_VALUE;
              for(int i=n-1;i>=0;i--){
                int c=s.charAt(i)-'a';
                if(!isvalid[c])continue;
                if(i==start[c]&&end[c]<laststart){
                    ans.add(s.substring(i,end[c]+1));
                    laststart=i;
                }
              }

         return ans;
        

    }
}