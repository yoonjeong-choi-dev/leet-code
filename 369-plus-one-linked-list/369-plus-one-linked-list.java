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
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        int isCarry = 1;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            cur.val += isCarry;

            if (cur.val > 9) {
                cur.val -= 10;
                isCarry = 1;
            } else {
                isCarry = 0;
            }
        }

        if (isCarry == 1) {
            head = new ListNode(1, head);
        }


        return head;
    }
}