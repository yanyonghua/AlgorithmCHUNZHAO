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

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //使用夹逼法
        //先排序
        Arrays.sort(nums);
        //定义好返回的数组
        ArrayList<List<Integer>> ars=new ArrayList<>();
        //需要预留两个位置给其他的下标
        for (int k = 0; k < nums.length-2; k++) {
            //如果大于零三个数的和就不会变成零了
            if (nums[k]>0)break;
            // 如果k>0并且第k个数和下一个数相等就移动到下一位
            if (k>0&&nums[k]==nums[k-1])continue;
            //定义好上下界 i需要在k的右边
            int i=k+1,j=nums.length-1;
            while (i<j){
                //计算 三数之和
                int sum =nums[k]+nums[i]+nums[j];
                //如果小于零 说明i需要往右挪动 反之亦然
                if (sum<0){
                    while (i<j&&nums[i]==nums[++i]);
                }else  if (sum>0){
                    while (i<j&&nums[j]==nums[--j]);
                }else {
                    ars.add(new ArrayList<Integer>(Arrays.asList(nums[k],nums[i],nums[j])));
                    while (i<j&&nums[i]==nums[++i]);
                    while (i<j&&nums[j]==nums[--j]);
                }
            }
        }
        return ars;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
