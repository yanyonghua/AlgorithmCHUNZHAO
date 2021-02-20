//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 3, n = 7
//输出：28 
//
// 示例 2： 
//
// 
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
// 
//
// 示例 3： 
//
// 
//输入：m = 7, n = 3
//输出：28
// 
//
// 示例 4： 
//
// 
//输入：m = 3, n = 3
//输出：6 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 109 
// 
// Related Topics 数组 动态规划 
// 👍 876 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 从前往后数
     * 解答成功:
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:35.2 MB,击败了69.76% 的Java用户
     * 时间复杂度：O(mn)O(mn)。
     *
     * 空间复杂度：O(mn)O(mn)，
     */
   /* public int uniquePaths(int m, int n) {
       int[][] dp= new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0|| j==0){
                    dp[i][j] =1;
                }else {
                    dp[i][j] =dp[i-1][j] +dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }*/

    /**
     * 从后往前数
     *解答成功:
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:35.3 MB,击败了37.69% 的Java用户
     *时间复杂度：O(mn)O(mn)。
     *
     * 空间复杂度：O(mn)O(mn)，
     */
    /*public int uniquePaths(int m, int n) {
       int[][] dp= new int[m][n];
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i ==m-1||j ==n-1){
                    dp[i][j] =1;
                }else {
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
            }
        }

        return dp[0][0];
    }*/

    public int uniquePaths(int m, int n) {
        int [][] dp =new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i ==m-1 || j ==n-1){
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = dp[i+1][j]+dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
