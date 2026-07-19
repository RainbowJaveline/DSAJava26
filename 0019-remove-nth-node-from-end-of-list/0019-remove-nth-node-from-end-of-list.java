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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null && n == 1){
            head = null;
            return head;
        }
        ListNode temp = head;
        int count = 1;
        while(temp.next!=null){
            temp = temp.next;
            count++;
        }
        if(count == n){
            return head.next;
        }
        ListNode temp2 = head;
        for(int i = 1 ; i<count - n ; i++){
            temp2 = temp2.next;
        }
        if(temp2.next != null){
            temp2.next = temp2.next.next;
        }else{
            temp2.next = null;
        }
        return head;
    }
}