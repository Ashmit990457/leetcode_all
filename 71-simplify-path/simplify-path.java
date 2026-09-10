class Solution {
    public String simplifyPath(String s) {
        Stack<String>st=new Stack<>();
        int i=0;
        int n=s.length();
      while(i<n){
        if(s.charAt(i)=='/'){i++;continue;}
        StringBuilder sb=new StringBuilder();
        while(i<n&&s.charAt(i)!='/'){
            sb.append(s.charAt(i));
            i++;
        }
        String str=sb.toString();
        if(str.equals(".")){continue;}
        else if(str.equals("..")){
            if(!st.isEmpty()){
                st.pop();
                }
            }
      else{st.push(str);}
      }
       StringBuilder ans=new StringBuilder();
       while(!st.isEmpty()){
        ans.insert(0,st.pop());
         ans.insert(0,'/');
       }
       if(ans.length()==0){return "/";}
      return ans.toString();
    }
}