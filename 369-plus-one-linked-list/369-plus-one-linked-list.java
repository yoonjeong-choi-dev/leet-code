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
    public ListNode plusOne(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while(cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        
        int carry = 1;
        while(!stack.isEmpty()){
            cur = stack.pop();
            cur.val += carry;
            
            if(cur.val > 9) {
                cur.val -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
        }
        
        return carry == 1 ? new ListNode(1, head) : head;
    }
}