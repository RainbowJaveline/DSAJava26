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
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(head.next == null && head == null){
            return true;
        }
        //find the middle
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse the linked list from the middle
        ListNode prev = null;
        ListNode present = slow;
        ListNode next = present.next;
        while(present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }

        ListNode p1 = head;
        ListNode p2 = prev;
        while(p1 != null && p2!= null){
            if(p1.val != p2.val){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}