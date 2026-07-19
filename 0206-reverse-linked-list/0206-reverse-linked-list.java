/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode    () {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode present = head;
        if(head == null){
            return head;
        }
        ListNode nextNode = present.next;
        while(present != null){
            present.next = prev;
            prev = present;
            present = nextNode;
            if(nextNode!=null){
                nextNode = nextNode.next;
            }
        }
        return prev;
    }
}