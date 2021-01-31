//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 递归 
// 👍 779 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
     * 		执行耗时:0 ms,击败了100.00% 的Java用户
     * 		内存消耗:38.4 MB,击败了61.42% 的Java用户
     * 	时间复杂度 ：O（n）
     * 	空间复杂度 ：O（n）	 为它的深度
     */
    //求最大深度 等于 左右子节点的深度+1
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }else {
            int left =maxDepth(root.left);
            int right =maxDepth(root.right);
            return Math.max(left,right)+1;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
