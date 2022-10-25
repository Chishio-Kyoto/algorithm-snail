package sample.linkedList;

public class Sample002 {
    public static void main(String[] args) {
        DummyListNode node1 = new DummyListNode(1);
        for (int i = 2; i < 9; i++) {
            DummyListNode.append(node1, i);
        }
        DummyListNode.printList(node1);

        DummyListNode.delete(node1, 6);
        DummyListNode.printList(node1);

        DummyListNode.update(node1, 7, 6);
        DummyListNode.update(node1, 8, 7);
        DummyListNode.printList(node1);
    }
}
