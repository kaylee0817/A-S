package leetcode.linkedList.RemoveLinkedListElements;

/**
 * 使用dummyHead，这样head也有前置节点，不用单独判断了
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;


        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            }else {
                prev = prev.next ;
            }
        }
        return dummyHead.next;
    }
}
