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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        int lvl=0;
        q.add(root);        
        while(q.size()>0){
            int s=q.size();
          int min=Integer.MAX_VALUE;
           int max=Integer.MIN_VALUE;
            if(lvl%2==0){
            while(s!=0){
                  TreeNode temp=q.poll();
                  if(temp.val%2==0||temp.val<=max){
                    return false;
                  }
                  if(temp.left!=null){
                    q.add(temp.left);
                  }
                  if(temp.right!=null){
                    q.add(temp.right);
                  }
                  max=temp.val;
                  s--;
            }
            }
            else{
                 while(s!=0){
                  TreeNode temp=q.poll();
                  if(temp.val%2!=0||temp.val>=min){
                    return false;
                  }
                  if(temp.left!=null){
                    q.add(temp.left);
                  }
                  if(temp.right!=null){
                    q.add(temp.right);
                  }
                  min=temp.val;
                  s--;
            }
            }
            lvl++;
        
        }
        return true;
    }
}