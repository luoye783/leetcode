import common.ListNode;


public class 合并两个排序链表_非递归 {

    public static ListNode solution(ListNode node1, ListNode node2){
        if (node1==null&&node2==null){
            return null;
        }
        if (node1==null){
            return node2;
        }
        if (node2==null){
            return node1;
        }
        TempVal tempVal = removeNode(node1,node2);
        ListNode newNode = tempVal.useNode;
        ListNode currentNode = newNode;

        while (tempVal.node1!=null|| tempVal.node2!=null){
            TempVal newTempVal =removeNode(tempVal.node1,tempVal.node2);
            currentNode.next = newTempVal.useNode;
            currentNode = currentNode.next;
            tempVal = newTempVal;
        }
        return newNode;
    }
    public static class TempVal{
        ListNode node1;
        ListNode node2;
        ListNode useNode;
    }
    public static TempVal removeNode(ListNode node1,ListNode node2){
        TempVal tempVal = new TempVal();
        if (node1==null){
            tempVal.node1=null;
            tempVal.useNode = node2;
            tempVal.node2=node2.next;
            tempVal.useNode.next=null;
            return tempVal;
        }
        if (node2==null){
            tempVal.node2=null;
            tempVal.useNode = node1;
            tempVal.node1=node1.next;
            tempVal.useNode.next=null;

            return tempVal;
        }

        if (node1.val<=node2.val){
            tempVal.node2=node2;
            tempVal.useNode = node1;
            tempVal.node1=node1.next;
            tempVal.useNode.next=null;

            return tempVal;
        }else {
            tempVal.node1=node1;
            tempVal.useNode = node2;
            tempVal.node2=node2.next;
            tempVal.useNode.next=null;

            return tempVal;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;

        ListNode node21 = new ListNode(2);
        ListNode node22 = new ListNode(4);
        ListNode node23 = new ListNode(6);
        node21.next=node22;
        node22.next=node23;

        ListNode node = solution(node1,node21);
        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }
}
