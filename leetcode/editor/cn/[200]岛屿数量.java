//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 966 👎 0


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 广度优先遍历
     * 	解答成功:
     * 		执行耗时:6 ms,击败了16.41% 的Java用户
     * 		内存消耗:41 MB,击败了28.12% 的Java用户
     * 时间复杂度：O(MN)，其中 MM 和 NN 分别为行数和列数。
     * 空间复杂度：O(\min(M, N))，在最坏情况下，整个网格均为陆地，队列的大小可以达到 min(M,N)。
     */
    public int numIslands(char[][] grid) {
        if(grid==null|| grid.length==0)return 0;
        int nr =grid.length;
        int nc =grid[0].length;
        int num_islans =0;
        // 双重循环
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
             if (grid[r][c] == '1'){
                 ++num_islans;
                 grid[r][c] = '0';
                 LinkedList<Integer> queue = new LinkedList<>();
                 //压入 行和列
                 queue.add(r * nc+ c);
                 while (!queue.isEmpty()){
                   int id =  queue.remove();
                   //解析行和列
                    int row = id / nc;
                    int col = id % nc;
                    //判断边界 和是否等于1
                    if (row - 1>= 0&& grid[row -1][col] =='1'){
                        //压入队列
                        queue.add((row -1)* nc +col);
                        //置0
                        grid[row -1][col] ='0';
                    }
                    if (row + 1< nr&& grid[row +1][col] =='1'){
                        queue.add((row +1)* nc +col);
                        grid[row +1][col] ='0';
                    }
                    if (col - 1>= 0&& grid[row ][col-1] =='1'){
                        queue.add(row * nc +col-1);
                        grid[row][col-1] ='0';
                    }
                    if (col + 1< nc && grid[row][col+1] =='1'){
                        queue.add(row* nc +col+ 1);
                        grid[row ][col +1] ='0';
                    }
                 }
             }
            }
        }

        return num_islans;
    }
    /**
     * 深度优先遍历
     * 解答成功:
     * 		执行耗时:2 ms,击败了90.66% 的Java用户
     * 		内存消耗:41 MB,击败了27.39% 的Java用户
     * 时间复杂度：O(MN)，其中 MM 和 NN 分别为行数和列数。
     * 空间复杂度：O(MN)，在最坏情况下，整个网格均为陆地，深度优先搜索的深度达到 M N。
     */
   /* public int numIslands(char[][] grid) {
        if(grid==null|| grid.length==0)return 0;
        int nr = grid.length;//行
        int nc = grid[0].length;//列
        int num_islans = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                //如果发现1 向下递归
                if (grid[r][c] == '1'){
                    ++num_islans;
                    dfs(grid,r,c);
                }
            }
        }
    return num_islans;
    }
    private void dfs(char[][] grid,int r,int c){
        int nr =grid.length;
        int nc =grid[0].length;
        // 判断边界 和 具体的值是否等于‘0’
        if (r<0 || c< 0 || r>= nr|| c>=nc || grid[r][c] =='0'){
            return;
        }
        grid[r][c] ='0';
        //上下左右分别递归
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c+1);
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
