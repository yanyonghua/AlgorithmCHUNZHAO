//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 434 👎 0


//leetcode submit region begin(Prohibit modification and deletion)




import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * 	解答成功:
     * 		执行耗时:7 ms,击败了65.35% 的Java用户
     * 		内存消耗:59.1 MB,击败了47.44% 的Java用户
     *时间复杂度 o（n）
     *时间复杂度 o（H）
     */
    public int minDepth(TreeNode root) {
        if (root == null)return 0;
       if (root.left ==null && root.right == null)return 1;
       //直接赋值最大
       int min = Integer.MAX_VALUE;
       if (root.left!=null){
           // 取嵌套回来比较小的值
           min = Math.min(minDepth(root.left),min);
       }
       if (root.right!=null){
           min = Math.min(minDepth(root.right),min);
       }
       //此处加1表示一个循环
       return min + 1;
    }

   //使用队列来求解
    //定义一个类 包裹深度和 节点
    /**
     * 解答成功:
     * 		执行耗时:2 ms,击败了71.46% 的Java用户
     * 		内存消耗:58.1 MB,击败了83.92% 的Java用户
     *时间复杂度 o（n）
     *时间复杂度 o（n）
     */
   /* class QueueNode{
        TreeNode node;
        int wight;

       public QueueNode(TreeNode node, int wight) {
           this.node = node;
           this.wight = wight;
       }
   }
    public int minDepth(TreeNode root) {
        if (root == null)return 0;

        LinkedList<QueueNode> queue =new LinkedList<>();
        queue.offer(new QueueNode(root,1));
        while (!queue.isEmpty()){
            QueueNode queueNode= queue.poll();
          TreeNode node= queueNode.node;
          int hight = queueNode.wight;
          if (node.left==null&&node.right== null){
              return hight;
          }
          if (node.left !=null){
              queue.offer(new QueueNode(node.left,hight+1));
          }
          if (node.right !=null){
              queue.offer(new QueueNode(node.right,hight+1));
          }
        }

        return 0;
    }*/
}


//leetcode submit region end(Prohibit modification and deletion)
