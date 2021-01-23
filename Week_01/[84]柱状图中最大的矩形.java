//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 1148 👎 0


import java.util.Arrays;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //用栈的求法
    public int largestRectangleArea(int[] heights) {
      int n=  heights.length;
      int [] left =new int[n];
      int [] right =new int[n];
        //用n填满 right
        Arrays.fill(right,n);
        Stack<Integer> mono_stack =new Stack<>();
        for (int i = 0; i < n; i++) {
            // 如果 栈顶的高度大于或者等于当前高度
            while (!mono_stack.empty()&&heights[mono_stack.peek()]>=heights[i]){
                //保存右边下标的的边界
                right[mono_stack.peek()] =i;
                //移除栈顶
                mono_stack.pop();
            }
            //如果 栈为空的话返回-1 否则是 返回栈顶
            left[i] =(mono_stack.isEmpty()? -1:mono_stack.peek());
            //压入栈
            mono_stack.push(i);
        }

        int ans=0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans,(right[i] - left[i]-1)* heights[i]);
        }
        return ans;
    }

    /**
     *  // 方法 二 暴力求解封
     *     public int largestRectangleArea(int[] heights) {
     *         //遍历每一个柱状图的左右边界 比当前柱状图低
     *         int n = heights.length;
     *         if (n == 0) return 0;
     *         int area = 0;
     *         for (int i = 0; i < n; i++) {
     *            int curr = heights[i];
     *            //向左 移动
     *
     *             int left=i;
     *             while (left>0&& curr <=heights[ left - 1 ]){
     *                 left--;
     *             }
     *
     *             int right = i;
     *             while (right < n-1 && heights[right +1]>=curr){
     *                 right++;
     *             }
     *             //右边的下标减去左边的下标
     *             int width= right-left+1;
     *             area= Math.max(area,width*curr);
     *         }
     *     return area;
     *     }
     */

}
//leetcode submit region end(Prohibit modification and deletion)
