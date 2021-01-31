//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 
// 👍 1964 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    [0,1,0,2,1,0,1,3,2,1,2,1]
   /* //暴力求解
    public int trap(int[] height) {
        int sum = 0;
        int size =height.length;
        for (int i = 0; i < size - 1; i++) {
            int left = 0,right =0;
            for (int j =i; j >= 0; j-- ){
                left=Math.max(left,height[j]);
            }
            for (int j = i; j < size; j++) {
                right = Math.max(right,height[j]);
            }
            sum += Math.min(left,right)- height[i];
        }
        return sum;
    }*/
    // 用栈的方式求解  建议使用这种 这种方式 的解答 时间复杂度比暴力的低
    public int trap(int[] height) {
       int sum =0;
       int curr=0;
       Stack<Integer> stack =new Stack<>();
       while (curr< height.length){
           while (!stack.isEmpty()&& height[curr] > height[stack.peek()]){
               int h = height[stack.peek()];
               stack.pop();
               if (stack.isEmpty())break;
               int instance = curr - stack.peek()-1;
               int min =Math.min(height[curr],height[stack.peek()]);
               sum += instance*(min -h);
           }
           stack.push(curr);
           curr++;
       }
       return sum;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
