//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 
// 👍 783 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     *解答成功:
     * 			执行耗时:3 ms,击败了85.74% 的Java用户
     * 			内存消耗:41.1 MB,击败了73.69% 的Java用户
     * 时间复杂度：O(mn)，其中 mm 和 nn 分别是网格的行数和列数。需要对整个网格遍历一次，计算 dp 的每个元素的值。
     *
     * 空间复杂度：O(mn)，其中 mm 和 nn 分别是网格的行数和列数。创建一个二维数组 dp，和网格大小相同。
     * 空间复杂度可以优化，例如每次只存储上一行的 dp 值，则可以将空间复杂度优化到 O(n)。
     *
     */
    public int minPathSum(int[][] grid) {
            if (grid ==null ||grid.length==0|| grid[0].length==0)return 0;
            int rows =grid.length,cols =grid[0].length;
            //开辟一个数组来存对应路径上面的值
            int[][] dp =new int[rows][cols];
            dp[0][0] =grid[0][0];
            //后面的数据下标都是从1开始
        for (int row = 1; row < rows; row++) {
            dp[row][0] = dp[row-1][0] + grid[row][0];
        }
        for (int col = 1; col < cols; col++) {
            dp[0][col] = dp[0][col-1] + grid[0][col];
        }
        // 累加
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                //此处先求出最小的数值再加上原来的数值
                dp[i][j] =Math.min(dp[i-1][j],dp[i][j -1] )+grid[i][j];
            }
        }
        return dp[rows -1] [cols -1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
