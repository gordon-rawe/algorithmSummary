package mergelinkedlist;

import lastk.LastKNode;

/**
 * Created by gordon on 16/9/28.
 */
public class MergeTwoSortedLinkedList {

    public static void printLinkedList(LastKNode.Node head) {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    public static LastKNode.Node buildList1() {
        LastKNode.Node root = new LastKNode.Node(0);
        LastKNode.Node lastNode = root;
        for (int i = 3; i < 50; i += 3) {
            LastKNode.Node tmpNode = new LastKNode.Node(i);
            lastNode.next = tmpNode;
            lastNode = tmpNode;
        }
        return root;
    }

    public static LastKNode.Node buildList2() {
        LastKNode.Node root = new LastKNode.Node(0);
        LastKNode.Node lastNode = root;
        for (int i = 1; i < 60; i += 2) {
            LastKNode.Node tmpNode = new LastKNode.Node(i);
            lastNode.next = tmpNode;
            lastNode = tmpNode;
        }
        return root;
    }

    public static LastKNode.Node mergeTwoSortedLinkedList(LastKNode.Node h1, LastKNode.Node h2) {
        LastKNode.Node retHead = h1.value < h2.value ? h1 : h2;
        LastKNode.Node head1 = h1.value < h2.value ? h2 : h1, head2 = retHead;
        while (head1 != null && head2 != null) {
            if(head1.value < head2.value){// head1 -> head2
                LastKNode.Node tmpNode = head2;
                head2 = head2.next;
                head1.next = tmpNode;
            }else{

            }
        }
        return retHead;
    }

    public static void main(String[] args) {
        printLinkedList(buildList1());
        System.out.println();
        printLinkedList(buildList2());
    }
}
