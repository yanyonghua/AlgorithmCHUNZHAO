//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 762 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 解答成功:
     * 		执行耗时:1 ms,击败了94.22% 的Java用户
     * 		内存消耗:38.5 MB,击败了82.09% 的Java用户
     *时间复杂度：每个点进队出队各一次，故渐进时间复杂度为 O(n)。
     * 空间复杂度：队列中元素的个数不超过 nn 个，故渐进空间复杂度为 O(n)。
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res =new ArrayList<>();
            if (root == null)
            {
                return res;
            }
            LinkedList<TreeNode> queue =new LinkedList<TreeNode>();
            queue.offer(root);
            while (!queue.isEmpty()){
                List<Integer> level =new ArrayList<>();
                int size =queue.size();
                for (int i = 0; i < size; i++) {
                   TreeNode node = queue.poll();
                   level.add(node.val);
                   if (node.left!=null){
                       queue.offer(node.left);
                   }
                   if (node.right!=null){
                       queue.offer(node.right);
                   }
                }
                res.add(level);
            }
            return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
