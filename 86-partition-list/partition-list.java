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
    public ListNode partition(ListNode head, int x) {
        ArrayList<Integer>less=new ArrayList<>();
        ArrayList<Integer>great=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            if(temp.val<x){
                less.add(temp.val);
            }
            else{
                great.add(temp.val);
            }
            temp=temp.next;
        }
ListNode h=null;
ListNode ans=null;
int i=0;
int j=0;
while(i<less.size()){
    ListNode node=new ListNode(less.get(i));
    if(h==null){
        h=node;
        ans=node;
    }else{
    h.next=node;
    h=node;
    }
    i++;
}
while(j<great.size()){
    ListNode node=new ListNode(great.get(j));
    if(h==null){
        h=node;
        ans=node;
    }else{
    h.next=node;
    h=node;
    }
    j++;
    
}
return ans;
    }
}