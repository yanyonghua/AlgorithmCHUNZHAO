//让我们一起来玩扫雷游戏！ 
//
// 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）
//地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。 
//
// 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板： 
//
// 
// 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。 
// 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。 
// 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。 
// 如果在此次点击中，若无更多方块可被揭露，则返回面板。 
// 
//
// 
//
// 示例 1： 
//
// 输入: 
//
//[['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'M', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E']]
//
//Click : [3,0]
//
//输出: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//解释:
//
// 
//
// 示例 2： 
//
// 输入: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//Click : [1,2]
//
//输出: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'X', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//解释:
//
// 
//
// 
//
// 注意： 
//
// 
// 输入矩阵的宽和高的范围为 [1,50]。 
// 点击的位置只能是未被挖出的方块 ('M' 或者 'E')，这也意味着面板至少包含一个可点击的方块。 
// 输入面板不会是游戏结束的状态（即有地雷已被挖出）。 
// 简单起见，未提及的规则在这个问题中可被忽略。例如，当游戏结束时你不需要挖出所有地雷，考虑所有你可能赢得游戏或标记方块的情况。 
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 212 👎 0


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 深度优先搜索
     * 		解答成功:
     * 		执行耗时:0 ms,击败了100.00% 的Java用户
     * 		内存消耗:39.2 MB,击败了8.76% 的Java用户
     * 		时间复杂度：O(nm)，其中 nn 和 mm 分别代表面板的宽和高。最坏情况下会遍历整个面板。
     * 空间复杂度：O(nm)。空间复杂度取决于递归的栈深度，而递归栈深度在最坏情况下有可能遍历整个面板而达到 O(nm)。
     */
    // 定义八个方向
 /*   int[] dx ={-1,1,0,0,-1,1,-1,1};
    int[] dy ={0,0,-1,1,-1,1,1,-1};
    public char[][] updateBoard(char[][] board, int[] click) {
        int x =click[0],y = click[1];
        if (board[x][y] =='M'){
            board[x][y] = 'X';
        }else {
            dfs(board,x,y);
        }
        return board;
    }
    private void dfs(char[][] board,int i ,int j){
        int cut =0;
        //查看八个方向有地雷
        for (int k = 0; k < 8; k++) {
            int x =i + dx[k];
            int y =j + dy[k];
            if (x < 0 || x >= board.length|| y< 0 ||y >= board[0].length){
                continue;
            }
            //有地雷
            if (board[x][y] == 'M'){
                ++cut ;
            }
        }
        if (cut >0){
            //添加到当前点击 的方法
            board[i][j] = (char) (cut + '0');
            return;
        }
        //没有雷就说明可以继续下一层。
        board[i][j] ='B';
        //要查看八个方向
        for (int k = 0; k < 8; k++) {
            int x =i + dx[k];
            int y =j + dy[k];
            //判断边界以及 是否为点击的地方
            if (x < 0 || x >= board.length|| y< 0 ||y >= board[0].length || board[x][y] != 'E'){
                continue;
            }
            dfs(board, x, y);
        }
    }*/
    /**
     * 解答成功:
     * 		执行耗时:4 ms,击败了19.42% 的Java用户
     * 		内存消耗:38.7 MB,击败了72.26% 的Java用户
     *时间复杂度：O(nm)，其中 nn 和 mm 分别代表面板的宽和高。最坏情况下会遍历整个面板。
     * 空间复杂度：O(nm)。我们需要 O(nm) 的标记数组来标记当前位置是否已经被加入队列防止重复计算。。
     *
     */
    // 定义八个方向
    int[] dx ={-1,1,0,0,-1,1,-1,1};
    int[] dy ={0,0,-1,1,-1,1,1,-1};
    public char[][] updateBoard(char[][] board, int[] click) {
        int x =click[0],y = click[1];
        if (board[x][y] =='M'){
            board[x][y] = 'X';
        }else {
            bfs(board,x,y);
        }
        return board;
    }
    private void bfs(char[][] board,int i ,int j){
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] vis =new boolean[board.length][board[0].length];
        queue.offer(new int[]{i,j});
        vis[i][j] = true;
        while (!queue.isEmpty()){
            int[] pos = queue.poll();
            int cut =0 ,x =pos[0],y = pos[1];
            for (int k = 0; k < 8; ++k) {
                int tx =x + dx[k];
                int ty =y + dy[k];
                if (tx < 0|| tx>= board.length||ty < 0 || ty>= board[0].length){
                    continue;
                }
                if (board[tx][ty] == 'M'){
                    ++cut;
                }
            }
            if (cut>0){
                board[x][y] = (char) (cut +'0');
            }else {
                board[x][y] ='B';
                for (int k = 0; k < 8; ++k) {
                    int tx = x + dx[k];
                    int ty = y + dy[k];
                    if (tx < 0 || tx>= board.length ||ty <0 ||
                            ty >= board[0].length ||board [tx][ty] != 'E' || vis[tx][ty]){
                        continue;
                    }
                    queue.offer(new int[]{tx,ty});
                    vis[tx][ty] =true;
                }
            }

         }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
