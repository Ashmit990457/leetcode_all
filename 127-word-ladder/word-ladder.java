class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String,Integer>map=new HashMap<>();
        int n=wordList.size();
        for(int i=0;i<n;i++){
            map.put(wordList.get(i),1);
        }
        if(!map.containsKey(beginWord)){
            map.put(beginWord,1);
        }
         if(!map.containsKey(endWord)){
           return 0;
        }
        Queue<pair>q=new LinkedList<>();
        q.add(new pair(beginWord,1));
        map.remove(beginWord);
        while(q.size()>0){
            pair temp=q.poll();
            String w=temp.word;
            char arr[]=w.toCharArray();
            int val=temp.val;
            if(w.equals(endWord)){
                return val;
            }
            for(int i=0;i<arr.length;i++){
                char c=arr[i];
                for(int j='a';j<='z';j++){
                    char d=(char)j;
                    if(d==c){
                        continue;
                    }
                    arr[i]=d;
                    String nw = new String(arr);
                    if(map.containsKey(nw)){
                        q.add(new pair(nw,val+1));
                        map.remove(nw);
                    }
                }
               arr[i]=c;
            }
        }
        return 0;

    }
}
class pair{
    String word;
    int val;
    pair(String word,int val){
        this.word=word;
        this.val=val;
    }
}