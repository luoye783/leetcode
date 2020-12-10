import common.BinaryTreeNode;

public class 判断树二是否为树一的子结构 {



    public static boolean solution(BinaryTreeNode tree1,BinaryTreeNode tree2){
        if (tree2==null){
            return true;
        }
        if (tree1==null){
            return false;
        }
        boolean match = false;
        if (tree1.val==tree2.val){
            match =  doesTree1HaveTree2(tree1,tree2);
        }
        if (!match){
            match= solution(tree1.left,tree2)||solution(tree1.right,tree2);
        }
        return match;

    }
    public static boolean doesTree1HaveTree2(BinaryTreeNode tree1,BinaryTreeNode tree2){
        if (tree2==null){
            return true;
        }
        if (tree1==null){
            return false;
        }

        boolean firstMatch = false;
        if (tree1.val==tree2.val){
            firstMatch =  doesTree1HaveTree2(tree1.left,tree2.left)&&doesTree1HaveTree2(tree1.right,tree2.right);
        }
        return firstMatch;
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


        BinaryTreeNode tree2 = new BinaryTreeNode(8);
        BinaryTreeNode tree2left = new BinaryTreeNode(9);
        BinaryTreeNode tree2right = new BinaryTreeNode(2);

        tree2.left=tree2left;
        tree2.right=tree2right;

        System.out.println(solution(tree1,tree2));


    }
}
