import common.BinaryTreeNode;

public class 求二叉树的镜像 {
    public static BinaryTreeNode solution(BinaryTreeNode node){
        if (node==null){
            return null;
        }
        BinaryTreeNode tempNode = node.left;
        node.left=node.right;
        node.right =tempNode;
        solution(node.right);
        solution(node.left);
        return node;
    }

    public static void main(String[] args) {
        BinaryTreeNode tree1 = new BinaryTreeNode(8);
        BinaryTreeNode tree1left=new BinaryTreeNode(8);
        BinaryTreeNode tree1right=new BinaryTreeNode(7);
        BinaryTreeNode tree1leftleft=new BinaryTreeNode(9);
        BinaryTreeNode tree1leftright=new BinaryTreeNode(2);
        BinaryTreeNode tree1leftrightleft=new BinaryTreeNode(4);
        BinaryTreeNode tree1leftrightright=new BinaryTreeNode(7);

        tree1.left=tree1left;
        tree1.right=tree1right;
        tree1left.left=tree1leftleft;
        tree1left.right=tree1leftright;
        tree1leftright.left=tree1leftrightleft;
        tree1leftright.right=tree1leftrightright;

        solution(tree1);
        System.out.println("1111111");
    }
}
