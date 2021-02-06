//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 动态规划 
// 👍 1049 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 动态规划
     * 解答成功:
     * 		执行耗时:15 ms,击败了65.77% 的Java用户
     * 		内存消耗:37.8 MB,击败了73.77% 的Java用户
     * 时间复杂度：O(Sn)，其中 S 是金额，n 是面额数。
     * 空间复杂度：O(S)。数组 dp 需要开长度为总金额 SS 的空间。
     */
    public int coinChange(int[] coins, int amount) {
        int max =amount +1;
        //用来存次数
        int[] dp =new int[amount +1];
        //开始就给赋值 比amount 大
        Arrays.fill(dp,max);
        dp[0] =0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                //当前硬币 比这个金额 要小
                if (coins[j] <= i){
                    //就把 这个
                    dp[i] =Math.min(dp[i],dp [i -coins[j]] +1);
                }
            }
        }
        //
        return dp[amount] >amount ?-1 :dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
