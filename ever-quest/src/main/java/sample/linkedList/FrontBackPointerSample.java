package sample.linkedList;

public class FrontBackPointerSample {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        for (int i = 2; i < 7; i++) {
            ListNode.append(node1, i);
        }
        ListNode.printList(node1);

        // 删除倒数第2个节点
        FrontBackPointerSample.removeNthFromEnd(node1, 2);
        ListNode.printList(node1);
    }

    /**
     * 删除倒数第K个节点
     */
    public static Node removeNthFromEnd(Node head, int n) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node front = head, back = dummy;
        for (int i = 0; i < n; i++) {
            front = front.next;
        }

        while (front != null) {
            front = front.next;
            back = back.next;
        }

        // 此时back在倒数第k+1,目标节点为k，即back.next
        if (back.next != null) {
            back.next = back.next.next;
        }
        return dummy.next;
    }
}
