package com.learning.tree;

/**
 * 先序输出二叉树的结点（先根后子结点）
 *
 * 有以下二叉树：
 * ___________________A
 * _______________B       C
 * ____________D    E  F
 * _________G    H
 *
 * 输出结果： A B D G H E C F
 *
 * @author bw
 * @since 2020-10-23
 */
public class TreePrintOfPreOrder {
    public static void main(String[] args) {
        TreeNode G = new TreeNode("G", null, null);
        TreeNode H = new TreeNode("H", null, null);

        TreeNode D = new TreeNode("D", G, H);
        TreeNode E = new TreeNode("E", null, null);
        TreeNode B = new TreeNode("B", D, E);

        TreeNode F = new TreeNode("F", null, null);
        TreeNode C = new TreeNode("C", F, null);

        TreeNode A = new TreeNode("A", B, C);

        printTreeNode(A);
    }

    private static void printTreeNode(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.print(treeNode.data + " ");
            printTreeNode(treeNode.leftChildNode);
            printTreeNode(treeNode.rightChildNode);
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
