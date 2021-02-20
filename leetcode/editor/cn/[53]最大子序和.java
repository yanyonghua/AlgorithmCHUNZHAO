//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：nums = [-1]
//输出：-1
// 
//
// 示例 5： 
//
// 
//输入：nums = [-100000]
//输出：-100000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2881 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 解法一 ：动态规划
     * 状态转移方程 f(x) = MAX(f（x-1）+nums[x},nums[x});
     * 解答成功:
     * 			执行耗时:1 ms,击败了93.58% 的Java用户
     * 			内存消耗:38.3 MB,击败了77.00% 的Java用户
     * 时间复杂度：O(n)，其中 nn 为 nums 数组的长度。我们只需要遍历一遍数组即可求得答案。
     * 空间复杂度：O(1)。我们只需要常数空间存放若干变量。
     */
    public int maxSubArray(int[] nums) {
        int pre =0,ansMax=nums[0];
        for (int num : nums) {
            pre = Math.max(num+pre,num);
            ansMax = Math.max(ansMax,pre);
        }
        return ansMax;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
