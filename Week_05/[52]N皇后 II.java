//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯算法 
// 👍 236 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 解答成功:
     * 		执行耗时:0 ms,击败了100.00% 的Java用户
     * 		内存消耗:35.2 MB,击败了70.64% 的Java用户
     * 时间复杂度：O(N!)，其中 N 是皇后数量。
     *
     * 空间复杂度：O(N)，其中 N 是皇后数量。由于使用位运算表示，
     * 因此存储皇后信息的空间复杂度是 O(1)，
     * 空间复杂度主要取决于递归调用层数，递归调用层数不会超过 N。
     */
    public int totalNQueens(int n) {
            return solve(n,0,0,0,0);
    }

    private int solve(int n,int row,int col,int pie,int nai){
        if (n ==row){
            return 1;
        }else {
            int count =0;
            int positions = ((1<< n) -1) & (~(col | pie | nai));
            while (positions!=0){
                int position =positions & (- positions);
                positions = positions & (positions -1);
                count += solve(n, row+1, col | position, (pie| position)<<1 , (nai | position) >>1);
            }
            return count;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
