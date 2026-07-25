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
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        HashMap<ListNode , Integer> mapA = new HashMap<>();
        while(nodeA != null){
            mapA.put( nodeA , mapA.getOrDefault(mapA.get(nodeA.val),0)+1);
            nodeA = nodeA.next;
        }

        while(nodeB != null){
            if(mapA.containsKey(nodeB)){
                return nodeB;
            }
            nodeB = nodeB.next;
        }

        return null;

    }
}