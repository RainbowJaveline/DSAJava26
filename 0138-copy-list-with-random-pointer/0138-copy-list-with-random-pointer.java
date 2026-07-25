/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        while(temp != null){
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }

        temp = head;
        while(temp!=null && temp.next!=null){
            Node copyNode = temp.next;
            if(temp.random == null){
                copyNode.random = null;
            }else{
                copyNode.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        temp = head;
        Node dummyNode = new Node(-1);
        Node res = dummyNode;
        while(temp!= null && temp.next!=null){
            res.next = temp.next;
            temp.next = temp.next.next;
            temp = temp.next;
            res = res.next;
        }

        return dummyNode.next;
    }
}