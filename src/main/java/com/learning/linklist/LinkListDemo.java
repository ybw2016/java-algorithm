package com.learning.linklist;

/**
 * 将链表的后半部分逆序并逐个插入到前半部分中
 *
 * 样例一：
 * 输入链表:
 * 1 2 3 4 5
 * 输出链表:
 * 1 5 2 4 3
 *
 * 样例二：
 * 输入链表:
 * 1 2 3 4
 * 输出链表:
 * 1 4 2 3
 */
public class LinkListDemo {
    public static void main(String[] args) {
        Node head = generateLinkList(5);

        System.out.println("raw linked list:");
        print(head);
        System.out.println();

        resortLinkedList(head);

        System.out.println("new linked list:");
        print(head);
    }

    private static void resortLinkedList(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        // 获取断裂的中间结点
        Node middleNode = getMiddleNode(head);

        // 分裂成两个链表
        Node subHead = middleNode.next;
        middleNode.next = null;

        // 链表倒置
        subHead = reverseLinkedList(subHead);

        // 合并链表
        reorderLinkedList(head, subHead);
    }


    private static Node getMiddleNode(Node head) {
        Node quick = head;
        Node slow = head;
        while (quick.next != null && quick.next.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node p = head;
        Node q = head.next;
        p.next = null;

        while (q.next != null) {
            Node qNext = q.next;
            q.next = p;
            p = q;
            q = qNext;
        }

        q.next = p;
        return q;
    }

    private static void reorderLinkedList(Node head, Node subHead) {
        Node p = head;
        Node s = subHead;

        while (s != null) {
            Node sNext = s.next;
            s.next = p.next;
            p.next = s;
            p = p.next.next;
            s = sNext;
        }
    }

    private static Node generateLinkList(int maxCount) {
        Node head = new Node(1, null);

        Node p = head;
        for (int i = 2; i <= maxCount; i++) {
            Node node = new Node(i, null);
            p.next = node;
            p = node;
        }
        return head;
    }

    private static void print(Node head) {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node {
        private Integer data;
        private Node next;

        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
