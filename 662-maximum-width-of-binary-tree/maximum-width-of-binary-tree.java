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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Sp>q=new LinkedList<>();
        int ans=0;
        q.add(new Sp(root,1));
        while(q.size()>0){
            int s=q.size();
            int first=0;
            int last=0;
           for(int i=0;i<s;i++){
                Sp temp=q.poll();
                if(i==0){
first=temp.idx;
                }
                if(i==s-1){
                    last=temp.idx;
                }
                if(temp.root.left!=null){
                    q.add(new Sp(temp.root.left,temp.idx*2));
                }
                 if(temp.root.right!=null){
                    q.add(new Sp(temp.root.right,temp.idx*2+1));
                }
            }
            ans=Math.max(ans,last-first+1);
        }
        return ans;
    }
    class Sp{
        TreeNode root;
        int idx;
        Sp(TreeNode root,int idx){
            this.root=root;
            this.idx=idx;
        }
    }
}