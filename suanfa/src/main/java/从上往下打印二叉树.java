import common.BinaryTreeNode;

import javax.swing.tree.TreeNode;

public class 从上往下打印二叉树 {
    public static void solution(BinaryTreeNode tree){
        if (tree==null){
            return;
        }
        System.out.println(tree.val);
        solution(tree.left);
        solution(tree.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode treeNode = new BinaryTreeNode(8);
        BinaryTreeNode treeNode1 = new BinaryTreeNode(6);
        BinaryTreeNode treeNode2 = new BinaryTreeNode(10);
        BinaryTreeNode treeNode3 = new BinaryTreeNode(5);
        BinaryTreeNode treeNode4 = new BinaryTreeNode(7);
        BinaryTreeNode treeNode5 = new BinaryTreeNode(9);
        BinaryTreeNode treeNode6 = new BinaryTreeNode(11);
        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode1.left=treeNode3;
        treeNode1.right=treeNode4;
        treeNode2.left=treeNode5;
        treeNode2.right=treeNode6;
        solution(treeNode);
    }
}
