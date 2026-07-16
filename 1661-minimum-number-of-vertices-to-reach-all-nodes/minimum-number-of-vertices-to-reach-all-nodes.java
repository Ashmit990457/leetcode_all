class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        ArrayList<Integer>list =new ArrayList <>();
        int arr[]=new int [n]; 
for(int i=0;i<n;i++){
    arr[i]=0;
}
    for(int i=0;i<edges.size();i++){
        int des=edges.get(i).get(1);
arr[des]+=1;
    }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                list.add(i);
            }
        }
return list;
    }
}