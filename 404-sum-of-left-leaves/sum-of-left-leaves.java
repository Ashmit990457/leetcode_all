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
    int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        fun(root,false);
        return sum;
    }
    void fun(TreeNode root,boolean left){
        if(root==null){
            return;
        }
        if(left==true&&root.left==null&&root.right==null){
            sum+=root.val;
            return;

        }
        fun(root.left,true);
        fun(root.right,false);
    }
}