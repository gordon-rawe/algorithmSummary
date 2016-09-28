package lastk;

/**
 * Created by gordon on 16/9/28.
 */
public class LastKNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node buildList() {
        Node root = new Node(0);
        Node lastNode = root;
        for (int i = 1; i < 100; i++) {
            Node tmpNode = new Node(i);
            lastNode.next = tmpNode;
            lastNode = tmpNode;
        }
        return root;
    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    public static void printLastK(Node head, int k) throws Exception {
        if (head == null) throw new Exception("null linked list found");
        if (k <= 0) throw new Exception("k should be no smaller than 1.");
        Node p1 = head, p2 = head;
        while (k > 1) {
            if (p1.next == null) throw new Exception("k are bigger than linked list length");
            p1 = p1.next;
            k--;
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        System.out.println(p2.value);
    }

    public static void main(String[] args) {
        Node source = buildList();
        printLinkedList(source);
        try {
            printLastK(source, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
