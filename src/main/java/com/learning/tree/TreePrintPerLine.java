package com.learning.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 按行输出二叉树的结点
 *
 * 有以下二叉树：
 * ___________________A
 * _______________B       C
 * ____________D    E  F
 * _________G    H
 * _______I  J K   L
 *
 * 输出结果： A B C D E F G H I J K L
 *
 * @author bw
 * @since 2020-10-23
 */
public class TreePrintPerLine {
    public static void main(String[] args) {
        TreeNode I = new TreeNode("I", null, null);
        TreeNode J = new TreeNode("J", null, null);
        TreeNode G = new TreeNode("G", I, J);

        TreeNode K = new TreeNode("K", null, null);
        TreeNode L = new TreeNode("L", null, null);
        TreeNode H = new TreeNode("H", K, L);

        TreeNode D = new TreeNode("D", G, H);
        TreeNode E = new TreeNode("E", null, null);
        TreeNode B = new TreeNode("B", D, E);

        TreeNode F = new TreeNode("F", null, null);
        TreeNode C = new TreeNode("C", F, null);

        TreeNode root = new TreeNode("A", B, C);

        printTreeNodeByDFS(root);
        //printTreeNodeByBFS(root);
    }

    /**
     * DFS 深度优先算法（循环法）
     * 先将每一层结点添加到叶子结点，再循环层级打印该层的结点
     */
    private static void printTreeNodeByDFS(TreeNode root) {
        List<List<TreeNode>> list = new ArrayList();
        collect(root, 0, list);

        for (List<TreeNode> ls : list) {
            for (TreeNode l : ls) {
                System.out.print(l.data + " ");
            }
        }
    }

    private static void printTreeNodeByBFS(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        printTreeNodeByQueue(queue);
    }

    /**
     * @param root  当前结点
     * @param level 层级
     * @param res   每一层有一个List<T>收集当前层级的结点个数
     */
    private static void collect(TreeNode root, int level, List<List<TreeNode>> res) {
        if (root == null) return;

        if (level == res.size()) { // 访问每一层第一个结点时，level刚好等于res.size()
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            res.add(list);
        } else {
            res.get(level).add(root);
        }

        collect(root.leftChildNode, level + 1, res);
        collect(root.rightChildNode, level + 1, res);
    }

    /**
     * BFS 广度优先算法（队列法）
     * 利用队列先进先出，边出队边入队子结点到队列
     */
    private static void printTreeNodeByQueue(LinkedList<TreeNode> queue) {
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode != null) {
                System.out.print(treeNode.data + " ");
                queue.offer(treeNode.leftChildNode);
                queue.offer(treeNode.rightChildNode);
            }
        }
    }

    private static class TreeNode {
        private String data;
        private TreeNode leftChildNode;
        private TreeNode rightChildNode;

        public TreeNode(String data, TreeNode leftChildNode, TreeNode rightChildNode) {
            this.data = data;
            this.leftChildNode = leftChildNode;
            this.rightChildNode = rightChildNode;
        }
    }
}
