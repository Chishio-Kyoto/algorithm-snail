package linkedList;

public class ListNodeSample001 {
    public static void main(String[] args) {
        Node initNode = new Node(1);
        for (int i = 2; i < 9; i++) {
            initNode.append2(initNode, i);
        }

        Node lastNode = removeNthFromEnd(initNode, 2);
        while(lastNode.next != null) {
            System.out.println(lastNode.val);
            lastNode = lastNode.next;
        }
        System.out.println(lastNode.val);

    }

    // 运用：前后双指针
    public static Node removeNthFromEnd(Node head, int n) {
        // 创建哨兵节点
        Node dummy = new Node(0);
        dummy.next = head;

        Node front = head, back = dummy;
        for(int i = 0; i < n; i++) {
            front = front.next;
        }
        while (front != null) {
            front = front.next;
            back = back.next;
        }
        
        back.next = back.next != null ? back.next.next : null;
        return dummy.next;
    }
}
