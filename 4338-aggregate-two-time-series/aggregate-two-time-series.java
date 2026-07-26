class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        int n=series1.length;
        int m=series2.length;   
        List<List<Integer>>list =new ArrayList <>();
        int i=0;int j=0;
        while(i<n&&j<m){
List<Integer>temp =new ArrayList <>();
if(series1[i][0]<series2[j][0]){
    temp.add(series1[i][0]);
temp.add(series1[i][1]+series2[j][1]);
i++;
}else if(series1[i][0]>series2[j][0]){
    temp.add(series2[j][0]);
temp.add(series1[i][1]+series2[j][1]);
    j++;
}
    else{ 
        temp.add(series1[i][0]);
temp.add(series1[i][1]+series2[j][1]);

         i++;j++;
        }
    list.add(new ArrayList<>(temp));
        }
        if(i==n&&j<m){
while(j<m){
List<Integer>temp =new ArrayList <>();
    temp.add(series2[j][0]);
temp.add(0+series2[j][1]);
    list.add(new ArrayList<>(temp));
    j++;
        }
}
        if(j==m&&i<n){
while(i<n){
List<Integer>temp =new ArrayList <>();
    temp.add(series1[i][0]);
temp.add(0+series1[i][1]);
    list.add(new ArrayList<>(temp));
    i++;
        }
}
return list;
    }
}