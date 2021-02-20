//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 2898 👎 0


import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res =new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i]>0)break;
            if (i>0 && nums[i]==nums[i-1])continue;
            int left =i+1, right = nums.length -1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0){
                    while (left<right && nums[left] == nums[++left] );
                }else if (sum > 0){
                    while (left<right && nums[right] == nums[--right] );
                }else {
                    ((ArrayList) res).add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));
                    while (left<right && nums[left] == nums[++left] );
                    while (left<right && nums[right] == nums[--right] );
                }
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
