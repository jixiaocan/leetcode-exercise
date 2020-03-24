package everyday;

/**
 * 876. 链表的中间结点
 *
 * @Author xiaocan
 * @Date 2020/3/23 12:53
 **/
public class Question876 {
    // 定义两个指针，快指针走两步，慢指针走一步
    // 快指针到头时，慢指针正好在中间位置
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 把链表所有的元素放在数组中，然后返回数组的中间值
    public ListNode middleNode2(ListNode head) {
        ListNode[] nodes = new ListNode[100];
        int count = 0;
        while (head != null) {
            nodes[count++] = head;
            head = head.next;
        }
        return nodes[count / 2];
    }

    // 第一次遍历的时候，记录链表的长度 len，第二次遍历到 len/2 时返回该元素
    public ListNode middleNode3(ListNode head) {
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        int k = 0;
        curr = head;
        while (k < count / 2) {
            k++;
            curr = curr.next;
        }
        return curr;
    }
}


/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
