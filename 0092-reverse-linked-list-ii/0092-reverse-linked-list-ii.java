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
    public ListNode reverseBetween(ListNode head, int left, int right) {

    if (head == null || head.next == null || left == right)
        return head;

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode leftNode = head;
    ListNode rightNode = head;

    while (left != 1) {
        leftNode = leftNode.next;
        left--;
    }

    while (right != 1) {
        rightNode = rightNode.next;
        right--;
    }

    ListNode prev = leftNode;
    ListNode present = prev.next;
    ListNode rightNext = rightNode.next;

    while (present != rightNext) {
        ListNode nextNode = present.next;

        present.next = prev;
        prev = present;
        present = nextNode;
    }

    ListNode leftprev = dummy;

    while (leftprev.next != leftNode) {
        leftprev = leftprev.next;
    }

    leftprev.next = rightNode;
    leftNode.next = rightNext;

    return dummy.next;
}

}



//        ListNode rightNext = rightNode.next;  

        
//         ListNode left2 = leftNode.next;
//         left2.next = rightNext;
//         leftNode.next = rightNode;
//         return head;