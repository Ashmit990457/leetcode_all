/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node>q=new LinkedList<>();
          Node helper=null;
        if(root==null)return null;
        q.add(root);
        while(!q.isEmpty()){
            int s=q.size();
            helper=q.poll();
              if(helper.left!=null){
                q.add(helper.left);
                }
                 if(helper.right!=null){
                q.add(helper.right);
                }
            s--;
            while(s!=0){
                Node temp=q.poll();
                helper.next=temp;
                helper=temp;
                if(helper.left!=null){
                q.add(helper.left);
                }
                 if(helper.right!=null){
                q.add(helper.right);
                }
                s--;
            }
helper.next=null;
        }
        return root;
    }
}