class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length;
        List<List<String>> ans=new ArrayList<>();
        HashMap<Character,Integer> map[]=new HashMap[n];
        for(int i=0;i<n;i++){
            map[i]=new HashMap<>();
        }
        for(int i=0;i<n;i++){
            String s=strs[i];
            for(int j=0;j<s.length();j++){
                char c=s.charAt(j);
                map[i].put(c,map[i].getOrDefault(c,0)+1);
            }
        }
        HashSet<String>set=new HashSet<>();
        for(int i=0;i<n;i++){
             if(set.contains(strs[i])){
                continue;
             }
            List<String>temp=new ArrayList<>();
            temp.add(strs[i]);
            for(int j=i+1;j<n;j++){
               
if(map[i].equals(map[j])){
            temp.add(strs[j]);
            set.add(strs[j]);
        }
            }
            ans.add(new ArrayList<>(temp));
        }
return ans;
    }
}