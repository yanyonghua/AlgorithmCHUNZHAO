//升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
// 
//
// 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// nums 肯定会在某个点上旋转 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 二分查找 
// 👍 1171 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //二分法查找
    /**
     * 解答成功:
     * 		执行耗时:0 ms,击败了100.00% 的Java用户
     * 		内存消耗:38 MB,击败了28.74% 的Java用户
     * 时间复杂度： O(\log n)，其中 n 为 nums 数组的大小。整个算法时间复杂度即为二分查找的时间复杂度 O(logn)。
     * 空间复杂度： O(1) 。我们只需要常数级别的空间存放变量。
     */
    public int search(int[] nums, int target) {
        int n =nums.length;
        if (n ==0){
            return -1;
        }
        if (n == 1){
            return nums[0] == target ?0:-1;
        }
        int l =0 ,r =n -1;
        while (l <= r){
            int mid = (l +r) / 2;
            if (nums[mid ] == target){
                return mid;
            }
            //判断起始端是否小于中位数，如果小于的话说明，这半段是单调递增的
            if (nums[0] <= nums [mid]){
                // 如果这个数有在前半段 则范围缩小为前半段，否则取后半段
                if (nums[0] <= target && target < nums[mid]){
                    r = mid -1;
                }else {
                    l = mid +1;
                }
            }else {
                //如果 中位数小于末端，说明后半段是单调递增的。
                if (nums[mid] < target&& target <= nums[n -1]){
                    l = mid +1;
                }else {
                    r = mid-1;
                }
            }
        }
        return -1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
