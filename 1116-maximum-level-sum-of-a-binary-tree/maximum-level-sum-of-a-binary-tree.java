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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        int levl=1;
        int max=Integer.MIN_VALUE;
        int ans=0;
        if(root==null){
            return 0;
        }
        q.add(root);
        while(q.size()>0){
            int s=q.size();
            int sum=0;
            while(s!=0){
TreeNode temp=q.poll();
sum+=temp.val;
if(temp.left!=null){
    q.add(temp.left);
}
if(temp.right!=null){
    q.add(temp.right);
}
s--;
            }
            if(sum>max){
                max=sum;
                ans=levl;
            }
            levl++;
        }
        return ans;
    }
}