//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 976 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 解答成功:
     * 		执行耗时:0 ms,击败了100.00% 的Java用户
     * 		内存消耗:38.8 MB,击败了29.79% 的Java用户
     * 时间复杂度：O(n \times 2 ^ n)O(n×2n)。一共 2^n2n 个状态，每种状态需要 O(n) 的时间来构造子集。
     * 空间复杂度：O(n)。临时数组 tt 的空间代价是 O(n)，递归时栈空间的代价为 O(n)。
     *
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res =new ArrayList<>();
        recur(nums,res,new ArrayList<>(),0);
        return res;
    }
    private void  recur(int[] nums,List<List<Integer>> res,List<Integer> num,int level){
        //遍历完成 返回
        if (level == nums.length){
            res.add(new ArrayList<>(num));
            return;
        }
        //拆分成小问题来解决
        recur(nums, res, num, level+1);
        //当前层加入
        num.add(nums[level]);
        recur(nums, res, num, level+1);
        //返回相应的状态
        num.remove(num.size() -1 );
    }
}
//leetcode submit region end(Prohibit modification and deletion)
