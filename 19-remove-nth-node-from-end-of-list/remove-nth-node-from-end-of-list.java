class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Dummy node banaya
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // fast pointer ko n steps aage le jao
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Dono pointers ko move karo
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Node remove karo
        slow.next = slow.next.next;

        return dummy.next;
    }
}
