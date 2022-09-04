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
    public ListNode sortList(ListNode head) {
        return sort(head);
    }
    
    private ListNode sort(ListNode node) {
        // sort complete when len is 0 or 1
        if(node == null || node.next == null) return node;
        
        ListNode mid = divide(node);
        
        ListNode left = sort(node);
        ListNode right = sort(mid);
        
        return merge(left, right);
    }
    
    private ListNode merge(ListNode left, ListNode right) {
        ListNode ret = new ListNode(-1);
        ListNode cur = ret;
        
        while(left != null && right != null) {
            if(left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            
            cur = cur.next;
        }
        
        cur.next = left == null ? right : left;
        return ret.next;
    }
    
    
    private ListNode divide(ListNode node) {
        if(node == null || node.next == null) return node;
        
        ListNode right = node.next;
        while(right != null && right.next != null) {
            node = node.next;
            right = right.next.next;
        }
        
        right = node.next;
        node.next = null;
        return right;
    }
}