//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 939 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 动态规划转移方程
     *解答成功:
     * 			执行耗时:2 ms,击败了87.82% 的Java用户
     * 			内存消耗:38.3 MB,击败了38.13% 的Java用户
     * 时间复杂度：程序一次循环遍历了 nums，故渐进时间复杂度为 O(n)。
     * 空间复杂度：优化后只使用常数个临时变量作为辅助空间，与 n 无关，故渐进空间复杂度为 O(1)。
     */
    public int maxProduct(int[] nums) {
        int maxF =nums[0],minF =nums[0],ans =nums[0];
        int length =nums.length;
        for (int i = 1; i < length; i++) {
            int mx =maxF,mn=minF;
            //取当前值与前一个比较，再和当前值和最小值乘积和当前值比较
            maxF =Math.max(mx * nums[i],Math.max(nums[i],mn* nums[i]));
            //取最小值
            minF =Math.min(mn * nums[i],Math.min(nums[i],mx* nums[i]));
            ans =Math.max(maxF,ans);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
