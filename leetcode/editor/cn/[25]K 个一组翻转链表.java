//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表 
// 👍 862 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
            //用队列 时间复杂度为 o（n2）
            Deque<ListNode> stack =new ArrayDeque<>();
            ListNode dummy=new ListNode(0);
            ListNode p =dummy;
            while (true){
                int count =0;
                ListNode tmp=head;
                //移动 位置并压栈
                while (tmp!=null&& count<k){
                    ((ArrayDeque) stack).add(tmp);
                    tmp=tmp.next;
                    count ++;
                }
                //当位数不足时退出
                if (count!=k){
                    p.next =head;
                    break;
                }

                while (!((ArrayDeque) stack).isEmpty()){
                    //反向退出的 就是反转后的链表
                    p.next=stack.pollLast();
                    p=p.next;
                }
                //连接尾部
                p.next=tmp;
                head=tmp;
            }
        return dummy.next;
    }
   /* // 方法二 尾插法
    public ListNode reverseKGroup(ListNode head, int k) {
        //创建一个头部的节点
        ListNode dummy =new ListNode(0);
        //连接指向链表的头部
        dummy.next=head;
        //再建两个移动的缓存
        ListNode pre =dummy;
        ListNode end =dummy;
        //如果下一个end.next==null 没有必要循环下去了
        while (end.next!=null){
            //先把end移动到分组后的尾部
            for (int i=0;i<k&&end!=null;i++)end=end.next;
            //如果end ==null 说明后面小组的节点个数不足k个
            if (end ==null)break;
            //为反转后的下一组做准备
            ListNode start = pre.next;
            //保存好下一组
            ListNode next = end.next;
            // end.next 赋值null断开 ,因为前面一组链表需要反转了
            end.next=null;
            //头部节点指向反转后的链表
            pre.next = reverse(start);
            //连接一下组
            start.next=next;
            //来到下一组
            pre =start;
            //又处在同一起跑线上
            end=pre;
        }
        //返回反转后的头部
        return dummy.next;
    }
    //反转链表
    private ListNode reverse(ListNode head){
        ListNode prev =null;
        ListNode curr =head;
        while (curr!=null){
            ListNode temp = curr.next;
            curr.next= prev;
            prev =curr;
            curr=temp;
        }
        return prev;
    }*/

}
//leetcode submit region end(Prohibit modification and deletion)
