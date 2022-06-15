/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // node를 node.next로 대체
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}