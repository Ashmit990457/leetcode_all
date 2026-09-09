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
    public ListNode oddEvenList(ListNode head) {
        ArrayList<Integer>less=new ArrayList<>();
        ArrayList<Integer>great=new ArrayList<>();
        ListNode temp=head;
        int count=1;
        while(temp!=null){
            if(count%2!=0){
                less.add(temp.val);
            }
            else{
                great.add(temp.val);
            }
            count++;
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