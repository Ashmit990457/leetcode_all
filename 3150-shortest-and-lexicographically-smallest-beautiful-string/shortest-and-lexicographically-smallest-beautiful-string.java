class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int i = 0;
        String res = "";
        int j = 0;
        int ans = Integer.MAX_VALUE;
        int count = 0;
        while (j < s.length()) {
           
                char c = s.charAt(j);
                if (c == '1') {
                    count++;
                }
                j++;
    
                while(count==k){
                int temp = j-i;
              
                   String curr = s.substring(i, j);
                if (ans > temp) {
                    ans = temp;
                    res = curr;
                } else if (ans == temp) {
                    if (res.equals("") || curr.compareTo(res) < 0) {
                        res = curr;
                    }

                }
                if (s.charAt(i) == '1') {
                    count--;
                }
                i++;

            
            }
        }
        return res;
    }
}
