package ringdetection;

import linkedlist.Node;

/**
 * Created by gordon on 16/12/21.
 */
public class RingDetection {
    public static Node detectRing(Node head) {
        if (head == null) return null;
        Node slow = head.next;
        if (slow == null) return null;
        Node fast = slow.next;
        while (fast != null && slow != null) {
            if (slow == fast) return slow;
            slow = slow.next;
            if (fast.next != null) fast = fast.next.next;
            else break;
        }
        return null;
    }

    public static Node entryOfRing(Node head) {
        if (head == null) return null;
        Node meetNode = detectRing(head);
        if (meetNode == null) return null;
        int count = 1;
        Node p = meetNode.next;
        while (p != meetNode) {
            count++;
            p = p.next;
        }
        Node pre = head, later = head;
        for (int i = 0; i < count; i++) {
            pre = pre.next;
        }
        while (later != pre) {
            later = later.next;
            pre = pre.next;
        }
        return pre;
    }
}
