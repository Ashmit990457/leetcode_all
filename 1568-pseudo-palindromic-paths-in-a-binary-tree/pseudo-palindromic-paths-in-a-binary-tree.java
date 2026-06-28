/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        HashMap<Integer,Integer>map=new HashMap<>();
       fun(root,map);
       return ans; 
    }
    void fun(TreeNode root,HashMap<Integer,Integer>map){
        if(root==null){
            return;
        }
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        if(root.left==null&&root.right==null){
            int count=0;
            for(int k:map.keySet()){
                if(map.get(k)%2!=0){
                    count++;
                }
            }
            if(count==0||count==1){
                ans++;
            }
        }
        fun(root.left,map);
        fun(root.right,map);
        if(map.get(root.val)>=1){
        map.put(root.val,map.get(root.val)-1);
        }
        return;
    }
}