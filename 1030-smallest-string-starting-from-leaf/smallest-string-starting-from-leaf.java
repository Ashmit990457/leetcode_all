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
    String ans="";
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder s=new StringBuilder();
        fun(root,s);
        return ans;
    }
  void fun(TreeNode root,StringBuilder current){
        if(root==null){
            return;
        }
        current.append((char)('a'+root.val));
        if(root.left==null&&root.right==null){
           String temp=new StringBuilder(current).reverse().toString();
if(ans.equals("")||temp.compareTo(ans)<0){
    ans=temp;
}
        }
fun(root.left,current);
fun(root.right,current);
current.deleteCharAt(current.length()-1);
return;
        
    }
}