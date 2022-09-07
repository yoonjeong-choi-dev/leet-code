/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if(head == null) {
            node.next = node;
            return node;
        }
        
        // find prev.val > cur.val
        // => cur.val is the minimum
        Node prev = head, cur = head.next;
        while(cur != head && prev.val <= cur.val) {
            prev = cur;
            cur = cur.next;
        }
        
        if(insertVal <= cur.val || insertVal >= prev.val) {
            // prev -> node -> cur
            prev.next = node;
            node.next = cur;
        } else  {
            // find prev.val <= insertVal <= cur.val
            while(insertVal > cur.val) {
                prev = cur;
                cur = cur.next;
            }
            prev.next = node;
            node.next = cur;
        }
        return head;
    }
}