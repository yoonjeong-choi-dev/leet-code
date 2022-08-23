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
        if(head == null || head.next == null) return true;
        
        // 2n -> (n, n) 2n+1 -> (n+1, n)
        ListNode first = head, second = head.next;
        while(second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }
        
        second = first.next;
        first.next = null;
        
        // reverse second
        ListNode prev = null, cur = second, temp;
        while(cur!=null) {
            // prev -> cur => prev <- cur
            temp = cur.next;
            cur.next = prev;
            
            prev = cur;
            cur = temp;
        }
        
        first = head;
        second = prev;
        
        while(second != null) {
            if(first.val != second.val) return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }
}