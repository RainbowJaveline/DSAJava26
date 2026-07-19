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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        while(fast != null && fast.next != null){
            count++;
            fast = fast.next.next;
            slow = slow.next;
        }
        if(slow.next == null){
            head.next = null;
            return head;
        }
        ListNode temp = head;
        for(int i = 1 ; i<count ; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;

    }
}