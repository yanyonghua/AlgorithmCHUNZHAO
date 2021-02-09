//假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。 
//
// 请找出其中最小的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -5000 <= nums[i] <= 5000 
// nums 中的所有整数都是 唯一 的 
// nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转 
// 
// Related Topics 数组 二分查找 
// 👍 347 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 使用二分法查找
     * 解答成功:
     * 		执行耗时:0 ms,击败了100.00% 的Java用户
     * 		内存消耗:38 MB,击败了31.53% 的Java用户
     * 时间复杂度：和二分搜索一样 O(\log N)O(logN)
     * 空间复杂度：O(1)O(1)
     */
    public int findMin(int[] nums) {
        if(nums.length == 1)return nums[0];
        int left = 0, right =nums.length -1;
        //右边大于左边 说明没有旋转
        if (nums[right] > nums[left]){
            return nums[0];
        }
        //先判断右边是否大于左边 ，是的话就说明 可以继续
        while ( right >= left ){
            int mid = left + (right - left)/2;
            // 取中间点，如果中间大于右边的值
            if (nums[mid] > nums[mid +1]){
                //返回右边
                return nums[mid +1];
            }
            //如果左边大于 中间点
            if (nums[mid -1]> nums[ mid]){
                return nums[mid];
            }
            // 中间点大于 左端点
            if (nums[mid] >nums[0]){
                left =mid +1;
            }else {
                right = mid -1;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
