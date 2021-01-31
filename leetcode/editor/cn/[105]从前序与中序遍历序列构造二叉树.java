//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 847 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.Stack;

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
    //方法三 迭代栈

    /**
     * 解答成功:
     * 		执行耗时:2 ms,击败了97.84% 的Java用户
     * 		内存消耗:38.6 MB,击败了42.83% 的Java用户
     * 时间复杂度 o(n) n为数组的长度
     * 空间复杂度 o(1)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0)return null;
        Stack<TreeNode> roots =new Stack<TreeNode>();
        int pre =0;
        int in = 0;
        TreeNode root =new TreeNode(preorder[pre]);
        TreeNode curt =root;
        roots.push(root);
        pre++;
        while ( pre< preorder.length){
            if (curt.val == inorder[in]){
                while (!roots.isEmpty()&&roots.peek().val == inorder[in]){
                    curt =roots.peek();
                    roots.pop();
                    in++;
                }
                curt.right = new TreeNode(preorder[pre]);
                curt =curt.right;
                roots.push(curt);
                pre++;
            }else {
                curt.left = new TreeNode(preorder[pre]);
                curt =curt.left;
                roots.push(curt);
                pre++;
            }
        }
        return root;
    }
   // 这个速度很慢
    /**
     * 	解答成功:
     * 		执行耗时:8 ms,击败了15.64% 的Java用户
     * 		内存消耗:38.9 MB,击败了17.07% 的Java用户
     *时间复杂度 o(n2)
     *空间复杂度 o(n)
     */
   /*public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0) {
            return null;
        }
        //根据前序数组的第一个元素，就可以确定根节点
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=0;i<preorder.length;++i) {
            //用preorder[0]去中序数组中查找对应的元素
            if(preorder[0]==inorder[i]) {
                //将前序数组分成左右两半，再将中序数组分成左右两半
                //之后递归的处理前序数组的左边部分和中序数组的左边部分
                //递归处理前序数组右边部分和中序数组右边部分
                int[] pre_left = Arrays.copyOfRange(preorder,1,i+1);
                int[] pre_right = Arrays.copyOfRange(preorder,i+1,preorder.length);
                int[] in_left = Arrays.copyOfRange(inorder,0,i);
                int[] in_right = Arrays.copyOfRange(inorder,i+1,inorder.length);
                root.left = buildTree(pre_left,in_left);
                root.right = buildTree(pre_right,in_right);
                break;
            }
        }
        return root;
    }*/




    //解法一、递归

    /**
     * 解答成功:
     * 		执行耗时:1 ms,击败了100.00% 的Java用户
     * 		内存消耗:38.1 MB,击败了97.91% 的Java用户
     * 时间复杂度 o（n）
     * 空间复杂度 o（1）
     */
   /* public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder,inorder,(long)Integer.MAX_VALUE +1);
    }
    int pre = 0;
    int in  = 0;
    private TreeNode buildTreeHelper(int[] preorder,int[] inorder,long stop){
        //到达末尾返回 null
        if (pre == preorder.length){
            return null;
        }
        //到达停止点返回 null
        //当前停止点已经用了，in 后移
        if (inorder[in] == stop){
            in++;
            return null;
        }
        int root_val = preorder[pre++];
        TreeNode root = new TreeNode(root_val);
        //左子树的停止点是当前的根节点
        root.left = buildTreeHelper(preorder, inorder, root_val);
        //右子树的停止点是当前树的停止点
        root.right = buildTreeHelper(preorder, inorder, stop);
        return root;
    }*/

}
//leetcode submit region end(Prohibit modification and deletion)
