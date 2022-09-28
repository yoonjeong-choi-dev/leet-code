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
        ListNode dummy = new ListNode(-1, head);
        
        ListNode first = dummy;
        
        // first : n 번째 노드
        for(int i=0;i<=n;i++) first = first.next;
        
        // first : len-n 만큼 이동 => first == null
        // => second : len - n 만큼 이동 => second.next : len-n 번째 노드 i.e 삭제할 노드
        ListNode second = dummy;
        while(first != null) {
            first = first.next;
            second = second.next;
        }
        
        // second.next 삭제
        second.next = second.next.next;
        return dummy.next;
    }
}