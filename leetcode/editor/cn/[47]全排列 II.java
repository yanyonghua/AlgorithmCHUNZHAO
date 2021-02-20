//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 572 👎 0


import java.awt.List;
import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 外部使用 vis 来储存已经被访问过的元素
     *解答成功:
     * 			执行耗时:1 ms,击败了99.99% 的Java用户
     * 			内存消耗:39.3 MB,击败了34.90% 的Java用户
     *
     */
    boolean[] vis;
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans =new ArrayList<>();
        List<Integer> perm =new ArrayList<>();
        vis =new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,ans,0,perm);
        return ans;
    }
    private void backtrack(int[] nums, List<List<Integer>> ans, int idx, java.util.List<Integer> perm){
        if (idx ==nums.length){
            ans.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //判断如果前一个与下一个相同就跳过
            if (vis[i] || (i > 0 && nums[i] ==nums[i-1] &&!vis[i-1])){
                continue;
            }
            perm.add(nums[i]);
            vis[i] =true;
            backtrack(nums, ans, idx + 1, perm);
            vis[i] =false;
            perm.remove(idx);
        }

    }

    /**
     * 根据全排列 暴力法
     * 解答成功:
     * 			执行耗时:22 ms,击败了15.04% 的Java用户
     * 			内存消耗:39.4 MB,击败了13.37% 的Java用户
     *
     */
    /*Set<List<Integer>> set =new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
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
            //暴力法
            if (!set.contains(out)){
                set.add(out);
                res.add(new ArrayList<>(out));
            }
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
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
