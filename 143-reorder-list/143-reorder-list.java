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
    public void reorderList(ListNode head) {
        ListNode hare = head, tortoise = head;
        while(hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        
        // (n,n) or (n+1,n) 형태로 쪼개짐
        hare = tortoise.next;
        tortoise.next = null;
        tortoise = head;
        
        // reverse hare : 뒷부분 뒤집기
        hare = reverse(hare);
        
        // Merge two list node
        ListNode temp;
        while(hare != null) {
            temp = tortoise.next;
            tortoise.next = hare;
            tortoise = temp;
            
            temp = hare.next;
            hare.next = tortoise;
            hare = temp;
        }
        
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head, temp;
        while(cur != null) {
            temp = cur.next;
            cur.next = prev;
            
            prev = cur;
            cur = temp;
        }
        
        return prev;
    }
}