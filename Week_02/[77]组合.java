//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 475 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 解答成功:
     * 		执行耗时:1 ms,击败了100.00% 的Java用户
     * 		内存消耗:39.9 MB,击败了27.25% 的Java用户
     * 		时间复杂度：O(n*k)
     * 	空间复杂度o（n）
     */
    // 回溯与剪枝
    List<List<Integer>> res =new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        // 题目上表示 这边是从1开始的
        getCombine(n,k,1,new ArrayList<>());
        return res;
    }
    private void getCombine(int n ,int k, int start ,List<Integer> list){
        if (k == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        //此处临界条件 应该是<= n - balance +1
        for (int i = start; i <= n - k + 1; i++) {
            list.add(i);
            //k已经减小了 所以外层循环就直接-k就行了
            // 开始循环的条件前面的i 已经用过了 所以+1就行了
            getCombine(n, k-1, i+1, list);
            list.remove(list.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
