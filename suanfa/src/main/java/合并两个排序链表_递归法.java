import common.ListNode;

public class 合并两个排序链表_递归法 {

    //做到链表的题，优先想递归。这样写的快可以留更多时间可以检查
    public static ListNode solution(ListNode node1, ListNode node2){
        if (node1==null){
            return node2;
        }
        if (node2==null){
            return node1;
        }
        ListNode newNode;

        if (node1.val<=node2.val){
            newNode=node1;
            newNode.next = solution(node1.next,node2);
        }else {
            newNode = node2;
            newNode.next = solution(node1,node2.next);
        }
        return newNode;

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
