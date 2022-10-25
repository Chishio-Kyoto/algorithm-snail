package sample.linkedList;

public class DummyListNode extends Node{
    public DummyListNode() {

    }

    public DummyListNode(int val) {
        this.val = val;
    }

    public DummyListNode(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    // 遍历打印
    public static void printList(Node head) {
        if (head == null) {
            System.out.println("该链表为空");
        }

        Node tempNode = head;
        while(tempNode.next != null) {
            System.out.print(tempNode.val + " ");
            tempNode = tempNode.next;
        }
        // 打印尾节点的值
        System.out.println(tempNode.val);
    }

    // 在尾部添加新节点
    public static Node append(Node head, int value) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node newNode = new Node(value);
        Node tempNode = dummy;
        while(tempNode.next != null) {
            tempNode = tempNode.next;
        }
        // 此时tempNode.next=null,即tempNode为尾节点
        tempNode.next = newNode;
        return dummy.next;
    }

    // 删除第1个指定值的节点
    public static Node delete(Node head, int value) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node tempNode = dummy;
        while(tempNode.next != null) {
            if (tempNode.next.val == value) {
                tempNode.next = tempNode.next.next;
                break;
            }
            tempNode = tempNode.next;
        }
        return dummy.next;
    }

    // 更新第1个指定值的节点
    public static Node update(Node head, int value1, int value2) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node tempNode = dummy;
        while(tempNode.next != null) {
            if (tempNode.next.val == value1) {
                tempNode.next.val = value2;
                break;
            }
            tempNode = tempNode.next;
        }
        return dummy.next;
    }
}
