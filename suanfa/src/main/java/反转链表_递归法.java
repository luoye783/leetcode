import common.ListNode;

public class 反转链表_递归法 {

    public static ListNode solution(ListNode head){
        if (head==null||head.next==null){
            return head;
        }

        ListNode reversHead = solution(head.next);
        head.next.next=head;
        head.next=null;
        return reversHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        ListNode listNode = solution(node1);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
