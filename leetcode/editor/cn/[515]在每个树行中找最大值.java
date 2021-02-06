//您需要在二叉树的每一行中找到最大的值。 
//
// 示例： 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 122 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

import java.util.List;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    //深度优先算法

    /**
     * 解答成功:
     * 		执行耗时:1 ms,击败了100.00% 的Java用户
     * 		内存消耗:38.8 MB,击败了24.35% 的Java用户
     * 时间复杂度：O（N）
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recur(root,res,1);
        return res;
    }
    private void recur(TreeNode curr,List<Integer> res,int level){
        if (curr == null){
            return ;
        }
        if (level==res.size() +1){
            res.add(curr.val);
        }else {
            res.set(level-1,Math.max(res.get(level-1),curr.val));
        }
        recur(curr.left, res, level+1);
        recur(curr.right, res, level+1);
    }

    //广度优先算法

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了76.79%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了84.47%
     * 时间复杂度：O（N）
     * 空间复杂度：O（N）
     */
    /*public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int max = queue.peek().val;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
