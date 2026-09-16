/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode temp=head;
while(temp.next!=null){
    temp.next=reverse(temp.next);
    temp=temp.next;
}
    }
    ListNode reverse(ListNode node){
       ListNode prev=null;
       ListNode curr=node;
       ListNode next=node.next;
       while(curr!=null){
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
        
       }
    return prev;
    }
}
