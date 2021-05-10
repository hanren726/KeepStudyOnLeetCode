package 链表;

//203. 移除链表元素
//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
public class No203 {

    public static void main(String[] args) {

    }

    public ListNode removeElement(ListNode head, int target) {
        ListNode mark = new ListNode(0);
        mark.next = head;
        ListNode pre = mark;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == target) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return mark.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
