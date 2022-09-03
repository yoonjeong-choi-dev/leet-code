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
            len++;
            cur = cur.next;
        }
        
        n = len-n+1;
        
        ListNode ans = new ListNode(-1, head);
        
        ListNode prev = ans;
        cur = head;
        while(n!=1) {
            prev = cur;
            cur = cur.next;
            n--;
        }
        
        prev.next = cur.next;
        return ans.next;
    }
}