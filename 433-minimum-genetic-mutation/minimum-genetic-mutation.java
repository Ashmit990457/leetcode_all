class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String>set=new HashSet<>();
        char[]c={'A','C','G','T'};
        for(int i=0;i<bank.length;i++){
            set.add(bank[i]);
        }
        Queue<pair>q=new LinkedList<>();
        if(!set.contains(startGene)){
            set.add(startGene);
        }
        if(!set.contains(endGene)){
            return -1;
        }
        q.add(new pair(startGene,0));
        while(q.size()>0){
            pair temp=q.poll();
            String t=temp.s;
            int v=temp.val;
            if(t.equals(endGene)){
                return v;
            }
            set.remove(t);
            char arr[]=t.toCharArray();
            for(int i=0;i<arr.length;i++){
char a=arr[i];
for(int j=0;j<4;j++){
    if(a==c[j]){
        continue;
    }
arr[i]=c[j];
String ne=new String(arr);
if(ne.equals(endGene)){return v+1;}
if(set.contains(ne)){
    q.add(new pair(ne,v+1));
}
}arr[i]=a;
            }

        }
return -1;
    }
}
class pair{
    String s;
    int val;
    pair(String s,int val){
        this.s=s;
        this.val=val;
    }
}