public class S206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = head;
        while (next != null) {
            ListNode dummy = next.next;
            next.next = pre;
            pre = next;
            next = dummy;
        }

        return pre;
    }

    public static void main(String[] args) {
        S206 tester = new S206();

        ListNode head = new ListNode(1);
        ListNode node = head;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(5);
        // 1->2->3->4->5->NULL

        printNode(head);
        ListNode newHead = tester.reverseList(head);
        System.out.println();
        printNode(newHead);
    }

    private static void printNode(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.print("NULL");
    }
}
