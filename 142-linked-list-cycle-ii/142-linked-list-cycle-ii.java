/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = getNext(head), fast = getNext(slow);
        
        while(slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        
        // no cycle
        if(slow == null) return null;
        
        // f(n) = slow = fast = f(2n) : contained in cycle
        // => n = k*T for some k where T : length of the cycle
        // Let L be the position of the node where the cycle begins
        // => f(L) = f(L + k*T) = f(n+L)
        ListNode ans = head;
        while(ans != slow) {
            ans = ans.next;
            slow = slow.next;
        }
        
       return ans;
    }
    
    private ListNode getNext(ListNode node) {
        return node == null ? null : node.next;
    }
}