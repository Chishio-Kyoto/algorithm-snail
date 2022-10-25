package sample.linkedList;

public class Sample001 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        for (int i = 2; i < 9; i++) {
            ListNode.append(node1, i);
        }
        ListNode.printList(node1);

        ListNode.delete(node1, 6);
        ListNode.printList(node1);

        ListNode.update(node1, 7, 6);
        ListNode.update(node1, 8, 7);
        ListNode.printList(node1);
    }
}
