//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
//
// 示例 2： 
//
// 
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == obstacleGrid.length 
// n == obstacleGrid[i].length 
// 1 <= m, n <= 100 
// obstacleGrid[i][j] 为 0 或 1 
// 
// Related Topics 数组 动态规划 
// 👍 487 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 	解答成功:
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:36.4 MB,击败了92.96% 的Java用户
     *
     */
    /*public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length==0||obstacleGrid[0].length==0)return 0;
            int m =obstacleGrid.length;
            int n =obstacleGrid[0].length;
            int [] dp =new int[n+1];
            dp[1] =obstacleGrid[0][0]==0?1:0;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i][j-1] ==1){
                    dp[j] = 0;
                }else {
                    dp[j] +=dp[j-1];
                }
            }
        }
         return dp[n];
    }*/

    /**
     * 从后往前
     * @param obstacleGrid
     * @return
     */
    /*public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length==0||obstacleGrid[0].length==0)return 0;
        int m =obstacleGrid.length;
        int n =obstacleGrid[0].length;
        int [] dp =new int[n+1];
        dp[n-1] =obstacleGrid[m-1][n-1]==0?1:0;
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (obstacleGrid[i][j] ==1){
                    dp[j] =0;
                }else {
                    dp[j] +=dp[j+1];
                }
            }
        }
        return dp[0];
    } */

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length==0||obstacleGrid[0].length==0)return 0;
        int m =obstacleGrid.length;
        int n =obstacleGrid[0].length;
        int [] dp =new int[n+1];
        dp[1] = obstacleGrid[0][0] ==0? 1:0;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i][j-1]==1){
                    dp[j]=0;
                }else {
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
