//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1421 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 开数组的方法
    public int climbStairs(int n) {
        int [] dp= new int[n+1];
        dp[0] = 1;//这边需要默认 dp[0] =1;
        dp[1] = 1;
        //从2开始
        for (int i = 2; i < dp.length; i++) {
            dp[i] =dp[i-1]+ dp[i-2];
        }
        return dp[n];
    }
}
/**
 * 方法一
 *   public int climbStairs(int n) {
 *          //开启三个int 来存储之前的数据
 *         int s=0,q=0,r=1;
 *         for (int i = 1; i <= n; ++i) {
 *             s=q;
 *             q=r;
 *             r=s+q;
 *         }
 *         return r;
 *     }
 *
 *     方法二
 *
 *      public int climbStairs(int n) {
 *        double squt=Math.sqrt(5);
 *
 *         double fbln=Math.pow((1+squt)/2,n+1)-Math.pow((1-squt)/2,n+1);
 *
 *         return (int)Math.round(fbln/squt);
 *     }
 */
//leetcode submit region end(Prohibit modification and deletion)
