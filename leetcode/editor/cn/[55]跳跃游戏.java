//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心算法 数组 
// 👍 1035 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 贪心算法
     * 解答成功:
     * 		执行耗时:2 ms,击败了81.49% 的Java用户
     * 		内存消耗:40.3 MB,击败了70.78% 的Java用户
     *时间复杂度：O(n)，其中 nn 为数组的大小。只需要访问 nums 数组一遍，共 n 个位置。
     * 空间复杂度：O(1)，不需要额外的空间开销。
     */
    public boolean canJump(int[] nums) {
        int n =nums.length;
        int rightmost =0;
        for (int i = 0; i < n; i++) {
            if (i<= rightmost){
                //选择最大的数
                rightmost = Math.max(rightmost,i+nums[i]);
                //当这个数超过 数组长度之后就说明ok的
                if (rightmost >= n -1){
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
