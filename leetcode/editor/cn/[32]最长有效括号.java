//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 字符串 动态规划 
// 👍 1168 👎 0


import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     *  方法一：动态规划
     * 解答成功:
     * 			执行耗时:1 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.3 MB,击败了82.26% 的Java用户
     * 时间复杂度： O(n)，其中 n 为字符串的长度。我们只需遍历整个字符串一次，即可将 dp 数组求出来。
     *
     * 空间复杂度： O(n)。我们需要一个大小为 n 的 dp 数组。
     *
     */
 /*   public int longestValidParentheses(String s) {
        int maxans =0;
        //初始化默认值为0的dp数组
        int[] dp =new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i)== ')'){
                if (s.charAt(i - 1 )=='('){
                    dp[i] =   (i >= 2? dp[i -2] :0)+2;
                    //如果 i - dp[i -1]>0 说明前面还有结成在一起的 有效括号，并且再往前一位 是'('
                }else if (i - dp[i -1]> 0 && s.charAt(i -dp[i -1]-1)=='('){
                    //如果 i -dp[i -1] >= 2 再往前有还有 结成一起的有效括号 否则+2
                    dp[i] = dp[i -1] +(i -dp[i -1] >= 2 ?dp[i - dp[i -1]- 2]:0)+2;
                }
            }
            maxans =Math.max(maxans,dp[i]);
        }
        return maxans;
    }*/

    /**
     *  栈
     * @param s
     * @return
     */
   /* public int longestValidParentheses(String s) {
        int maxans =0;
        Deque<Integer> stack =new LinkedList<>();
        //方便栈空的时候可以出栈
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            //当前字符为‘（’入栈，否则出栈
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                stack.pop();
                //如果为空说明刚刚好可以是当前下标就可以当作有效括号的对数
                if (stack.isEmpty()){
                    stack.push(i);
                }else {
                    //  当前下标对减去之前的 压入栈的下边 刚好等于 存的对数
                    maxans =Math.max(maxans,i - stack.peek());
                }
            }
        }
        return maxans;
    }*/

    public int longestValidParentheses(String s) {
        int left =0,right =0,maxlenght=0;
        //左边来一遍
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                left++;
            }else {
                right++;
            }
            if (left==right){
                //和之前的一起比较
                maxlenght = Math.max(maxlenght,2*right);
            }else if (right> left){
                //当右括号多余左括号 是以此为切割点
                left= right =0;
            }
        }
        left= right =0;
        //右边再来一遍
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) =='('){
                left++;
            }else {
                right++;
            }
            if (left ==right){
                maxlenght = Math.max(maxlenght,left*2);
            }else if (left >right){
                left = right = 0;
            }
        }
        return maxlenght;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
