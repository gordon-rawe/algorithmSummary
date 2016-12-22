package deletelinkedlistduplicates;

import linknode.Node;

/**
 * Created by gordon on 16/12/18.
 */
public class DeleteLinkedListDuplicates {
    public static Node deleteDuplicates(Node head) {
        if (head == null || head.next == null) return head;
        Node current = head, last = null;
        while (current != null) {
            boolean needDelete = current.next != null && current.next.value == current.value;
            if (!needDelete) {
                last = current;
                current = current.next;
            } else {
                int value = current.value;
                while (current != null && current.value == value) {
                    current = current.next;
                }
                if (last == null) {/*head node*/
                    head = current;
                } else {
                    last.next = current;
                }
            }
        }
        return head;
    }

    public static Node buildSample() {
        Node node = new Node(2);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(4);
        node.next.next.next.next.next = new Node(4);
//        node.next.next.next.next.next.next = new Node(5);
        return node;
    }

    public static void main(String[] args) {
        Node sample = buildSample();
        sample = deleteDuplicates(sample);
        while (sample!=null){
            System.out.println(sample.value);
            sample = sample.next;
        }
    }
}
