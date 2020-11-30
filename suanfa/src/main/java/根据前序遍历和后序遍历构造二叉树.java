import common.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 根据前序遍历和后序遍历构造二叉树 {
    // 这是给定的前序遍历和后序遍历都不包含重复数字的情况
    public static BinaryTreeNode reConstruct( int[] preorder, int[] inorder){


        if (preorder==null||inorder==null||preorder.length==0||inorder.length==0){
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(preorder[0]);
        int rootInOrderIndex = findIndexFromArray(inorder,root.val);
        if (rootInOrderIndex<0){
            return null;
        }
        int[] newPreOrderListPre = new int[rootInOrderIndex];
        int[] newInorderListPre = new int[rootInOrderIndex];
        for (int i=0;i<rootInOrderIndex;i++){
            newInorderListPre[i]=inorder[i];
            newPreOrderListPre[i]=preorder[i+1];
        }

        int[] newPreOrderListOld = new int[preorder.length-rootInOrderIndex-1];
        int[] newInorderListOld = new int[preorder.length-rootInOrderIndex-1];
        for (int i=rootInOrderIndex+1;i<preorder.length;i++){
            newInorderListOld[i-rootInOrderIndex-1] = inorder[i];
            newPreOrderListOld[i-rootInOrderIndex-1]=preorder[i];
        }

        root.left = reConstruct(newPreOrderListPre,newInorderListPre);


        root.right=reConstruct(newPreOrderListOld,newInorderListOld);
        return root;

    }

    public static int findIndexFromArray(int[] arrays,int target){
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i]==target){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] preOrder = new int[8];
        preOrder[0]=1;
        preOrder[1]=2;
        preOrder[2]=4;
        preOrder[3]=7;
        preOrder[4]=3;
        preOrder[5]=5;
        preOrder[6]=6;
        preOrder[7]=8;
        int[] inOrder = new int[8];
        inOrder[0]=4;
        inOrder[1]=7;
        inOrder[2]=2;
        inOrder[3]=1;
        inOrder[4]=5;
        inOrder[5]=3;
        inOrder[6]=8;
        inOrder[7]=6;
        BinaryTreeNode root = reConstruct(preOrder,inOrder);
        System.out.println(root);
    }
}
