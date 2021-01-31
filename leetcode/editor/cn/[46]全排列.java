//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1101 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 解答成功:
     * 		执行耗时:1 ms,击败了96.96% 的Java用户
     * 		内存消耗:39 MB,击败了5.65% 的Java用户
     * 时间复杂度：O（n*n!）
     * 空间复杂度：O(n)
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res =new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        // 先加进来 ，不在添加元素
        for (int num : nums) {
            out.add(num);
        }
        int n =nums.length;
        backtrack(n,out,res,0);
        return res;
    }
    private void backtrack(int n, List<Integer> out,List<List<Integer>> res,int first){
        if (n ==first){
            res.add(new ArrayList<>(out));
            return;
        }
        for (int i = first; i < n; i++) {
            //维护动态数组 交换元素
            Collections.swap(out,first,i);
            //继续下一层
            backtrack(n, out, res, first+1);
            // 恢复到原来的状态
            Collections.swap(out,first,i);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
