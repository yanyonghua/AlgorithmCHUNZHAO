//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// 👍 181 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack =new Stack<>();
        int root =Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] >root)return false;
            while (!stack.isEmpty()&& stack.peek()>postorder[i]){
                root = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }
    /**
     * 解答成功:
     * 			执行耗时:1 ms,击败了24.08% 的Java用户
     * 			内存消耗:36.1 MB,击败了15.39% 的Java用户
     *
     */
    /*
    public boolean verifyPostorder(int[] postorder) {
        //后序遍历 左右跟
        Stack<Integer> stack =new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length -1; i>= 0 ; i--) {
            //一般是跟最大的
            if (postorder[i] > root) return false;
            //前一个数和当前数比较，如果前一个比较大就把前一个抛出
            while (!stack.isEmpty()&& stack.peek()> postorder[i]){
                root = stack.pop();
            }
            //压入栈 ，add和push一样
            stack.add(postorder[i]);
        }
        return true;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
