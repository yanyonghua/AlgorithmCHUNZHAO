//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 131 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/



import java.util.Collections;
import java.util.LinkedList;

class Solution {
    public List<Integer> preorder(Node root) {
        LinkedList<Node> stack =new LinkedList<Node>();
        LinkedList<Integer> res =new LinkedList<>();
        if (root == null) return res;
        //压入队列
        stack.add(root);
        while (!stack.isEmpty()){
            //弹出 最后一个
           Node node= stack.pollLast();
           res.add(node.val);
           //此处需要反转
           Collections.reverse(node.children);
           for (Node item :node.children){
               //压入队列
               stack.add(item);
           }
        }
        return res;
    }

    /*public List<Integer> preorder(Node root) {
        LinkedList<Node> stack =new LinkedList<Node>();
        LinkedList<Integer> res=new LinkedList<>();
        if (root==null)return res;
        stack.add(root);
        while (!stack.isEmpty()){
           Node node= stack.pollLast();
           res.add(node.val);
            //所有子节点逆序推入栈中
            Collections.reverse(node.children);
           for (Node item: node.children){
               if (item!=null){
                   //这里不能使用push 要用add
                   stack.add(item);
               }
           }
        }
        return res;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
