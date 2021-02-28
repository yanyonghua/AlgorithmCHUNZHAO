//
// 
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
//isConnected[i][j] = 0 表示二者不直接相连。 
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 501 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  /*  public int findCircleNum(int[][] isConnected) {
        //深度优先算法
        int province =isConnected.length;
        int circle =0;
        boolean[] isVisited =new boolean[province];
        for (int i = 0; i < province; i++) {
            if (!isVisited[i]){
                dfs(isConnected,isVisited,province,i);
                circle++;
            }
        }
        return circle;
    }
    private void dfs(int[][] isConnected,boolean[] isVisited,int province,int i){
        for (int j = 0; j < province; j++) {
            if (isConnected[i][j] ==1&&!isVisited[j]){
                isVisited[j] =true;
                dfs(isConnected, isVisited, province, j);
            }
        }
    }

*/

    public int findCircleNum(int[][] isConnected) {
        //并查集
        int provinces =isConnected.length;
        int[] parent = new int[provinces];
        for (int i = 0; i < provinces; i++) {
            parent[i]=i;
        }
        for (int i = 0; i < provinces; i++) {
            for (int j = 0; j < provinces; j++) {
                if (isConnected[i][j]==1){
                    union(parent,i,j);
                }
            }
        }
        int circle =0;
        for (int i = 0; i < provinces; i++) {
            if (parent[i]==i){
                circle++;
            }
        }
        return circle;
    }

    /**
     * 合并
     * @param parent
     * @param index1
     * @param index2
     */
    private void union(int[] parent,int index1,int index2){
        parent[find(parent,index1)] =find(parent,index2);
    }

    /**
     * 一直找直到找到领头元素等于他自己
     * @param parent
     * @param index
     * @return
     */
    private int find(int[] parent,int index){
        if (parent[index] != index){
            parent[index] =find(parent,parent[index]);
        }
        return parent[index];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
