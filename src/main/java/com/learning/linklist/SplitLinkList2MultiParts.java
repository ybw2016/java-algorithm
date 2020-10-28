package com.learning.linklist;

import java.util.ArrayList;
import java.util.List;

/**
 * 将链表拆成N个子链接
 *
 * 样例一：
 * 输入链表:（拆成3个子链表）
 * 1 2 3 4 5 6 7 8 9
 *
 * 输出链表:
 * 1 2 3
 * 4 5 6
 * 7 8 9
 */
public class SplitLinkList2MultiParts {
    public static void main(String[] args) {
        Node head = generateLinkList(12);

        System.out.println("raw linked list:");
        print(head);
        System.out.println();

        List<Node> heads = new ArrayList<>();
        heads.add(head);
        List<Node> subLinkListHeads = splitLinkedList2NParts(head, heads, 4);

        System.out.println("linked list has been split into several sub linked list:");
        subLinkListHeads.forEach(subLinkListHead -> {
            print(subLinkListHead);
            System.out.println();
        });
    }

    private static List<Node> splitLinkedList2NParts(Node head, List<Node> heads, int parts) {
        if (head == null || head.next == null) {
            return null;
        }

        // 获取断裂的中间结点（快慢指针）
        NodeStep nodeStep = getFirstNodeStep(head, parts);

        // 分裂成两个链表
        Node subHead = nodeStep.firstSplitNode.next;
        nodeStep.firstSplitNode.next = null;

        // 剩下的分成N-1等分
        splitSubLinkList(subHead, nodeStep.step, heads);

        return heads;
    }

    private static void splitSubLinkList(Node head, int steps, List<Node> heads) {
        if (head == null) {
            return;
        }

        heads.add((head));

        Node p = head;
        int stepCount = 1;
        while (p != null) {
            if (stepCount == steps) {
                // 断裂链表
                Node subHead = p.next;
                p.next = null;

                // 链表剩下的部分继续断裂
                splitSubLinkList(subHead, steps, heads);
            }

            p = p.next;
            stepCount++;
        }
    }

    private static NodeStep getFirstNodeStep(Node head, int parts) {
        Node quick = head;
        Node slow = head;
        int stepCount = 0;
        int totalCount = 0;
        while (quick != null) {
            if (stepCount == parts) {
                slow = slow.next;
                stepCount = 0;
            }
            quick = quick.next;
            stepCount++;
            totalCount++;
        }

        //if (totalCount % parts != 0) {
        //    throw new RuntimeException("链表结点数必须是分割数的整数倍！");
        //}

        NodeStep nodeStep = new NodeStep();
        nodeStep.firstSplitNode = slow;

        nodeStep.step = Math.round(totalCount / parts);
        return nodeStep;
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

    private static class NodeStep {
        private Node firstSplitNode;
        private int step;
    }
}
