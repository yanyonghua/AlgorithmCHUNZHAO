//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 123 👎 0


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



import java.util.LinkedList;

class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack =new LinkedList<Node>();
        LinkedList<Integer> res =new LinkedList<Integer>();
        if (null==root)return res;
        stack.add(root);
        while (!stack.isEmpty()){
          Node node=  stack.pollLast();
          res.addFirst(node.val);
          for(Node item:node.children){
              if (item!=null)
              stack.add(item);
          }
        }
        return res;
    }
}

/*class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack =new LinkedList<Node>();
        LinkedList<Integer> res =new LinkedList<>();
        if (root==null)return res;

        stack.add(root);
        while (!stack.isEmpty()){
           Node node = stack.pollLast();
            res.addFirst(node.val);
            //按照顺序推入栈中
           for(Node item:node.children) {
               if (item!=null){
                   stack.add(item);
               }
           }
        }
        return res;
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)
