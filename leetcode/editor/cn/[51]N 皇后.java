//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
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
// 👍 740 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 回溯算法
     * 解答成功:
     * 		执行耗时:5 ms,击败了53.28% 的Java用户
     * 		内存消耗:39.4 MB,击败了9.41% 的Java用户
     * 时间复杂度：O(N!)，其中 NN 是皇后数量。
     * 空间复杂度：O(N)，其中 NN 是皇后数量。
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions =new ArrayList<>();
        int[] queens =new int[n];
        Arrays.fill(queens,-1);
        HashSet<Integer> col =new HashSet<>();
        HashSet<Integer> pie =new HashSet<>();
        HashSet<Integer> nai =new HashSet<>();
        backtrack(solutions,queens,n,0,col,pie,nai);
        return solutions;
    }
    private void backtrack (List<List<String>> solutions,
                            int[] queens,int n, int level,
                            HashSet<Integer> col,HashSet<Integer> pie,
                            HashSet<Integer> nai){
        if(n ==level){
            //到了最底层就把 相应的结果返回
            solutions.add(generateBoard(queens,n));
        }else {
            for (int i = 0; i < n; i++) {
                int pie_n = level - i;
                int nai_n = level + i;
                //如果包含左右斜边和 列的话就跳过
                if (col.contains(i)||pie.contains(pie_n)|| nai.contains(nai_n))continue;
                //赋值
                queens[level] = i;
                col.add(i);
                pie.add(pie_n);
                nai.add(nai_n);
                //传递到下一层
                backtrack(solutions, queens, n, level+1, col, pie, nai);
                queens[level] = -1;
                col.remove(i);
                pie.remove(pie_n);
                nai.remove(nai_n);
            }
        }
    }

    /**
     * 生成结果集合
     * @param queens 皇后的列数集合
     * @param n
     * @return
     */
    private List<String> generateBoard(int[] queens,int n){
        List<String> board =new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //行
            char[] row =new char[n];
            Arrays.fill(row,'.');
            // 第i 列为放置皇后
            row[queens[i]] ='Q';
            // 组成一行
            board.add(new String(row));
        }
        return board;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
