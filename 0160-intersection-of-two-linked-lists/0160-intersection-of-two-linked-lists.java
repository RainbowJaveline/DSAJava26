/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //do not store the value store the entire node (ListNode)
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int countA = 0;
        int countB = 0;
        while(nodeA != null){
            countA++;
            nodeA = nodeA.next;
        }
        while(nodeB != null){
            countB++;
            nodeB = nodeB.next;
        }
        ListNode head1 = headA;
        ListNode head2 = headB; 
        int diff = Math.abs(countA - countB);
        if(countA > countB){
            while(diff != 0){
                diff--;
                head1 = head1.next;
            }
        }else{
            while(diff != 0){
                diff--;
                head2 = head2.next;
            }
        }

        while(head1!= null || head2!= null){
            if(head1 == head2){
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }
}