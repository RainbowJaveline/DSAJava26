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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode node = head;
        int count = 0;
        ListNode temp = head;
        while(node!=null){
            temp = node;
            node = node.next;
            count++;
        }
        k = k%count;
        if(k == 0) return head;
        int diff = count - k;
        ListNode tail = head;
        while(diff != 1){
            diff--;
            tail = tail.next;
        }
        temp.next = head;
        ListNode dummy = tail.next;
        tail.next = null;
        return dummy;    
    }
}