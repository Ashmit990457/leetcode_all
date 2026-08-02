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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1=l1;ListNode temp2=l2;
    int carry=0;   
        ListNode head=null;
        ListNode tail=null;
while(temp1!=null||temp2!=null){
int x1=0;
    int x2=0;
    if(temp1!=null){
        x1=temp1.val;
}
    if(temp2!=null ){
        x2=temp2.val;
    }
int sum=x1+x2+carry;
    carry=sum/10;   
sum=sum%10;
ListNode node=new ListNode();
    node.val=sum;
    if(head==null){
head=node;
        tail=node;
}else{
    tail.next=node;
    tail=node;
    }
    if(temp1!=null){
temp1= temp1.next;
    }
if(temp2!=null){
temp2=temp2.next;  
 }
    
}
        if(carry>0){
            ListNode node=new ListNode();
            node.val=carry;
            tail.next=node;
        }
        return head;
    }
}