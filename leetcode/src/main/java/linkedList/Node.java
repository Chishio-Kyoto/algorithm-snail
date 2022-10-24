package linkedList;

public class Node {
    int val;
    Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    // 在链表尾部添加一个节点
    public Node append(Node head, int value) {
        Node newNode = new Node(value);
        // 空节点处理
        if (head == null) {
            return newNode;
        }

        Node node = head;
        while(node.next != null) {
            node = node.next;
        }

        node.next = newNode;
        return head;
    }

    // 在链表尾部添加一个节点，使用哨兵节点
    public Node append2(Node head, int value) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node newNode = new Node(value);
        Node node = dummy;
        // 无需判断节点是否为空
        while(node.next != null) {
            node = node.next;
        }

        node.next = newNode;
        return dummy.next;
    }

    // 从链表中删除第1个值为指定值的节点
    public Node delete(Node head, int value) {
        // 链表为空
        if (head == null) {
            return null;
        }

        // 被删除的节点是原始链表的头节点
        if (head.val == value) {
            return head.next;
        }

        Node node = head;
        while (node.next != null) {
            if (node.next.val == value) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return head;
    }

    // 从链表中删除第1个值为指定值的节点
    public Node delete2(Node head, int value) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node node = dummy;
        while (node.next != null) {
            if (node.next.val == value) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return dummy.next;
    }
}