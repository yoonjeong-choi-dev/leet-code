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
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode cur = head, next;
        m--;

        while (cur != null) {
            // 삭제 노드 이전 노드까지 이동
            for (int i = 0; i < m; i++) {
                cur = cur.next;
                if (cur == null) return head;
            }

            // 삭제 노드 다음 노드까지 이동
            next = cur.next;
            for (int i = 0; i < n; i++) {
                
                if (next == null) break;
                next = next.next;
            }

            cur.next = next;
            cur = next;
        }

        return head;
    }
}