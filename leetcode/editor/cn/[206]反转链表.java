//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1449 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
    public ListNode reverseList(ListNode head) {
        return recur(head,null);
    }
   private ListNode recur(ListNode cur,ListNode pre){
       //如果到了最后一个了就返回
        if (cur==null)return pre;
       //调用递归下一个和当前个 调换位置 cur.next 有了空位
        ListNode res = recur(cur.next ,cur);
        // 赋值了
        cur.next = pre;
        return res;
    }
}
    public ListNode reverseList(ListNode head) {
        //找空位
        ListNode prev=null;
        ListNode curr=head;
        while (curr!=null){
            ListNode tempNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=tempNode;
        }
        return prev;
    }
/**
 * 方法一
 * public ListNode reverseList(ListNode head) {
 * //找空位
 *         ListNode prev=null;
 *         ListNode curr=head;
 *         while (curr!=null){
 *             ListNode tempNode=curr.next;
 *             curr.next=prev;
 *             prev=curr;
 *             curr=tempNode;
 *         }
 *         return prev;
 *     }
 *
 *     方法二
 *      public ListNode reverseList(ListNode head) {
 *
 *         return recur(head,null);
 *     }
 *     private ListNode recur(ListNode cur,ListNode pre){
 *         //如果到了最后一个了就返回
 *         if (cur==null)return pre;
 *         //调用递归下一个和当前个
 *         ListNode res=recur(cur.next,cur);
 *         //下一个的前一个
 *         cur.next=pre;
 *         return res;
 *     }
 */
//leetcode submit region end(Prohibit modification and deletion)
