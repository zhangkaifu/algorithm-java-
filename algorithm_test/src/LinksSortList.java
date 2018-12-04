package sort;
/**
 * @date 2018/12/3
 * @author qingfeng
 *归并排序的一般步骤为：
*将待排序数组（链表）取中点并一分为二；	*递归地对左半部分进行归并排序；
*递归地对右半部分进行归并排序；
*将两个半部分进行合并（merge）,得到结果。
*首先用快慢指针(快慢指针思路，快指针一次走两步，慢指针一次走一步，快指针在链表末尾时，
*慢指针恰好在链表中点)的方法找到链表中间节点，然后递归的对两个子链表排序，
*把两个排好序的子链表合并成一条有序的链表。
 */
//建立链表
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinksSortList {

    public static void main(String[] args) {

    	int n = 10;
        ListNode head = new ListNode(12);
        for (int i = 0; i < n; i++)
            head = addBack(head, (int) (Math.random() * 100));
        System.out.print("*******链表归并排序*******\n排序前:");
        print(head);

        head = new LinksSortList().sortList(head);
        System.out.print("排序后:");
        print(head);
    }
    
    public static ListNode addBack(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = null;
        ListNode node = head;
        if (head == null) {
            head = newNode;
            return head;
        }
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;

        return head;
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "\t");
            node = node.next;
        }
        System.out.println();
    }
    public static ListNode partion(ListNode head, ListNode end) {
        ListNode p1 = head, p2 = head.next;

        //走到末尾才停
        while (p2 != end) {

            //大于key值时，p1向前走一步，交换p1与p2的值
            if (p2.val < head.val) {
                p1 = p1.next;
                int temp = p1.val;
                p1.val = p2.val;
                p2.val = temp;
            }
            p2 = p2.next;
        }

        //当有序时，不交换p1和key值
        if (p1 != head) {
            int temp = p1.val;
            p1.val = head.val;
            head.val = temp;
        }
        return p1;
    }


    public ListNode sortList(ListNode head) {

        //采用归并排序
        if (head == null || head.next == null) {
            return head;
        }
        //获取中间结点
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;
        //合并
        return mergeSort(sortList(head), sortList(right));
    }

    /**
     *获取链表的中间结点,偶数时取中间第一个
     * @param head
     * @return
     */
    private ListNode getMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //快慢指针
        ListNode slow = head, quick = head;
        //快2步，慢一步
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    /**
     *
     * 归并两个有序的链表
     *
     * @param head1
     * @param head2
     * @return
     */
    private ListNode mergeSort(ListNode head1, ListNode head2) {
        ListNode p1 = head1, p2 = head2, head;
       //得到头节点的指向
        if (head1.val < head2.val) {
            head = head1;
            p1 = p1.next;
        } else {
            head = head2;
            p2 = p2.next;
        }

        ListNode p = head;
        //比较链表中的值
        while (p1 != null && p2 != null) {

            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            } else {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }
        }
        //第二条链表空了
        if (p1 != null) {
            p.next = p1;
        }
        //第一条链表空了
        if (p2 != null) {
            p.next = p2;
        }
        return head;
    }
}