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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        
        ListNode cur = head;
        while(cur != null) {
            cur = cur.next;
            len++;
        }
        
        int target = len - n;
        if(target == 0) return head.next;
        
        ListNode prev = null;
        cur = head;
        
        while(target != 0) {
            prev = cur;
            cur = cur.next;
            target--;
        }
        
        prev.next = (cur != null)? cur.next : null;
        return head;
    }
}