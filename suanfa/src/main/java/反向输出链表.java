import common.ListNode;

public class 反向输出链表 {


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        solution(node1);
    }

    public static void solution(ListNode head){
        if (head==null){
            return;
        }
        solution(head.next);
        System.out.println(head.val);
    }
}

